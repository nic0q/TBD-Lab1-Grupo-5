package com.tbd.lab1.services;

import com.tbd.lab1.models.Ability;
import com.tbd.lab1.repositories.AbilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @GetMapping("/abilities")
    public List<Ability> getAllAbilities(){
        return abilityRepository.getAllAbilities();
    }

    @GetMapping("abilities/{id}")
    public List<Ability> getAbilityById(@PathVariable("id") Integer id){
        return abilityRepository.getAbilityById(id);
    }

    @PostMapping("/abilities")
    @ResponseBody
    public Ability createAbility(@RequestBody Ability ability){
        Ability result = abilityRepository.createAbility(ability);
        return result;
    }

    @PutMapping("/abilities/{id}")
    public String editAbility(@PathVariable("id") int id, @RequestBody Ability ability){
        ability.setId_ability(id);
        boolean result = abilityRepository.editAbility(ability);
        if(result) return "Habilidad editada";
        else return "Error al editar la habilidad";
    }

    @DeleteMapping("/abilities/{id}")
    public String deleteAbility(@PathVariable("id") int id){
        boolean result = abilityRepository.deleteAbility(id);
        if(result) return "Habilidad eliminada";
        else return "Error al eliminar la habilidad";
    }
}
