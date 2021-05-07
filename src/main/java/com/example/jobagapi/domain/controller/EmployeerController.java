package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.resource.EmployeerResource;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empl")
public class EmployeerController {
    @Autowired
    private EmployeerService employeerService;

    @Operation(summary="Get Employeers", description="Get All Employeers", tags={"employeers"})
    @ApiResponses(value={
            @ApiResponse(responseCode="200",description="All employeers returned",content=@Content(mediaType = "application/json"))
    })
    @GetMapping("/employeers")
    public Page<Employeer> getAllEmployeers(Pageable pageable){
        Page<Employeer> employeerPage = employeerService.getAllEmployeers(pageable);
        return employeerPage;
        /*List<EmployeerResource> resources = employeerPage.getContent()
                .stream()
                .map(this::ConvertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());*/
    }
}
