package com.github.lgigek.controllers;

import com.github.lgigek.business.TaskBusiness;
import com.github.lgigek.models.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskBusiness taskBusiness;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Task task) {

        logger.info("Creating a new task with name \"{}\".", task.getName());

        taskBusiness.createTask(task);

        logger.info("Task named \"{}\" was created successfully.", task.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "getAllTasks", method = RequestMethod.GET)
    public List<Task> getAllTasks() {

        logger.info("Returning all tasks.");

        return taskBusiness.getAllTasks();
    }

    @RequestMapping(value = "getTaskByName", method = RequestMethod.GET)
    public Task getTaskByName(@RequestHeader(value = "name") String taskName) {

        logger.info("Returning task named \"{}\".", taskName);

        return taskBusiness.getTaskByName(taskName);
    }
}
