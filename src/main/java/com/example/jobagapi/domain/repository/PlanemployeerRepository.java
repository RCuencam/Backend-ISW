package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.model.Planemployeer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanemployeerRepository extends JpaRepository<Planemployeer,Long> {
    Page<Planemployeer> findByEmployeerId(Long employeerId, Pageable pageable); //Encontrar por Id

    public Optional<Planemployeer> findByIdAndEmployeerId(Long id, Long employeerId);
}
