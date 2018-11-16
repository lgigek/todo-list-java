package com.github.lgigek.business;

import com.github.lgigek.helpers.exceptions.TaskAlreadyCreatedException;
import com.github.lgigek.models.Task;
import com.github.lgigek.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskBusiness {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        if (taskRepository.findByName(task.getName()).isPresent())
            throw new TaskAlreadyCreatedException(task.getName());
        return taskRepository.save(task);
    }
}
