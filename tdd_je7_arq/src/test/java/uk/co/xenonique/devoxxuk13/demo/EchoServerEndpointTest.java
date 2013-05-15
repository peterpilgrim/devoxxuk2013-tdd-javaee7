/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Developers:
 * Peter Pilgrim 	-- initial API and implementation
 * 			-- Blog: http://www.xenonique.co.uk/blog/
 *			-- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package uk.co.xenonique.devoxxuk13.demo;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.*;
import org.junit.runner.RunWith;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/**
 * Verifies the operation of the EchoServerEndpointTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
public class EchoServerEndpointTest {

    @ArquillianResource private URL baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addClasses(EchoServerEndpoint.class)
                .addClasses(EchoClientSenderEndpoint.class)
                .addAsWebInfResource(
                    EmptyAsset.INSTANCE, "beans.xml");
        return webArchive;
    }

    @Test
    public void shouldInvokeEchoServerEndpoint() throws Exception {
        final String message = "Hello London";

        System.out.printf("****  START  ****\n");
        URI uri = URI.create(
                (baseURL.toExternalForm()+"echo").replace("http:","ws:") );
        System.out.printf("uri=%s\n", uri ) ;
        EchoClientSenderEndpoint client = new EchoClientSenderEndpoint(
                uri.toString() , message );

        client.makeConnection();
        System.out.printf("****  WAIT   ****\n");

        String actual = client.getReceivedMessage( 3000 );
        assertEquals("ECHO: "+message,actual);

        System.out.printf("****  DONE   ****\n");
    }
}
