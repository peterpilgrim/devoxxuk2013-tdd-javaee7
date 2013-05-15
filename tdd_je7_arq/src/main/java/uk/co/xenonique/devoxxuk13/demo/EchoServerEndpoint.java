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

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * The type EchoServerEndpoint
 *
 * @author Peter Pilgrim
 */

@ServerEndpoint(value = "/echo")
public class EchoServerEndpoint {

    @OnMessage
    public String makeEcho( String text ) {
        return "ECHO: "+text;
    }

    @OnOpen
    public void open( Session session ) {
        System.out.printf("%s.open( session=%s)\n",
                getClass().getSimpleName(), session );
    }

    @OnClose
    public void close( Session session ) {
        System.out.printf("%s.close( session=%s)\n",
                getClass().getSimpleName(), session );
    }

    @OnError
    public void error( Session session, Throwable error ){
        System.out.printf("%s.error( session=%s, error=%s )\n",
                getClass().getSimpleName(), session, error );
    }

}
