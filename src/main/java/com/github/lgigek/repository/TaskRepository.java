package com.github.lgigek.repository;

import com.github.lgigek.models.Task;
import com.github.lgigek.models.TaskStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    Optional<Task> findByName(String name);

    List<Task> findByStatus(TaskStatus status);
}
