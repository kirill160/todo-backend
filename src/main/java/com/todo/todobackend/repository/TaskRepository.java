package com.todo.todobackend.repository;

import com.todo.todobackend.entity.TaskToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskToDo, Long> {

}
