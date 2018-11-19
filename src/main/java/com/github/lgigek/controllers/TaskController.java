package com.github.lgigek.controllers;

import com.github.lgigek.business.TaskBusiness;
import com.github.lgigek.models.Task;
import com.github.lgigek.models.TaskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
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

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Task> get() {

        logger.info("Returning all tasks.");

        return taskBusiness.getAllTasks();
    }

    @RequestMapping(value = "getByStatus", method = RequestMethod.GET)
    public List<Task> getByStatus(@RequestHeader(value = "status") TaskStatus status) {

        logger.info("Returning tasks with status \"{}\"", status);

        return taskBusiness.getTaskByStatus(status);
    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public Task getByName(@RequestHeader(value = "name") String taskName) {

        logger.info("Returning task named \"{}\".", taskName);

        return taskBusiness.getTaskByName(taskName);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value = "name") String taskName) {

        logger.info("Deleting task named \"{}\".", taskName);

        taskBusiness.deleteByName(taskName);
    }

}
