package uk.co.xenonique.devoxxuk13.demo;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.*;
import org.junit.runner.RunWith;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/**
 * Verifies the operation of the EchoServerEndpointTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
public class EchoServerEndpointTest {

    @ArquillianResource private URL baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addClasses(EchoServerEndpoint.class)
                .addClasses(EchoClientSenderEndpoint.class)
                .addAsWebInfResource(
                    EmptyAsset.INSTANCE, "beans.xml");
        return webArchive;
    }

    @Test
    public void shouldInvokeEchoServerEndpoint() throws Exception {
        final String message = "Hello London";

        System.out.printf("****  START  ****\n");
        URI uri = URI.create(
                (baseURL.toExternalForm()+"echo").replace("http:","ws:") );
        System.out.printf("uri=%s\n", uri ) ;
        EchoClientSenderEndpoint client = new EchoClientSenderEndpoint(
                uri.toString() , message );

        client.makeConnection();
        System.out.printf("****  WAIT   ****\n");

        String actual = client.getReceivedMessage( 3000 );
        assertEquals("ECHO: "+message,actual);

        System.out.printf("****  DONE   ****\n");
    }
}
