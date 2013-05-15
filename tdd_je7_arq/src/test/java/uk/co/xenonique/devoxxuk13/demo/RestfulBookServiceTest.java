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

import javax.ejb.*;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.*;
import org.junit.runner.RunWith;

import java.net.URI;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

/**
 * Verifies the operation of the RestfulBookServiceTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
public class RestfulBookServiceTest {

    @ArquillianResource
    private URL baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addClasses(RestfulBookService.class)
                .addAsWebInfResource(
                        EmptyAsset.INSTANCE, "beans.xml");
        return webArchive;
    }

    @Test
    public void shouldRetrieveListOfBooksAsPlainText() throws NoSuchAlgorithmException {
        URI uri = URI.create(
                (baseURL.toExternalForm()+"great/books" ) );
        System.out.printf("uri=%s\n", uri ) ;

        // Client client = ClientBuilder.newBuilder().build();
        // ClientBuilder.newBuilder().sslContext(SSLConfigurator.newInstance(false).createSSLContext()).build();
        Client client = ClientBuilder.newBuilder().sslContext(SSLContext.getDefault()).build();
        WebTarget target = client.target(uri.toString());
        Response response = target.request().get();
        System.out.printf("response=%s", response);
        assertEquals(200, response.getStatus());
        assertTrue( response.getLength() > 0);
        System.out.printf(response.toString());
    }
}
