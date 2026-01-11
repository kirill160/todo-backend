package com.todo.todobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class RequestToDo {
    @NotBlank(message = "задача обязательна")
    @Size(min = 5, max = 200)
    private String message;

    private boolean complete;
}
