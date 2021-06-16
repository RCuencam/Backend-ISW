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

public class ProfessionalProfileSkillsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Operation(summary = "Assign Skill to Profile",
            description = "Establishes association between Skills and Profiles",
            tags = {"profiles"}
    )

    @PostMapping("/profiles/{profileId}/skills/{skillId}")
    public ProfessionalProfileResource assignProfessionalProfileSkill(
            @PathVariable Long profileId,
            @PathVariable Long skillId) {
        return convertToResource(professionalprofileService.assignProfessionalProfileSkill(profileId, skillId));
    }

    @Operation(summary = "Remove assignment between Skill and Profile",
            description = "Ends association between Profile and Skill",
             tags = {"profiles"}
    )
    @DeleteMapping("/profiles/{profileId}/skills/{skillId}")
    public ProfessionalProfileResource unassignProfessionalProfileSkill(
            @PathVariable Long profileId,
            @PathVariable Long skillId) {
        return convertToResource(professionalprofileService.unassignProfessionalProfileSkill(profileId, skillId));
    }


    @Operation(summary = "List assignment between Skill and Profile",
            description = "List association between Profile and Skill",
              tags = {"profiles"}
    )

    @GetMapping("/skills/{skillId}/profiles")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileBySkillsId(
            @PathVariable Long skillId,
            Pageable pageable) {
        Page<ProfessionalProfile> postsPage = professionalprofileService.getAllProfessionalProfileBySkillId(skillId, pageable);
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
