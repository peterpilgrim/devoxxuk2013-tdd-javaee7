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

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.xenonique.devoxxuk13.demo.Economy;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;


@RunWith(Arquillian.class)
public class EconomyCreditProcessorTest {

    @Deployment
    public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClasses(Economy.class,
                CreditProcessor.class,
                EconomyCreditProcessor.class )
			.addAsManifestResource(
                    EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;			
    }

    private @Inject @Economy CreditProcessor processor;

    @Test
    public void should_give_user_economy_credit() {
        System.out.printf("processor = %s\n", processor );
        assertNotNull(processor);
        processor.check("E777");
    }
} 	

