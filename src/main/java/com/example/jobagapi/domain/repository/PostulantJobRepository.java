package com.example.jobagapi.domain.repository;


import com.example.jobagapi.domain.model.PostulantJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulantJobRepository extends JpaRepository<PostulantJob, Long> {
    public Page<PostulantJob> findById(Long Id, Pageable pageable);

    Optional <PostulantJob> findByPostulantIdAndJobOfferId (Long PostulantId, Long JobOfferId);

    Page<PostulantJob> findByPostulantId(Long PostulantId, Pageable pageable);

    Page<PostulantJob> findByJobOfferId(Long JobOfferId, Pageable pageable);

    Boolean existsByPostulantId (Long postulantId);

    Boolean existsByJobOfferId (Long jobOfferId);

}
