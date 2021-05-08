package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Languages;
import com.example.jobagapi.domain.resource.LanguagesResource;
import com.example.jobagapi.domain.resource.SaveLanguaguesResource;
import com.example.jobagapi.domain.service.LanguagesService;
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
@RequestMapping("/api")
public class LanguagesController {
    @Autowired
    private LanguagesService languagesService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get Languages", description = "Get All Languages", tags = {"languages"})
    @GetMapping("/languages")
    public Page<LanguagesResource> getAllLanguages(Pageable pageable){
        Page<Languages> languagesPage = languagesService.getAllLanguages(pageable);
        List<LanguagesResource> resources = languagesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @PostMapping("/languages")
    public LanguagesResource createLanguages(@Valid @RequestBody SaveLanguaguesResource resource){
        Languages languages = convertToEntity(resource);
        return  convertToResource(languagesService.createLanguages(languages));
    }

    @GetMapping("/languages/{languagesId}")
    public LanguagesResource gerLanguaesById(@PathVariable Long languagesId){
        return convertToResource(languagesService.getLanguagesById(languagesId));
    }

    public ResponseEntity<?> deleteLanguages(@PathVariable Long languageId){
        return languagesService.deleteLanguages(languageId);
    }

    private Languages convertToEntity(SaveLanguaguesResource resource){
        return mapper.map(resource, Languages.class);
    }

    private LanguagesResource convertToResource(Languages entity){
        return mapper.map(entity, LanguagesResource.class);
    }
}
