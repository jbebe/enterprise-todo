package com.todo.service;

import com.todo.api.types.TodoItem;
import com.todo.api.types.TodoItemRequest;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class TodoService {

    private static final Map<String, TodoItem> Db = new HashMap<>();

    public TodoItem[] getAll(){
        return Db.values().toArray(new TodoItem[Db.size()]);
    }

    public TodoItem get(String itemId) {
        return Db.get(itemId);
    }

    public void update(String itemId, TodoItemRequest todoItemRequest) {
        TodoItem dbItem = get(itemId);
        dbItem.merge(todoItemRequest);
    }

    public TodoItem create(TodoItemRequest itemRequest) {
        TodoItem item = new TodoItem(itemRequest);
        Db.put(item.id, item);
        return item;
    }

    public void remove(String itemId) {
        Db.remove(itemId);
    }

}
