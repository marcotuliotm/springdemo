package com.example.demo.controller;

import com.example.demo.entity.STATUS;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( value = "tasks", produces = MediaType.APPLICATION_JSON_VALUE )
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Task task) {
        Long id = service.save(task).getId();
        return ResponseEntity.status( HttpStatus.CREATED ).body(id );
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = service.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(path = "status")
    public ResponseEntity<List<STATUS>> findAllStatus() {
        final List<STATUS> statusList = Arrays.asList( STATUS.values() );
        return ResponseEntity.ok(statusList);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody Task task) {
        Task edited = service.edit(task);
        if (edited == null ) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>( edited.getVersion() , HttpStatus.OK );
    }
}
