package org.eclipse.jakarta.resource;

import java.util.List;

import org.eclipse.jakarta.dao.BookDao;
import org.eclipse.jakarta.model.Book;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/books")
public class BookResouce {

    @Inject
    BookDao bookDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(Book book) {
        bookDao.add(book);
        return Response.status(Status.CREATED).build();
    }
}
