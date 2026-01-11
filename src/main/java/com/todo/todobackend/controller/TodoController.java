package com.todo.todobackend.controller;


import com.todo.todobackend.dto.RequestToDo;
import com.todo.todobackend.dto.ToDoDTO;
import com.todo.todobackend.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TodoController {
    @Autowired
    private TaskService service;

    @PostMapping()
    public ResponseEntity<ToDoDTO> createTask(@RequestBody @Valid RequestToDo requestToDoDto) {
        return ResponseEntity.ok(service.createTask(requestToDoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getTask(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(service.getByID(id));

    }

    @GetMapping()
    public ResponseEntity<List<ToDoDTO>> getAllTasks() {
    List<ToDoDTO> listTasks = service.getAll();
    return ResponseEntity.ok(listTasks);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<ToDoDTO> updateTask(@RequestBody @Valid RequestToDo requestToDoDto, @PathVariable Long id){
        return  ResponseEntity.ok(service.update(requestToDoDto, id));
    }



}
