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

package uk.co.xenonique.devoxxuk13.common.webcontainer.glassfish;

import uk.co.xenonique.devoxxuk13.common.webcontainer.glassfish.AbstractEmbeddedRunner;

import java.util.Scanner;

/**
 * The type EmbeddedRunner
 *
 * @author Peter Pilgrim
 */
public class EmbeddedRunner extends AbstractEmbeddedRunner {

    public EmbeddedRunner(int port) {
        super(port);
    }

    public static void main(String args[]) throws Exception {
        EmbeddedRunner runner = (EmbeddedRunner) new EmbeddedRunner(8080).init().start();

        runner.deployWithRename("build/libs/devoxxuk2013-tdd-je7-emgf-1.0.war", "mywebapp");
        Thread.sleep(1000);
        System.out.printf("**** Press the ENTER key to stop the server ****\n");
        Scanner sc = new Scanner(System.in);
        while(!sc.nextLine().equals(""));
        runner.stop();
        System.out.printf("**** Embedded GlassFish Runner DONE! ****");
    }
}
