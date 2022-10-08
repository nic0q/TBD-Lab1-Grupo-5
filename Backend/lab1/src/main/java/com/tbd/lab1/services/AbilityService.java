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
    public List<Ability> getAllHabilities(){
        return abilityRepository.getAllHabilities();
    }

    @GetMapping("abilities/{id}")
    public List<Ability> getHabilityById(@PathVariable("id") Integer id){
        return abilityRepository.getHabilityById(id);
    }

    @PostMapping("/abilities")
    @ResponseBody
    public Ability createHability(@RequestBody Ability ability){
        Ability result = abilityRepository.createHability(ability);
        return result;
    }

    @PutMapping("/abilities/{id}")
    public String editHability(@PathVariable("id") int id, @RequestBody Ability ability){
        ability.setId_ability(id);
        boolean result = abilityRepository.editHability(ability);
        if(result) return "Habilidad editada";
        else return "Error al editar la habilidad";
    }

    @DeleteMapping("/abilities/{id}")
    public String deleteAbility(@PathVariable("id") int id){
        boolean result = abilityRepository.deleteHability(id);
        if(result) return "Habilidad eliminada";
        else return "Error al eliminar la habilidad";
    }
}
