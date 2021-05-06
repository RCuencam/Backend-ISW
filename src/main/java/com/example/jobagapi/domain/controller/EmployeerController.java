package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.service.EmployeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeerController {
    @Autowired
    private EmployeerService employeerService;

    @GetMapping("/employeers")
    public Page<Employeer> getAllEmployeers(Pageable pageable){
        Page<Employeer> employeerPage = employeerService.getAllEmployeers(pageable);
        return employeerPage;
    }
}
