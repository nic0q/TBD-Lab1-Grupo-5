package com.tbd.lab1.services;

import com.tbd.lab1.models.Voluntary;
import com.tbd.lab1.repositories.VoluntaryRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntaryService {

    private final VoluntaryRepository voluntaryRepository;
    VoluntaryService(VoluntaryRepository voluntaryRepository){
        this.voluntaryRepository = voluntaryRepository;
    }

    @GetMapping("/voluntaries")
    public List<Voluntary> getAllVoluntaries() {
        return voluntaryRepository.getAllVoluntaries();
    }
    @GetMapping("/voluntaries/{rut}")
    public List<Voluntary> getVoluntaryById(@PathVariable("rut") String rut) {
        return voluntaryRepository.getVoluntaryByRut(rut);
    }
    @GetMapping("/voluntaries/count")
    public String countVoluntary(){
        int total = voluntaryRepository.countVoluntary();
        return String.format("Tienes %s Voluntarios", total);
    }

    @PostMapping("/voluntaries")
    @ResponseBody
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary){
        Voluntary result = voluntaryRepository.createVoluntary(voluntary);
        return result;
    }

    @PutMapping("/voluntaries/{rut}")
    @ResponseBody
    public String editVoluntary(@PathVariable("rut") String rut, @RequestBody Voluntary voluntary){
        voluntary.setRut(rut);
        boolean result = voluntaryRepository.editVoluntary(voluntary);
        if (result){
            return "Voluntario editado";
        }else{
            return "Voluntario no encontrado";
        }
    }
    @DeleteMapping("/voluntaries/{rut}")
    @ResponseBody
    public String deleteVoluntary(@PathVariable("rut") String rut){
        boolean result = voluntaryRepository.deleteVoluntary(rut);
        if (result){
            return "Voluntario eliminado";
        }else{
            return "Voluntario no encontrado";
        }
    }
}