package com.github.lgigek.business;

import com.github.lgigek.helpers.exceptions.TaskAlreadyCreatedException;
import com.github.lgigek.helpers.exceptions.TaskNotFoundException;
import com.github.lgigek.models.Task;
import com.github.lgigek.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskBusiness {

    private static final Logger logger = LoggerFactory.getLogger(TaskBusiness.class);

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        if (taskRepository.findByName(task.getName()).isPresent())
            throw new TaskAlreadyCreatedException(task.getName());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public Task getTaskByName(String taskName) {

        Optional<Task> task = taskRepository.findByName(taskName);
        if (task.isPresent()) {
            logger.debug("Task named \"{}\" has been found", taskName);
            return task.get();
        } else
            throw new TaskNotFoundException(taskName);
    }

    public void deleteByName(String taskName) {

        Optional<Task> task = taskRepository.findByName(taskName);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else
            throw new TaskNotFoundException(taskName);
    }
}
