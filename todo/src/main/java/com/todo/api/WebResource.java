package com.todo.api;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Objects;

@Path("/static")
@Produces(MediaType.TEXT_HTML)
public class WebResource {

    @Inject
    ServletContext context;

    @GET
    public Response getAllItems() {
        InputStream resource = context.getResourceAsStream("/WEB-INF/classes/WEB-INF/index.html");

        return Objects.isNull(resource)
                ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.ok().entity(resource).build();
    }
}