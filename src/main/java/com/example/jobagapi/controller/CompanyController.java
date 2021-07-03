package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.service.CompanyService;
import com.example.jobagapi.resource.CompanyResource;
import com.example.jobagapi.resource.InterviewResource;
import com.example.jobagapi.resource.SaveCompanyResource;
import com.example.jobagapi.resource.SaveInterviewResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModelMapper mapper;


    @Operation(summary = "Post companys", description = "Create companys by employeer Id", tags = {"companies"})
    @PostMapping("/employeers/{employeerId}/sector/{sectorId}/companys")
    public CompanyResource createCompany(
            @PathVariable Long employeerId,
            @PathVariable Long sectorId,
            @Valid @RequestBody SaveCompanyResource resource) {
        return convertToResource(companyService.createCompany(employeerId, sectorId, convertToEntity(resource)));
    }

    @Operation(summary="Update Company by Employeer Id and Sector Id", description="Update Company by Employeer Id and Sector Id", tags={"companies"})
    @PutMapping("/employeers/{employeerId}/sector/{sectorId}/companys")
    public CompanyResource updateCompany(
            @PathVariable Long employeerId,
            @PathVariable Long sectorId,
            @Valid @RequestBody SaveCompanyResource resource) {
        return convertToResource(companyService.updateCompany(employeerId, sectorId, convertToEntity(resource)));
    }

    @Operation(summary="Delete Company by Employeer Id and Sector Id", description="Delete Company by Employeer Id and Sector Id", tags={"companies"})
    @DeleteMapping("/employeers/{employeerId}/sector/{sectorId}/companys")
    public ResponseEntity<?> deleteCompany(
            @PathVariable Long employeerId,
            @PathVariable Long sectorId) {
        return companyService.deleteCompany(employeerId, sectorId);
    }

    @Operation(summary = "Get All Company", description = "Get All Company", tags = {"companies"})
    @GetMapping("/companys")
    public Page<CompanyResource> getAllCompany(Pageable pageable){
        Page<Company> companyPage = companyService.getAllCompany(pageable);
        List<CompanyResource> resources = companyPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Get Company by Id", description="Get Company by Id", tags={"companies"})
    @GetMapping("/companys/{companyId}")
    public CompanyResource getInterviewById(
            @PathVariable Long companyId) {
        return convertToResource(companyService.getCompanyById(companyId));
    }
    
        @Operation(summary = "Get All Company By Employeer Id", description = "Get All Company By Employeer Id", tags = {"companies"})
    @GetMapping("/employeers/{employeerId}/companys")
    public Page<CompanyResource> getAllCompanyByEmployeerId(
            @PathVariable Long employeerId,
            Pageable pageable){
        Page<Company> companyPage = companyService.getAllCompanyByEmployeerId(employeerId, pageable);
        List<CompanyResource> resources = companyPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }



    private Company convertToEntity(SaveCompanyResource resource) {
        return mapper.map(resource, Company.class);
    }

    private CompanyResource convertToResource(Company entity) {
        return mapper.map(entity, CompanyResource.class);
    }
}
