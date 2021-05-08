package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Languages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages,Long> {
    public Page<Languages> findById(Long Id, Pageable page);
}
