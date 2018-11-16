package com.github.lgigek.business;

import com.github.lgigek.models.Task;
import com.github.lgigek.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskBusiness {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        return taskRepository.save(task);
    }
}
