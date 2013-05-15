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
import org.junit.*;

public class TraditionalUnitTest {

    // Notice the static declaration here
    static UserDetailRepository userDetailRepo = new BasicUserDetailRepository();

    @Test
    public void shouldCreateUser() {
        User user = new User("frostj", "Jack", "Frost");
        assertFalse( userDetailRepo.containsUser(user ));

        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.containsUser(user ));
    }


    @Test
    public void shouldDeleteUser() {
        User user = new User("frostj", "Jack", "Frost");
        assertTrue( userDetailRepo.containsUser(user ));

        userDetailRepo.deleteUser(user);
        assertFalse( userDetailRepo.containsUser(user ));
    }


    @Test
    public void shouldAuthenticateUser() {
        User user = new User("admin", "System", "Administrator");

        assertFalse( userDetailRepo.authenticate(user ));
        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.authenticate(user ));
    }
}

