package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface InterviewService {
    //Creacion de la entrevista con el postulante y la oferta de trabajo
    Interview createInterview(Long postulantId, Long jobOfferId, Interview interview);
    //Modificacion de la entrevista
    Interview updateInterview(Long postulantId, Long jobOfferId, Long interviewId, Interview interviewDetails);
    //Eliminacion de la entrevista
    ResponseEntity<?> deleteInterview(Long postulantId, Long jobOfferId, Long interviewId);
    //Retorna la entrevista segun Id del postulante
    Page<Interview> getAllInterviewsByPostulantId(Long postulantId, Pageable pageable);
    //Retorna la entrevista segun Id de la oferta de trabajo
    Page<Interview> getAllInterviewsByJobOfferId(Long jobOfferId, Pageable pageable);
    //Retorna todas las entrevistas segun el  id del postulante y de la oferta de trabajo
    Page<Interview> getAllInterviewByPostulantIdAndJobOfferId(Long postulantId, Long jobOfferId, Pageable pageable);
}
