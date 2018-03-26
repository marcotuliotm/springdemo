package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;

public interface TaskService {

    Task save(Task task);

    Task edit(Task task);

    List<Task> findAll();

    void delete(Long id);
}
