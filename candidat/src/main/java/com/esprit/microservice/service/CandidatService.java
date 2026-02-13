package com.esprit.microservice.service;

import com.esprit.microservice.entity.Candidat;
import com.esprit.microservice.repository.CandidatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {

    private final CandidatRepository repository;

    public CandidatService(CandidatRepository repository) {
        this.repository = repository;
    }

    public List<Candidat> getAll() {
        return repository.findAll();
    }

    public Candidat addCandidat(Candidat c) {
        return repository.save(c);
    }

    public Candidat updateCandidat(Integer id, Candidat c) {
        Candidat existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        c.setId(id);
        return repository.save(c);
    }

    public void deleteCandidat(Integer id) {
        repository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}
