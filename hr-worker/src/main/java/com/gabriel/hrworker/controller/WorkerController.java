package com.gabriel.hrworker.controller;

import com.gabriel.hrworker.entities.Worker;
import com.gabriel.hrworker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return  ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception {
        try {
            Worker worker = repository.findById(id).orElseThrow(() -> new Exception("Worker not found"));
            return ResponseEntity.ok(worker);
        } catch (Exception e){
            if(e.getMessage().startsWith("Worker")){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
