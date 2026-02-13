package com.esprit.microservice.service;

import com.esprit.microservice.entity.Job;
import com.esprit.microservice.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> getAll() {
        return repository.findAll();
    }

    public Optional<Job> getById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Job> getByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Met à jour l'état du job : "oui" = disponible, "non" = occupé
     */
    public Optional<Job> updateEtat(Integer id, String etat) {
        return repository.findById(id)
                .map(job -> {
                    job.setEtat("oui".equalsIgnoreCase(etat) ? "oui" : "non");
                    return repository.save(job);
                });
    }
}
