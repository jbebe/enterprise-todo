package com.todo.api.types;

import com.todo.api.Utils;

public class TodoItem {

    public String id;
    public String title;
    public String content;

    public TodoItem(TodoItemRequest itemRequest, String id) {
        this.id = id;
        title = itemRequest.title;
        content = itemRequest.content;
    }

    public TodoItem(TodoItemRequest itemRequest) {
        this(itemRequest, Utils.generateId());
    }

    public void merge(TodoItemRequest todoItem) {
        title = todoItem.title;
        content = todoItem.content;
    }
}
