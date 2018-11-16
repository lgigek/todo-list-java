package com.github.lgigek.helpers.exceptions;

public class TaskAlreadyCreatedException extends RuntimeException{

    private static final String message = "There is a task already created with the same name. Task name \"%s\".";

    public TaskAlreadyCreatedException(String taskName){

        super(String.format(message, taskName));
    }
}
