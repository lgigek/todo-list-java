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

import static com.github.lgigek.controllers.components.UrlBuilder.*;

@RestController
@RequestMapping(REQUEST_PATH_API)
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskBusiness taskBusiness;

    @GetMapping(value = REQUEST_PATH_TASK_GET_ALL)
    public List<Task> tasks() {

        logger.info("REST request to return all Tasks");

        return taskBusiness.getAllTasks();
    }

    @GetMapping(value = REQUEST_PATH_TASK_GET_OR_DELETE)
    public Task getByName(@PathVariable String name) {

        logger.info("REST request to get Task: {}", name);

        return taskBusiness.getTaskByName(name);
    }

    @PostMapping(value = REQUEST_PATH_TASK_POST_OR_PUT)
    public ResponseEntity create(@RequestBody Task task) {

        logger.info("REST request to save Task: {}", task.getName());

        taskBusiness.createTask(task);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = REQUEST_PATH_TASK_POST_OR_PUT)
    public void delete(@PathVariable String name) {

        logger.info("REST request to delete Task: {}", name);

        taskBusiness.deleteByName(name);
    }

}
