package com.todo.api;

import com.todo.api.types.TodoItem;
import com.todo.api.types.TodoItemRequest;
import com.todo.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {

    @Inject
    TodoService service;

    @GET
    public TodoItem[] getAllItems() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public TodoItem getSingleItem(@PathParam("id") String itemId) {
        return service.get(itemId);
    }

    @PUT
    @Path("/{id}")
    public void updateItem(@PathParam("id") String itemId, TodoItemRequest todoItemRequest) {
        service.update(itemId, todoItemRequest);
    }

    @POST
    public TodoItem createItem(TodoItemRequest itemRequest) {
        return service.create(itemRequest);
    }

    @DELETE
    @Path("/{id}")
    public void removeItem(@PathParam("id") String itemId) {
        service.remove(itemId);
    }
}