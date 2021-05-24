package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.repository.CompanyRepository;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.service.CompanyService;
import com.example.jobagapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private CompanyRepository companyRepository;



    @Override
    public Page<Company> getAllCompanysByEmployeerId(Long employeerId, Pageable pageable) {
        return companyRepository.findByEmployeerId(employeerId,pageable);
    }

    @Override
    public Company getCompanyByIdAndEmployeerId(Long employeerId, Long companyId) {
        return companyRepository.findByIdAndEmployeerId(employeerId,companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + companyId+
                                "and EmployeerId" + employeerId));

    }

    @Override
    public Company createCompany(Long employeerId, Company company) {

        return employeerRepository.findById(employeerId).map(employeer -> {

            company.setEmployeer(employeer);
            return companyRepository.save(company);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Employeer", "Id",employeerId));

    }






    @Override
    public Company updateCompany(Long employeerId, Long companyId, Company companyDetails) {
        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyRepository.findById(companyId).map(company -> {

            company.setName(companyDetails.getName())
                   ;

            return companyRepository.save(company);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "Company","Id",companyId));
    }

    @Override
    public ResponseEntity<?> deleteCompany(Long employeerId, Long companyId) {
        if (!companyRepository.existsById(companyId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyRepository.findById(companyId).map(company -> {
            companyRepository.delete(company);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "Company", "Id",companyId));

    }
}
