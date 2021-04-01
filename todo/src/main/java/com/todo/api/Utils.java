package com.todo.api;

import java.util.UUID;

public class Utils {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
