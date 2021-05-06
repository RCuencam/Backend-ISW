package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Employeer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeerRepository extends JpaRepository<Employeer,Long> {
    public Optional<Employeer> findById(Long Id);
}
