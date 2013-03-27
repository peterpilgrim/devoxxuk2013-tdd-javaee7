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
