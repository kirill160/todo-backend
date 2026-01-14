package com.todo.todobackend.service;

import com.todo.todobackend.dto.RequestTodo;
import com.todo.todobackend.dto.TodoDTO;
import com.todo.todobackend.entity.Task;
import com.todo.todobackend.exception.TaskNotFoundExeption;
import com.todo.todobackend.mapper.TodoMapper;
import com.todo.todobackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TodoMapper mapper;

    public TodoDTO createTask(RequestTodo tdo) {
        Task task = mapper.toEntity(tdo);
        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    public TodoDTO getByID(Long id) {
        return mapper.toDTO(taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundExeption("task not found id " + id)));
    }
    @Transactional
    public TodoDTO update(RequestTodo tdo, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundExeption("task not found id " + id));
        task.setMessage(tdo.getMessage());
        task.setComplete(tdo.isComplete());
         taskRepository.save(task);
        return mapper.toDTO(task);

    }
    @Transactional
    public void deleteByID(Long id) {
        taskRepository.deleteById(id);
    }

    public List<TodoDTO> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

}
