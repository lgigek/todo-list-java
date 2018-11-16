package com.github.lgigek.controllers;

import com.github.lgigek.models.Task;
import com.github.lgigek.business.TaskBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskBusiness taskBusiness;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody Task task) {

        logger.info("Creating a new task with name \"{}\"", task.getName());

        taskBusiness.createTask(task);

        logger.info("Task created successfully");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
