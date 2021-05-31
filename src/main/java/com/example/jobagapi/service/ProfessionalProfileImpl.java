package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.*;
import com.example.jobagapi.domain.repository.*;
import com.example.jobagapi.domain.service.ProfessionalProfileService;
import com.example.jobagapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalProfileImpl implements ProfessionalProfileService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    private StudiesRepository studiesRepository;

    @Autowired
    private ProfessionalProfileRepository professionalprofileRepository;


    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByPostulantId(Long postulantId, Pageable pageable) {
        return professionalprofileRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public ProfessionalProfile getProfessionalProfileByIdAndPostulantId(Long postulantId, Long professionalprofileId) {
        return professionalprofileRepository.findByIdAndPostulantId(postulantId,professionalprofileId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + professionalprofileId+
                                "and PostulantId" + postulantId));
    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByStudiesId(Long studiesId, Pageable pageable) {
        return professionalprofileRepository.findByStudiesId(studiesId,pageable);
    }

    @Override
    public ProfessionalProfile assignProfessionalProfileSkill(Long professionalprofileId, Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addSkill(skill)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));
    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileSkill(Long professionalprofileId, Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeSkill(skill)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));
    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByLanguagesId(Long languagesId, Pageable pageable) {
        return professionalprofileRepository.findByLanguagesId(languagesId,pageable);
    }


    @Override
    public ProfessionalProfile assignProfessionalProfileStudy(Long professionalprofileId, Long studiesId) {
        Studies studies = studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies", "Id", studiesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addStudies(studies)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));
    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileStudy(Long professionalprofileId, Long studiesId) {
        Studies studies = studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies", "Id", studiesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeStudies(studies)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileBySkillsId(Long skillId, Pageable pageable) {
        return professionalprofileRepository.findBySkillId(skillId,pageable);
    }

    @Override
    public ProfessionalProfile assignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId) {
        Languages languages = languagesRepository.findById(languagesId)
                .orElseThrow(() -> new ResourceNotFoundException("Languages", "Id", languagesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addLanguages(languages)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId) {
        Languages languages = languagesRepository.findById(languagesId)
                .orElseThrow(() -> new ResourceNotFoundException("Languages", "Id", languagesId));

        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeLanguages(languages)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public ProfessionalProfile createProfessionalProfile(Long postulantId, ProfessionalProfile professionalProfile) {
        return postulantRepository.findById(postulantId).map(postulant -> {

            professionalProfile.setPostulant(postulant);
            return professionalprofileRepository.save(professionalProfile);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Postulant", "Id",postulantId));
    }

    @Override
    public ProfessionalProfile updateProfessionalProfile(Long postulantId, Long professionalprofileId, ProfessionalProfile professionalprofileDetails) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return professionalprofileRepository.findById(professionalprofileId).map(professionalProfile -> {
            professionalProfile.setDescription(professionalprofileDetails.getDescription());
            return professionalprofileRepository.save(professionalProfile);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "ProfessionalProfile","Id",professionalprofileId));

    }

    @Override
    public ResponseEntity<?> deleteProfessionalProfile(Long postulantId, Long professionalprofileId) {
        if (!professionalprofileRepository.existsById(professionalprofileId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return professionalprofileRepository.findById(professionalprofileId).map(professionalProfile -> {
            professionalprofileRepository.delete(professionalProfile);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "Company", "Id",professionalprofileId));


    }


}
