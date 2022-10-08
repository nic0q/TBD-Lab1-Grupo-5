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

    @GetMapping("institutions/{id}")
    public List<Institution> getInstitutionById(@PathVariable("id") int id){
        return institutionRepository.getInstitutionById(id);
    }

    @PostMapping("/institutions")
    public Institution createInstitution(@RequestBody Institution institution){
        return institutionRepository.createInstitution(institution);
    }

    @PutMapping("/institutions")
    public boolean editInstitution(@RequestBody Institution institution){
        return institutionRepository.editInstitution(institution);
    }

    @DeleteMapping("/institutions/{id}")
    public boolean deleteInstitution(@PathVariable("id") int id){
        return institutionRepository.deleteInstitution(id);
    }
}
