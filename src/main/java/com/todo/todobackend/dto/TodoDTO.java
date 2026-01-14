package com.todo.todobackend.dto;


import lombok.Value;

@Value
public class TodoDTO {
    private final Long id;
    private final String message;
    private final boolean complete;
}
