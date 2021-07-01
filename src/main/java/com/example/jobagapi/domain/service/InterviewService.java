package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface InterviewService {
    Interview createInterview(Long postulantId, Long jobOfferId, Interview interview);
    Interview updateInterview(Long postulantId, Long jobOfferId, Interview interviewDetails);
    ResponseEntity<?> deleteInterview(Long postulantId, Long jobOfferId);
    Page<Interview> getAllInterview(Pageable pageable);
    Page<Interview> getAllInterviewsByPostulantId(Long postulantId, Pageable pageable);
    Page<Interview> getAllInterviewsByJobOfferId(Long jobOfferId, Pageable pageable);
    Interview getInterviewById(Long interviewId);
}
