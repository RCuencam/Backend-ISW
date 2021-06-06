package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.PostulantJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PostulantJobService {
    PostulantJob createPostulantJob(Long postulantId, Long jobOfferId, PostulantJob postulantJob);
    PostulantJob updatePostulantJob(Long postulantId, Long jobOfferId, Long postulantJobId, PostulantJob postulantJobDetails);
    ResponseEntity<?> deletePostulantJob(Long postulantId, Long jobOfferId, Long postulantJobId);
    Page<PostulantJob> getAllPostulantJobByPostulantId(Long postulantId, Pageable pageable);
    PostulantJob getPostulantIdByIdAndJobOfferId(Long postulantId, Long jobOfferId);
}
