package com.todo.api;

import com.todo.api.types.TodoItem;
import com.todo.api.types.TodoItemRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {

    private static final Map<String, TodoItem> Db = new HashMap<>();

    @GET
    public TodoItem[] getAllItems() {
        return Db.values().toArray(new TodoItem[Db.size()]);
    }

    @GET
    @Path("/{id}")
    public TodoItem getSingleItem(@PathParam("id") String itemId) {
        return Db.get(itemId);
    }

    @PUT
    @Path("/{id}")
    public void updateItem(@PathParam("id") String itemId, TodoItemRequest todoItemRequest) {
        TodoItem dbItem = getSingleItem(itemId);
        dbItem.merge(todoItemRequest);
    }

    @POST
    public TodoItem createItem(TodoItemRequest itemRequest) {
        TodoItem item = new TodoItem(itemRequest);
        Db.put(item.id, item);
        return item;
    }

    @DELETE
    @Path("/{id}")
    public void deleteItem(@PathParam("id") String itemId) {
        Db.remove(itemId);
    }
}