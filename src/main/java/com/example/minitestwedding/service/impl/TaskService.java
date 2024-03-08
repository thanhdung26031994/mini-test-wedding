package com.example.minitestwedding.service.impl;

import com.example.minitestwedding.model.Task;
import com.example.minitestwedding.repository.ITaskRepository;
import com.example.minitestwedding.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository taskRepository;
    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }
}
