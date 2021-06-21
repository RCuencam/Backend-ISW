package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.resource.EmployeerResource;
import com.example.jobagapi.resource.SaveEmployeerResource;
import com.example.jobagapi.domain.service.EmployeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class EmployeerController {
    @Autowired
    private EmployeerService employeerService;

    @Autowired
    private ModelMapper mapper;



    @Operation(summary="Get Employeers", description="Get All Employeers", tags={"employeers"})
    @GetMapping("/employeers")
    public Page<EmployeerResource> getAllEmployeers(Pageable pageable){
        Page<Employeer> employeerPage = employeerService.getAllEmployeers(pageable);
        List<EmployeerResource> resources = employeerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Post Employeers", description="Create Employeers", tags={"employeers"})
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/employeers")
    public EmployeerResource createEmployeer(@Valid @RequestBody SaveEmployeerResource resource) {
        Employeer employeer = convertToEntity(resource);
        return convertToResource(employeerService.createEmployeer(employeer));
    }

    @Operation(summary="Get EmployeersById", description="Get EmployeersById", tags={"employeers"})
    @GetMapping("/employeers/{id}")
    public EmployeerResource getEmployeerById(@PathVariable(name = "id") Long employeerId) {
        return convertToResource(employeerService.getEmployeerById(employeerId));
    }

    @Operation(summary="Delete Employeer By Id", description="DeleteEmployeerById", tags={"employeers"})
    @DeleteMapping("/employeers/{postId}")

    public ResponseEntity<?> deleteEmployeer(@PathVariable Long postId) {
        return employeerService.deleteEmployeer(postId);
    }





    private Employeer convertToEntity(SaveEmployeerResource resource) {
        return mapper.map(resource, Employeer.class);
    }
    private EmployeerResource convertToResource(Employeer entity)
    {
        return mapper.map(entity, EmployeerResource.class);
    }



}
