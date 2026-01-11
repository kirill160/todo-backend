package com.todo.todobackend.exception;

public class TaskNotFoundExeption extends RuntimeException {
    public TaskNotFoundExeption(String message) {
        super(message);
    }
    public TaskNotFoundExeption(String message, Throwable throwable){
      super(message, throwable);
    }


}
