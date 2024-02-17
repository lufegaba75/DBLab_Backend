package com.lufegaba.datalab.controllers;

import com.lufegaba.datalab.model.entities.enumerations.WorkerType;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.services.WorkerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<Worker> createNewWorker (@RequestBody @Valid Worker worker) {
        return ResponseEntity.ok(workerService.createWorker(worker));
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers () {
        return ResponseEntity.ok(workerService.findAllWorkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById (@PathVariable Long id) {
        return ResponseEntity.ok(workerService.findWorkerById(id));
    }

    @GetMapping("/workertype={workertype}")
    public ResponseEntity<List<Worker>> getWorkersByType (@PathVariable WorkerType workertype) {
        return ResponseEntity.ok(workerService.findAllWorkersByWorkerType(workertype));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Worker> updateWorker (@PathVariable Long id, @RequestBody @Valid Worker worker) {
        return ResponseEntity.ok(workerService.updateWorkerById(id, worker));
    }

    @DeleteMapping("/{id}")
    public void deleteWorkerById (@PathVariable Long id) {
        workerService.deleteWorkerById(id);
    }
}
