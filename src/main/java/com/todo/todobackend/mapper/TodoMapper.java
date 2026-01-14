package com.todo.todobackend.mapper;

import com.todo.todobackend.dto.RequestTodo;
import com.todo.todobackend.dto.TodoDTO;
import com.todo.todobackend.entity.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoDTO toDTO(@NotNull Task task) {
        return new TodoDTO(task.getId(), task.getMessage(), task.isComplete());
    }
    public Task toEntity(@NotNull RequestTodo req){
        Task task = new Task();
        task.setMessage(req.getMessage());
        task.setComplete(req.isComplete());

        return task;
    }

}
