package com.tbd.lab1.services;
import com.tbd.lab1.models.Institution;
import com.tbd.lab1.repositories.InstitutionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class InstitutionService {
    private final InstitutionRepository institutionRepository;
    InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/institutions")
    public List<Institution> getAllInstitutions(){
        return institutionRepository.getAllInstitutions();
    }

    @GetMapping("institution/{id}")
    public List<Institution> getInstitutionById(@PathVariable("id") int id){
        return institutionRepository.getInstitutionById(id);
    }
}
