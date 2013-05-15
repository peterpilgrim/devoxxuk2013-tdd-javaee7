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

package uk.co.xenonique.devoxxuk13.embedded;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type SampleSingleton
 *
 * @author Peter Pilgrim
 */
@Singleton
public class SampleSingleton {
    private AtomicInteger counter = new AtomicInteger(5000);
    @PostConstruct
    public void init() {
        System.out.printf(">>>> %s.init() called\n",
                getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.printf(">>>> %s.destroy() called\n",
                getClass().getSimpleName());
    }

    public int count() {
        return counter.getAndAdd(2);
    }

    public String getFullName() {
        return "Peter Pilgrim";
    }
}
