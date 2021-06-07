package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.*;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.MailMessageRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.MailMessageService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public class MailMessageServiceImpl implements MailMessageService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private EmployeerRepository employeerRepository;

    @Override
    public MailMessage createMailMessage(Long postulantId, Long employeerId, MailMessage mailMessage) {
        if(mailMessageRepository.existsByPostulantId(postulantId) && mailMessageRepository.existsByEmployeerId(employeerId))
            throw  new ResourceNotFoundException("El postulante ya postulo a esta oferta");

        //Compruebo que exista el postulant
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

            // Comprobar si exisite el employeer
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id", employeerId);

        return postulantRepository.findById(postulantId).map(postulant -> {
            mailMessage.setPostulant(postulant);

            employeerRepository.findById(employeerId).map(employeer -> {
                mailMessage.setEmployeer(employeer);
                return mailMessageRepository.save(mailMessage);
            }).orElseThrow(() -> new ResourceNotFoundException("Employeer Id" + employeerId));
            return mailMessageRepository.save(mailMessage);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId));
    }

    @Override
    public MailMessage updateMailMessage(Long postulantId, Long employeerId, Long mailmessageId, MailMessage mailmessageDetails) {
        //Compruebo que exista el postulant
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Job Offer","Id", employeerId);

        return mailMessageRepository.findById(mailmessageId).map(mailMessage -> {
            mailMessage.setAceppt(mailmessageDetails.isAceppt());
            return  mailMessageRepository.save(mailMessage);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId + "Employeer Id" + employeerId));
    }

    @Override
    public ResponseEntity<?> deleteMailMessage(Long postulantId, Long employeerId, Long mailmessageId) {
        //Compruebo que exista el postulant
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id", employeerId);

        return mailMessageRepository.findById(mailmessageId).map(mailMessage -> {
            mailMessageRepository.delete(mailMessage);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("MailMessage","Id",mailmessageId));
    }

    @Override
    public Page<MailMessage> getAllMailMessageByPostulantId(Long postulantId, Pageable pageable) {
        return mailMessageRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public MailMessage getPostulantIdByIdAndEmployeerId(Long postulantId, Long employeerId) {
        return mailMessageRepository.findByPostulantIdAndEmployeerId(postulantId,employeerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "postulantid not found with id" + postulantId +
                                "and employeerId" + employeerId));
    }
}