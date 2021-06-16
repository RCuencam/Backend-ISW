package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.service.ProfessionalProfileService;
import com.example.jobagapi.resource.ProfessionalProfileResource;
import com.example.jobagapi.resource.SaveProfessionalProfileResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class ProfessionalProfileStudiesController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Operation(summary = "Assign Study to Profile",
            description = "Establishes association between Study and  Profile",
             tags = {"profiles"}
    )
    @PostMapping("/profiles/{profileId}/studies/{studyId}")
    public ProfessionalProfileResource assignProfessionalProfileStudy(
            @PathVariable Long profileId,
            @PathVariable Long studyId) {
        return convertToResource(professionalprofileService.assignProfessionalProfileStudy(profileId, studyId));
    }

    @Operation(summary = "Remove assignment between Study and  Profile",
            description = "Ends association between  Profile and Study",
              tags = {"profiles"}
    )
    @DeleteMapping("/profiles/{profileId}/studies/{studyId}")
    public ProfessionalProfileResource unassignProfessionalProfileStudy(
            @PathVariable Long profileId,
            @PathVariable Long studyId) {
        return convertToResource(professionalprofileService.unassignProfessionalProfileStudy(profileId, studyId));
    }


    @Operation(summary = "List assignment between Study and  Profile",
            description = "List association between  Profile and Study",
            tags = {"profiles"}
    )

    @GetMapping("/studies/{studyId}/profiles")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileByStudiesId(
            @PathVariable Long studyId,
            Pageable pageable) {
        Page<ProfessionalProfile> postsPage = professionalprofileService.getAllProfessionalProfileByStudiesId(studyId, pageable);
        List<ProfessionalProfileResource> resources = postsPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private ProfessionalProfile convertToEntity(SaveProfessionalProfileResource resource) {
        return mapper.map(resource, ProfessionalProfile.class);
    }

    private ProfessionalProfileResource convertToResource(ProfessionalProfile entity) {
        return mapper.map(entity, ProfessionalProfileResource.class);
    }
}
