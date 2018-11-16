package com.github.lgigek.helpers.exceptions;

public class TaskNotFoundException extends RuntimeException {

    private static final String message = "Task with name \"%s\" not found";

    public TaskNotFoundException(String taskName) {

        super(String.format(message, taskName));
    }
}
