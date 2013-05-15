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
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * A unit test BasicUserDetailRepositoryTest to verify the operation of BasicUserDetailRepositoryTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
public class BasicUserDetailRepositoryTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(BasicUserDetailRepository.class,
                        UserDetailRepository.class,
                        User.class)
                .addAsManifestResource(
                        EmptyAsset.INSTANCE,
                        "beans.xml");
        return jar;
    }

    @Inject
    private UserDetailRepository userDetailRepo;

    @Test
    @InSequence(0)
    public void shouldCreateUserInRepo() {
        User user = new User("frostj", "Jack", "Frost");
        assertFalse( userDetailRepo.containsUser(user ));

        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.containsUser(user ));
    }

    @Test
    @InSequence(1)
    public void shouldDeleteUserFromRepo() {
        User user = new User("frostj", "Jack", "Frost");
        assertTrue( userDetailRepo.containsUser(user ));

        userDetailRepo.deleteUser(user);
        assertFalse( userDetailRepo.containsUser(user ));
    }

    @Test
    public void shouldAuthenticateUserInsideRepo() {
        User user = new User("admin", "System", "Administrator");

        assertFalse( userDetailRepo.authenticate(user ));
        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.authenticate(user ));
    }
}
