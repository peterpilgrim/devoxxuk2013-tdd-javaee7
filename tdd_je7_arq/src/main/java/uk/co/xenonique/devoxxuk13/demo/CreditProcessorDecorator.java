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

import uk.co.xenonique.devoxxuk13.demo.CreditProcessor;
import uk.co.xenonique.devoxxuk13.demo.Premium;
import uk.co.xenonique.devoxxuk13.demo.SanctionService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * The type CreditProcessorDecorator
 *
 * @author Peter Pilgrim (peter)
 */
@Decorator
@Premium
public class CreditProcessorDecorator implements CreditProcessor {

    @Inject private SanctionService sanctionService;
    @Inject @Delegate @Premium private CreditProcessor processor;

    @Override
    public void check(String account) {
        System.out.println("Inside the CreditProcessorDecorator#check() ");
        sanctionService.sanction(account, "EURGBP");
        processor.check(account);
        System.out.println("End of the CreditProcessorDecorator#check() ");
    }
}
