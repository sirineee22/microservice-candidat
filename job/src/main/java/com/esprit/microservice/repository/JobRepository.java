package com.esprit.microservice.repository;

import com.esprit.microservice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {

    Optional<Job> findByName(String name);
}
