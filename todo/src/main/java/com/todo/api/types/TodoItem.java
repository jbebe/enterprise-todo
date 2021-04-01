package com.todo.api.types;

import com.todo.api.Utils;

public class TodoItem {

    public String id;
    public String title;
    public String content;

    public TodoItem(TodoItemRequest itemRequest) {
        id = Utils.generateId();
        title = itemRequest.title;
        content = itemRequest.content;
    }

    public void merge(TodoItem todoItem) {
        title = todoItem.title;
        content = todoItem.content;
    }
}
