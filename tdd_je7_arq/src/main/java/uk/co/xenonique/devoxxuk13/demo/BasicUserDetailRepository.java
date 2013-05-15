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

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * The type BasicUserDetailRepository
 *
 * @author Peter Pilgrim (peter)
 */
@ApplicationScoped
public class BasicUserDetailRepository implements UserDetailRepository {


    private ConcurrentMap<String,User> users = new ConcurrentHashMap<>();

    @Override
    public boolean authenticate(User user) {
        return users.containsKey(user.getUsername()) && (
                user.getUsername().equals("ppilgrim") ||
                user.getUsername().equals("admin") );
    }

    @Override
    public void createUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public boolean deleteUser(User user) {
        return users.remove(user.getUsername()) != null;
    }

    @Override
    public boolean containsUser(User user) {
        return users.containsKey(user.getUsername());
    }
}
