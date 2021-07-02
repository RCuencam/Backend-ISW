package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.PostulantJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PostulantJobService {

    PostulantJob createPostulantJob(Long postulantId, Long jobOfferId, PostulantJob postulantJob);
    PostulantJob updatePostulantJob(Long postulantId, Long jobOfferId, PostulantJob postulantJobRequest);
    ResponseEntity<?> deletePostulantJob(Long postulantId, Long jobOfferId);
    PostulantJob getPostulantJobById(Long postulantJobId);
    Page<PostulantJob> getAllPostulantJobByPostulantId(Long postulantId, Pageable pageable);
    Page<PostulantJob> getAllPostulantJobByJobOfferId(Long jobOfferId, Pageable pageable);
    Page<PostulantJob> getAllPostulantJob(Pageable pageable);
}
