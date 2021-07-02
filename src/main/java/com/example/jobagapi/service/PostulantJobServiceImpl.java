package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.repository.JobOfferRepository;
import com.example.jobagapi.domain.repository.PostulantJobRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PostulantJobService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostulantJobServiceImpl implements PostulantJobService {
    @Autowired
    private PostulantRepository postulantRepository;
    @Autowired
    private PostulantJobRepository postulantJobRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public PostulantJob createPostulantJob(Long postulantId, Long jobOfferId, PostulantJob postulantJob) {
        if(postulantJobRepository.existsByPostulantId(postulantId) && postulantJobRepository.existsByJobOfferId(jobOfferId))
            throw  new ResourceNotFoundException("El postulante ya postulo a esta oferta de trabajo");

        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        else if (!jobOfferRepository.existsById(jobOfferId))
            throw new ResourceNotFoundException("Job Offer","Id", jobOfferId);

        return postulantRepository.findById(postulantId).map(postulant -> {
            postulantJob.setPostulant(postulant);
            jobOfferRepository.findById(jobOfferId).map(jobOffer -> {
                postulantJob.setJobOffer(jobOffer);
                return postulantJobRepository.save(postulantJob);
            }).orElseThrow(() -> new ResourceNotFoundException("Job Offer Id" + jobOfferId));
            return postulantJobRepository.save(postulantJob);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId));
    }

    @Override
    public PostulantJob updatePostulantJob(Long postulantId, Long jobOfferId, PostulantJob postulantJobDetails) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        else if (!jobOfferRepository.existsById(jobOfferId))
            throw new ResourceNotFoundException("Job Offer","Id", jobOfferId);

        return postulantJobRepository.findByPostulantIdAndJobOfferId(postulantId, jobOfferId).map(postulantJob -> {
            postulantJob.setAceppt(postulantJobDetails.isAceppt());
            return  postulantJobRepository.save(postulantJob);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId + "Job Offer Id" + jobOfferId));
    }

    @Override
    public ResponseEntity<?> deletePostulantJob(Long postulantId, Long jobOfferId) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        else if (!jobOfferRepository.existsById(jobOfferId))
            throw new ResourceNotFoundException("Job Offer","Id", jobOfferId);

        return postulantJobRepository.findByPostulantIdAndJobOfferId(postulantId, jobOfferId).map(postulantJob -> {
            postulantJobRepository.delete(postulantJob);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId + "Job Offer Id" + jobOfferId));
    }

    @Override
    public PostulantJob getPostulantJobById(Long postulantJobId) {
        return postulantJobRepository.findById(postulantJobId)
                .orElseThrow(() -> new ResourceNotFoundException("Postulant Job", "Id", postulantJobId));
    }

    @Override
    public Page<PostulantJob> getAllPostulantJobByPostulantId(Long postulantId, Pageable pageable) {
        return postulantJobRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public Page<PostulantJob> getAllPostulantJobByJobOfferId(Long jobOfferId, Pageable pageable) {
        return postulantJobRepository.findByJobOfferId(jobOfferId,pageable);
    }

    @Override
    public Page<PostulantJob> getAllPostulantJob(Pageable pageable) {
        return postulantJobRepository.findAll(pageable);
    }
}
