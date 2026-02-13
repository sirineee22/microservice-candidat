package com.esprit.microservice.controller;

import com.esprit.microservice.entity.Job;
import com.esprit.microservice.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobRestAPI {

    private final JobService jobService;

    public JobRestAPI(JobService jobService) {
        this.jobService = jobService;
    }

    /** GET all jobs */
    @GetMapping
    public List<Job> getAll() {
        return jobService.getAll();
    }

    /** GET job by id (path) or by name (query param ?name=xxx) */
    @GetMapping("/{id}")
    public ResponseEntity<Job> getById(@PathVariable Integer id) {
        return jobService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = "name")
    public ResponseEntity<Job> getByName(@RequestParam String name) {
        return jobService.getByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** PUT update etat: "oui" = disponible, "non" = occupé */
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateEtat(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        String etat = body != null ? body.get("etat") : null;
        Optional<Job> updated = jobService.updateEtat(id, etat);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
