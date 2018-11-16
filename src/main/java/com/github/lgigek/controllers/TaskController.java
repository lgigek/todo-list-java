package com.github.lgigek.controllers;

import com.github.lgigek.models.Task;
import com.github.lgigek.business.TaskBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskBusiness taskBusiness;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody Task task) {

        taskBusiness.createTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
