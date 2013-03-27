package uk.co.xenonique.devoxxuk13.demo;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * The type EchoServerEndpoint
 *
 *
 * @author Peter Pilgrim
 */
@ServerEndpoint(value = "/echo")
public class EchoServerEndpoint {

    @OnOpen
    public void open( Session session ) {
        System.out.printf("%s.open( session=%s)\n", getClass().getSimpleName(), session );
    }

    @OnClose
    public void close( Session session ) {
        System.out.printf("%s.close( session=%s)\n", getClass().getSimpleName(), session );
    }

    @OnError
    public void error( Session session, Throwable error ){
        System.out.printf("%s.error( session=%s, error=%s )\n", getClass().getSimpleName(), session, error );
    }

    @OnMessage
    public String makeEcho( String text ) {
        return "ECHO: "+text;
    }
}


// ws://localhost:8080/mywebapp/echo

// http://www.websocket.org/echo.html
