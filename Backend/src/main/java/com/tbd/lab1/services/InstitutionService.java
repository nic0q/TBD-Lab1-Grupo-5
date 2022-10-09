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

    @PutMapping("/institutions/{id}")
    public String editInstitution(@PathVariable("id") int id, @RequestBody Institution institution){
        institution.setId_institution(id);
        boolean result = institutionRepository.editInstitution(institution);
        if(result){
            return "Institución editada";
        }else {
            return "Institución no encontrada";
        }
    }

    @DeleteMapping("/institutions/{id}")
    public String deleteInstitution(@PathVariable("id") int id) {
        boolean result = institutionRepository.deleteInstitution(id);
        if (result) {
            return "Institución eliminada";
        } else {
            return "Institución no encontrada";
        }
    }
}
