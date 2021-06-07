package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.service.MailMessageService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import com.example.jobagapi.resource.*;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MailMessageController {

    @Autowired
    private MailMessageService mailmessageService;

    @Autowired
    private ModelMapper mapper;


    @Operation(summary="Get all postulant job by postulant ID", description="Get all mail message by postulant ID", tags={"mailmesssages"})
    @GetMapping("/postulant/{postulantId}/mailmessages")
    public Page<MailMessageResource> getAllMailMessageByPostulantId(
            @PathVariable Long postulantId,
            Pageable pageable) {
        Page<MailMessage> mailMessagePage = mailmessageService.getAllMailMessageByPostulantId(postulantId, pageable);
        List<MailMessageResource> resources = mailMessagePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get postulants by mailmessagesId", description="Get postulants by mailmesssagesId", tags={"mailmessages"})
    @GetMapping("/postulant/{postulantId}/employeer/{employeerId}")
    public MailMessageResource getPostulantIdByIdAndEmployeerId(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId) {
        return convertToResource(mailmessageService.getPostulantIdByIdAndEmployeerId(postulantId, employeerId));
    }

    @Operation(summary="Postulant Jobs", description="Create mailmessages", tags={"mail_messages"})
    @PostMapping("/postulant/{postulantId}/employeer/{employeerId}/mailmessage")
    public MailMessageResource createMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeersId,
            @Valid @RequestBody SaveMailMessageResource resource) {
        return convertToResource(mailmessageService.createMailMessage(postulantId,employeersId,convertToEntity(resource)));
    }

    @Operation(summary="Put Mail Message", description="Update mailmessages", tags={"mail_messages"})
    @PutMapping("/postulant/{postulantId}/employeer/{employeerId}/mailmessage/{mailmessageId}")
    public MailMessageResource updateMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            @PathVariable Long mailmessageId,
            @Valid @RequestBody SaveMailMessageResource resource) {
        return convertToResource(mailmessageService.updateMailMessage(postulantId, employeerId,mailmessageId,convertToEntity(resource)));
    }

    @Operation(summary="Delete postulant job by postulant ID and job offer ID", description="Delete postulant job by postulant ID and mail message ID", tags={"mail_messages"})
    @DeleteMapping("/postulant/{postulantId}/employeer/{employeerId}/mailmessage/{mailmessageId}")
    public ResponseEntity<?> deleteMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            @PathVariable Long mailmessageId) {
        return mailmessageService.deleteMailMessage(postulantId, employeerId, mailmessageId);
    }

    private MailMessage convertToEntity(SaveMailMessageResource resource) {
        return mapper.map(resource, MailMessage.class);
    }

    private MailMessageResource convertToResource(MailMessage entity) {
        return mapper.map(entity, MailMessageResource.class);
    }

}