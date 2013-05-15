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

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The type SupportHelpDesk
 *
 * @author Peter Pilgrim
 */
@Stateless
public class SupportHelpDesk {
    private List<String> agents = Arrays.asList(
            "Agnes", "Brian", "Harry", "Sally", "Tom", "Pamela",
            "Mark", "Wendy", "Marcia", "Graeme", "Pravztik",
            "Hadeep", "Florence", "Robert", "Zoe", "Frank");

    private Random rnd = new Random(new Date().getTime());
    public String getNextAgentName() {
        int x = rnd.nextInt(10000);
        return String.format("%s%05d", agents.get(x % agents.size()), x );
    }
}
