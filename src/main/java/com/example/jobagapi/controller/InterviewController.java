package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.service.InterviewService;
import com.example.jobagapi.resource.InterviewResource;
import com.example.jobagapi.resource.SaveInterviewResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create interviews", description="Create interviews", tags={"interviews"})
    @PostMapping("/postulants/{postulantId}/joboffers/{jobofferId}/interviews")
    public InterviewResource createInterview(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId,
            @Valid @RequestBody SaveInterviewResource resource) {
        return convertToResource(interviewService.createInterview(postulantId,jobofferId,convertToEntity(resource)));
    }

    @Operation(summary="Delete interviews by Postulant ID and Job Offer ID", description="Delete interviews by Postulant ID and Job Offer ID", tags={"interviews"})
    @DeleteMapping("/postulants/{postulantId}/joboffers/{jobofferId}/interviews")
    public ResponseEntity<?> deleteInterview(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId) {
        return interviewService.deleteInterview(postulantId, jobofferId);
    }

    @Operation(summary="Update interviews by postulant Id and job offer Id", description="Update interviews by postulant Id and job offer Id", tags={"interviews"})
    @PutMapping("/postulants/{postulantId}/joboffers/{jobofferId}/interviews")
    public InterviewResource updateInterview(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId,
            @Valid @RequestBody SaveInterviewResource resource) {
        return convertToResource(interviewService.updateInterview(postulantId, jobofferId, convertToEntity(resource)));
    }


    @Operation(summary = "Get All Interview", description = "Get All Interview", tags = {"interviews"})
    @GetMapping("/interviews")
    public Page<InterviewResource> getAllInterview(Pageable pageable){
        Page<Interview> interviewPage = interviewService.getAllInterview(pageable);
        List<InterviewResource> resources = interviewPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Get Interview by Id", description="Get Interview by Id", tags={"interviews"})
    @GetMapping("/interviews/{interviewId}")
    public InterviewResource getInterviewById(
            @PathVariable Long interviewId) {
        return convertToResource(interviewService.getInterviewById(interviewId));
    }

    @Operation(summary="Get interviews", description="Get all interviews by postulant Id", tags={"interviews"})
    @GetMapping("/postulants/{postulantId}/interviews")
    public Page<InterviewResource> getAllInterviewsByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        Page<Interview> interviewPage = interviewService.getAllInterviewsByPostulantId(postulantId, pageable);
        List<InterviewResource> resources = interviewPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get interviews", description="Get all interviews by postulant Id", tags={"interviews"})
    @GetMapping("/joboffers/{jobofferId}/interviews")
    public Page<InterviewResource> getAllInterviewsByJobOfferId(
            @PathVariable Long jobofferId,
            Pageable pageable) {
        Page<Interview> interviewPage = interviewService.getAllInterviewsByJobOfferId(jobofferId, pageable);
        List<InterviewResource> resources = interviewPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private Interview convertToEntity(SaveInterviewResource resource){
        return mapper.map(resource, Interview.class);
    }

    private InterviewResource convertToResource(Interview entity){
        return mapper.map(entity,InterviewResource.class);
    }

}
