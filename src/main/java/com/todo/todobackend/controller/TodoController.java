package com.todo.todobackend.controller;


import com.todo.todobackend.dto.RequestTodo;
import com.todo.todobackend.dto.TodoDTO;
import com.todo.todobackend.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TodoController {
    @Autowired
    private TaskService service;

    @PostMapping()
    public ResponseEntity<TodoDTO> createTask(@RequestBody @Valid RequestTodo requestToDoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTask(requestToDoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTask(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(service.getByID(id));

    }

    @GetMapping()
    public ResponseEntity<List<TodoDTO>> getAllTasks() {
    List<TodoDTO> listTasks = service.getAll();
    return ResponseEntity.ok(listTasks);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTask(@RequestBody @Valid RequestTodo requestTodoDto, @PathVariable Long id){
        return  ResponseEntity.ok(service.update(requestTodoDto, id));
    }



}
