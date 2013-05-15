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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * The type EconomyCreditProcessor
 *
 * @author Peter Pilgrim (peter)
 */
@Economy
public class EconomyCreditProcessor implements CreditProcessor {

    @Override
    public void check(String account) {
        if ( !account.trim().startsWith("E")) {
            throw new RuntimeException("account:["+account+"] is not valid!");
        }
        System.out.printf("Account [%s] is Okay\n", account );
    }

    @PostConstruct
    public void acquireResource() {
        System.out.println( this.getClass().getSimpleName()+"#acquireResource()" );
    }

    @PreDestroy
    public void releaseResource() {
        System.out.println( this.getClass().getSimpleName()+"#releaseResource()" );
    }
}
