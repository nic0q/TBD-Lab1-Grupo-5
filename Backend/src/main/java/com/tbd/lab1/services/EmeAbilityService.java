package com.tbd.lab1.services;

import com.tbd.lab1.models.EmeAbility;
import com.tbd.lab1.repositories.EmeAbilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmeAbilityService {

    private final EmeAbilityRepository emeAbilityRepository;
    EmeAbilityService(EmeAbilityRepository emeAbilityRepository){
        this.emeAbilityRepository = emeAbilityRepository;
    }

    @PostMapping("/eme-abilities")
    @ResponseBody
    EmeAbility createEmeAbility(@RequestBody EmeAbility emeAbility){
        EmeAbility result = emeAbilityRepository.createEmeAbility(emeAbility);
        return result;
    }

    @GetMapping("/eme-abilities")
    public List<EmeAbility> getAllEmeAbilities(){
        return emeAbilityRepository.getAllEmeAbilities();
    }

    @GetMapping("/eme-abilities/{id}")
    public List<EmeAbility> getEmeAbilityById(@PathVariable("id") int id){
        return emeAbilityRepository.getEmeAbilityById(id);
    }

    @PutMapping("/eme-abilities/{id}")
    @ResponseBody
    public String editEmeAbility(@PathVariable("id") int id, @RequestBody EmeAbility emeAbility){
        emeAbility.setId_eme_ability(id);
        boolean result = emeAbilityRepository.editEmeAbility(emeAbility);
        if (result){
            return "Habilidad de emergencia editada";
        }else{
            return "Habilidad de emergencia no encontrada";
        }
    }

    @DeleteMapping("/eme-abilities/{id}")
    @ResponseBody
    public String deleteEmeHability(@PathVariable("id") int id){
        boolean result = emeAbilityRepository.deleteEmeAbility(id);
        if (result){
            return "Habilidad de emergencia eliminada";
        }else{
            return "Habilidad de emergencia no encontrada";
        }
    }

    @DeleteMapping("/eme-abilities")
    public String deleteAllEmeHability(){
        int result = emeAbilityRepository.deleteAllEmeAbility();
        if(result == 1){
            return "Todas las habilidades de emergencia han sido eliminadas";
        }else{
            return "Ha ocurrido un error al intentar borrar las habilidades de emergencia";
        }
    }
}
