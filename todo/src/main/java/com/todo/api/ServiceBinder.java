package com.todo.api;

import com.todo.service.TodoService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {

    @Override
    protected void configure()
    {
        bind(TodoService.class).to(TodoService.class).in(Singleton.class);
    }
}
