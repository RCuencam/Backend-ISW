package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.JobOffer;
import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.service.PostulantJobService;
import com.example.jobagapi.resource.JobOfferResource;
import com.example.jobagapi.resource.PostulantJobResource;
import com.example.jobagapi.resource.SavePostulantJobResource;
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
public class PostulantJobController {
    @Autowired
    private PostulantJobService postulantJobService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Get all postulant job by postulant ID", description="Get all postulant job by postulant ID", tags={"postulantjobs"})
    @GetMapping("/postulant/{postulantId}/postulantjobs")
    public Page<PostulantJobResource> getAllPostulantJobByPostulantId(
            @PathVariable Long postulantId,
            Pageable pageable) {
        Page<PostulantJob> postulantJobPage = postulantJobService.getAllPostulantJobByPostulantId(postulantId, pageable);
        List<PostulantJobResource> resources = postulantJobPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get postulants by jobofferId", description="Get postulants by jobofferId", tags={"postulantjobs"})
    @GetMapping("/postulant/{postulantId}/joboffer/{jobofferId}")
    public PostulantJobResource getPostulantByIdAndJobOfferId(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId) {
        return convertToResource(postulantJobService.getPostulantIdByIdAndJobOfferId(postulantId, jobofferId));
    }

    @Operation(summary="Postulant Jobs", description="Create postulantjobs", tags={"postulantjobs"})
    @PostMapping("/postulant/{postulantId}/joboffer/{jobofferId}/postulantjobs")
    public PostulantJobResource createJobOffer(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId,
            @Valid @RequestBody SavePostulantJobResource resource) {
        return convertToResource(postulantJobService.createPostulantJob(postulantId,jobofferId,convertToEntity(resource)));
    }

    @Operation(summary="Put Postulant Jobs", description="Update postulantjobs", tags={"postulantjobs"})
    @PutMapping("/postulant/{postulantId}/joboffer/{jobofferId}/postulantjobs/{postulanjobtId}")
    public PostulantJobResource updatePostulantJob(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId,
            @PathVariable Long postulanjobtId,
            @Valid @RequestBody SavePostulantJobResource resource) {
        return convertToResource(postulantJobService.updatePostulantJob(postulantId, jobofferId,postulanjobtId,convertToEntity(resource)));
    }

    @Operation(summary="Delete postulant job by postulant ID and job offer ID", description="Delete postulant job by postulant ID and job offer ID", tags={"postulantjobs"})
    @DeleteMapping("/postulant/{postulantId}/joboffer/{jobofferId}/postulantjobs/{postulanjobtId}")
    public ResponseEntity<?> deletePostulantJob(
            @PathVariable Long postulantId,
            @PathVariable Long jobofferId,
            @PathVariable Long postulanjobtId) {
        return postulantJobService.deletePostulantJob(postulantId, jobofferId, postulanjobtId);
    }

    private PostulantJob convertToEntity(SavePostulantJobResource resource){
        return mapper.map(resource, PostulantJob.class);
    }

    private PostulantJobResource convertToResource(PostulantJob entity){
        return mapper.map(entity,PostulantJobResource.class);
    }
}
