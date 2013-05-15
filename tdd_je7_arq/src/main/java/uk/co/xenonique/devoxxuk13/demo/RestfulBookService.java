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

import javax.ws.rs.*;
import java.util.Arrays;
import java.util.List;

/**
 * The type RestfulBookService
 *
 * @author Peter Pilgrim
 */
@Path("/great/books")
public class RestfulBookService {

    List<Book> products = Arrays.asList(
        new Book("Sir Arthur Dolan Coyle", "Sherlock Holmes and the Hounds of the Baskerville"),
        new Book("Dan Brown", "Da Vinci Code"),
        new Book("Charles Dickens", "Great Expectations"),
        new Book("Robert Louis Stevenson", "Treasure Island"));

    @GET
    @Produces("text/plain")
    public String getList() {
        StringBuffer buf = new StringBuffer();
        for (Book b: products) { buf.append(b.title); buf.append('\n'); }
        return buf.toString();
    }

    static class Book {
        public final String author;
        public final String title;

        Book(String author, String title) {
            this.author = author;
            this.title = title;
        }
    }
}
