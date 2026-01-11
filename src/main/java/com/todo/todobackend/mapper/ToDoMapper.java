package com.todo.todobackend.mapper;

import com.todo.todobackend.dto.RequestToDo;
import com.todo.todobackend.dto.ToDoDTO;
import com.todo.todobackend.entity.TaskToDo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {
    public ToDoDTO toDTO(@NotNull TaskToDo task) {
        return new ToDoDTO(task.getId(), task.getMessage(), task.isComplete());
    }
    public TaskToDo toEntity(@NotNull RequestToDo req){
        TaskToDo task = new TaskToDo();
        task.setMessage(req.getMessage());
        task.setComplete(req.isComplete());

        return task;
    }

}
