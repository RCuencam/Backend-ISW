package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.CompanyProfile;
import com.example.jobagapi.domain.resource.CompanyProfileResource;
import com.example.jobagapi.domain.service.CompanyProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companyProfile")
public class CompanyProfileController {
    @Autowired
    private ModelMapper mapper;
    private CompanyProfileService companyProfileService;

    @GetMapping("/employeers/{employerId}/companyProfile")
    public Page<CompanyProfile> getAllCompanyProfileByEmployeerId(@PathVariable Long employeerId, Pageable pageable) {
        //Page<CompanyProfile> companyProfilePage = companyProfileService.getAllCompanyProfileByEmployeerId(employeerId,pageable);
        //List<CompanyProfileResource> resources = companyProfilePage.getContent().stream().map(
        //            this::convertToResource).collect(Collectors.toList());
        //return new PageImpl<>(resources, pageable, resources.size());
        return null;
    }

    public CompanyProfile getCompanyProfileByIdAndEmployeerId(Long employeerId, Long companyProfileId) {
        return companyProfileService.getCompanyProfileByIdAndEmployeerId(employeerId, companyProfileId);
    }

    public CompanyProfile createCompanyProfile(Long employeerId, CompanyProfile companyProfile) {
        return companyProfileService.createCompanyProfile(employeerId, companyProfile);
    }

    public CompanyProfile udpdateCompanyProfile(Long employeerId, Long companyProfileId, CompanyProfile companyProfileDetails) {
        return companyProfileService.udpdateCompanyProfile(employeerId, companyProfileId, companyProfileDetails);
    }

    public ResponseEntity<?> deleteCompanyProfile(Long employeerId, Long companyProfileId) {
        return companyProfileService.deleteCompanyProfile(employeerId, companyProfileId);
    }

    private CompanyProfileResource convertToResource(CompanyProfile companyProfile) {
        return mapper.map(companyProfile, CompanyProfileResource.class);
    }

}
