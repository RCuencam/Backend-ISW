package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Planemployeer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.PlanemployeerRepository;
import com.example.jobagapi.domain.service.PlanemployeerService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanemployeerServiceImpl implements PlanemployeerService {
    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private PlanemployeerRepository planemployeerRepository;



    @Override
    public Page<Planemployeer> getAllPlanemployeersByEmployeerId(Long employeerId, Pageable pageable) {
        return planemployeerRepository.findByEmployeerId(employeerId,pageable);
    }

    @Override
    public Planemployeer getPlanemployeerByIdAndEmployeerId(Long planemployeersId,Long employeerId) {
        return planemployeerRepository.findByIdAndEmployeerId(planemployeersId,employeerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + planemployeersId+
                                "and EmployeerId" + employeerId));

    }

    @Override
    public Planemployeer createPlanemployeer(Long employeerId, Planemployeer planemployeer) {

        return employeerRepository.findById(employeerId).map(employeer -> {

            planemployeer.setEmployeer(employeer);
            return planemployeerRepository.save(planemployeer);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Employeer", "Id",employeerId));

    }



    @Override
    public Planemployeer updatePlanemployeer(Long employeerId, Long planemployeerId, Planemployeer planemployeerDetails) {
        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return planemployeerRepository.findById(planemployeerId).map(planemployeer -> {

            planemployeer.setDescription(planemployeerDetails.getDescription())
            .setLimit_videoconference(planemployeerDetails.getLimit_videoconference())
            .setLimit_modification(planemployeerDetails.getLimit_modification())
            .setAsistence(planemployeerDetails.isAsistence())
            .setDuration(planemployeerDetails.getDuration())

            ;

            return planemployeerRepository.save(planemployeer);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "Planemployeer","Id",planemployeerId));
    }

    @Override
    public ResponseEntity<?> deletePlanemployeer(Long employeerId, Long planemployeerId) {
        if (!planemployeerRepository.existsById(planemployeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return planemployeerRepository.findById(planemployeerId).map(planemployeer -> {
            planemployeerRepository.delete(planemployeer);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "Planemployeer", "Id",planemployeerId));

    }
}
