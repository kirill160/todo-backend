package com.todo.todobackend.service;

import com.todo.todobackend.dto.RequestToDo;
import com.todo.todobackend.dto.ToDoDTO;
import com.todo.todobackend.entity.TaskToDo;
import com.todo.todobackend.exception.TaskNotFoundExeption;
import com.todo.todobackend.mapper.ToDoMapper;
import com.todo.todobackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ToDoMapper mapper;

    public ToDoDTO createTask(RequestToDo tdo) {
        TaskToDo task = mapper.toEntity(tdo);
        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    public ToDoDTO getByID(Long id) {
        return mapper.toDTO(taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundExeption("task not found " + id)));
    }

    public ToDoDTO update(RequestToDo tdo, Long id) {
        TaskToDo task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundExeption("task not found " + id));
        task.setMessage(tdo.getMessage());
        task.setComplete(tdo.isComplete());
        task.setId(id);
         taskRepository.save(task);
        return mapper.toDTO(task);

    }

    public void deleteByID(Long id) {
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundExeption("task not found " + id);
        }
        taskRepository.deleteById(id);
    }

    public List<ToDoDTO> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

}
