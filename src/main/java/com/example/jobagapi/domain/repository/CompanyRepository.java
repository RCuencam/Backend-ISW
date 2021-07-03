package com.example.jobagapi.domain.repository;


import com.example.jobagapi.domain.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    public Page<Company> findById (Long Id, Pageable pageable);

    Optional<Company> findByEmployeerIdAndSectorId(Long EmployeerId, Long SectorId);
    
    Page<Company> findByEmployeerId(Long EmployeerId, Pageable pageable);

    Boolean existsByEmployeerId(Long employeerId);
}

