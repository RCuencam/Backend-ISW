package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MailMessageService {

    MailMessage createMailMessage(Long postulantId, Long employeerId, MailMessage mailMessage);
    MailMessage updateMailMessage(Long postulantId, Long employeerId, Long mailmessageId, MailMessage mailmessageDetails);

    ResponseEntity<?> deleteMailMessage(Long postulantId, Long employeerId, Long mailmessageId);

    Page<MailMessage> getAllMailMessageByPostulantId(Long postulantId, Pageable pageable);
    MailMessage getPostulantIdByIdAndEmployeerId(Long postulantId, Long employeerId);
}