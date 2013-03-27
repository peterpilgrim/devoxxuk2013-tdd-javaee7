package uk.co.xenonique.devoxxuk13.demo;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * The type EchoClientSenderEndpoint
 *
 * @author Peter Pilgrim
 */
public class EchoClientSenderEndpoint extends Endpoint {

    private CountDownLatch messageLatch;

    private String urlTemplateLink;
    private String receivedMessage;
    private String message;


    public EchoClientSenderEndpoint(String urlTemplateLink, String message) {
        this.urlTemplateLink = urlTemplateLink;
        this.message = message;
    }

    public void makeConnection() throws IOException, DeploymentException, URISyntaxException {
        messageLatch = new CountDownLatch(2);
        final ClientEndpointConfig config = ClientEndpointConfig.Builder.create().build();
        System.out.printf("%s.makeConnection() config=%s\n",
                getClass().getSimpleName(), config);

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        System.out.printf("container=%s\n", container);
        container.connectToServer( this, config, new URI(urlTemplateLink) );
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        final RemoteEndpoint.Basic remote = session.getBasicRemote();

        System.out.printf("%s.onOpen( session = [%s], config = [%s] )\n",
                getClass().getSimpleName(), session, config);

        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                receivedMessage = message;
                messageLatch.countDown();
                System.out.printf("%s.onMessage() receivedMessage=%s\n",
                        getClass().getSimpleName(), receivedMessage);
            }
        });

        try {
            session.getBasicRemote().sendText(message);
            messageLatch.countDown();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public String getReceivedMessage(int milliseconds ) {
        try {
            messageLatch.await( milliseconds, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
        return receivedMessage;
    }
}
