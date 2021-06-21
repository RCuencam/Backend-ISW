package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Planemployeer;
import com.example.jobagapi.domain.service.PlanemployeerService;
import com.example.jobagapi.resource.PlanemployeerResource;
import com.example.jobagapi.resource.SavePlanemployeerResource;
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
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class PlanemployeerController {
    @Autowired
    private PlanemployeerService planemployeerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Get planemployeers", description="Get all PlanEmployeers", tags={"plan_employeers"})
    @GetMapping("/employeers/{employeerId}/planemployeers")
    public Page<PlanemployeerResource> getAllPlanemployeersByEmployeerId(@PathVariable Long employeerId, Pageable pageable) {
        Page<Planemployeer> planemployeerPage = planemployeerService.getAllPlanemployeersByEmployeerId(employeerId, pageable);
        List<PlanemployeerResource> resources = planemployeerPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get planemployeers", description="Get PlanEmployeer by Employeer ID", tags={"plan_employeers"})
    @GetMapping("/employeers/{employeerId}/planemployeers/{planemployeerId}")
    public PlanemployeerResource getPlanemployeerByIdAndEmployeerId(@PathVariable Long employeerId, @PathVariable Long planemployeerId) {
        return convertToResource(planemployeerService.getPlanemployeerByIdAndEmployeerId(planemployeerId, employeerId));
    }

    @Operation(summary="Post planemployeers", description="Create PlanEmployeer", tags={"plan_employeers"})
    @PostMapping("/employeers/{employeerId}/planemployeers")
    public PlanemployeerResource createPlanemployeer(
            @PathVariable Long employeerId,@Valid @RequestBody SavePlanemployeerResource resource) {
        return convertToResource(planemployeerService.createPlanemployeer(employeerId, convertToEntity(resource)));
    }
    @Operation(summary="Put planemployeers", description="Update PlanEmployeer", tags={"plan_employeers"})
    @PutMapping("/employeers/{employeerId}/planemployeers/{planemployeerId}")
    public PlanemployeerResource updatePlanemployeer(
            @PathVariable Long employeerId,
            @PathVariable Long planemployeerId,
            @Valid @RequestBody SavePlanemployeerResource resource) {
        return convertToResource(planemployeerService.updatePlanemployeer(employeerId, planemployeerId, convertToEntity(resource)));
    }

    @Operation(summary="Delete planemployeers", description="Delete PlanEmployeer", tags={"plan_employeers"})
    @DeleteMapping("/employeers/{employeerId}/planemployeers/{planemployeerId}")
    public ResponseEntity<?> deletePlanemployeer(
            @PathVariable Long employeerId,
            @PathVariable Long planemployeerId) {
        return planemployeerService.deletePlanemployeer(employeerId, planemployeerId);
    }


    private Planemployeer convertToEntity(SavePlanemployeerResource resource) {
        return mapper.map(resource, Planemployeer.class);
    }

    private PlanemployeerResource convertToResource(Planemployeer entity) {
        return mapper.map(entity, PlanemployeerResource.class);
    }
}
