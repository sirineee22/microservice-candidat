package com.esprit.microservice.controller;

import com.esprit.microservice.entity.Candidat;
import com.esprit.microservice.service.CandidatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestAPI {

    private final CandidatService candidatService;

    public CandidatRestAPI(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping
    public List<Candidat> getAll() {
        return candidatService.getAll();
    }

    @PostMapping
    public Candidat addCandidat(@RequestBody Candidat c) {
        return candidatService.addCandidat(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable Integer id, @RequestBody Candidat c) {
        Candidat updated = candidatService.updateCandidat(id, c);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable Integer id) {
        if (!candidatService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        candidatService.deleteCandidat(id);
        return ResponseEntity.noContent().build();
    }
}
