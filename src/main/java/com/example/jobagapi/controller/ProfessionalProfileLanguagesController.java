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
public class ProfessionalProfileLanguagesController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Operation(summary = "Assign Languages to Profiles",
            description = "Establishes association between languages and Profiles",
            tags = {"profiles"}
    )
    @PostMapping("/profiles/{profileId}/languages/{languageId}")
    public ProfessionalProfileResource assignProfessionalProfileLanguage(
            @PathVariable Long profileId,
            @PathVariable Long languageId) {
        return convertToResource(professionalprofileService.assignProfessionalProfileLanguage(profileId, languageId));
    }

    @Operation(summary = "Remove assignment between Languages and  Profiles",
            description = "Ends association between Languages and  Profiles",
             tags = {"profiles"}
    )
    @DeleteMapping("/profiles/{profileId}/languages/{languageId}")
    public ProfessionalProfileResource unassignProfessionalProfileLanguage(
            @PathVariable Long profileId,
            @PathVariable Long languageId) {
        return convertToResource(professionalprofileService.unassignProfessionalProfileLanguage(profileId, languageId));
    }


    @Operation(summary = "List assignment between Languages and Profiles",
            description = "List association between Languages and Profiles",
             tags = {"profiles"}
    )
    @GetMapping("/languages/{languageId}/profiles")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileByLanguagesId(
            @PathVariable Long languageId,
            Pageable pageable) {
        Page<ProfessionalProfile> postsPage = professionalprofileService.getAllProfessionalProfileByLanguagesId(languageId, pageable);
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
