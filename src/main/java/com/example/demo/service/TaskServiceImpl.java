package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public Task edit(Task task) {
        final Optional<Task> optionalTask = repository.findById( task.getId() );
        if(optionalTask.isPresent()) {
            return repository.save( task );
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        final Optional<Task> optionalTask = repository.findById( id );
        if(optionalTask.isPresent()) {
            repository.delete( optionalTask.get() );
        }
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }
}
