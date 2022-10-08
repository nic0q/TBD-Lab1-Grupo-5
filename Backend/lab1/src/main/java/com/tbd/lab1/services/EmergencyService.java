package com.tbd.lab1.services;

import com.tbd.lab1.models.Emergency;
import com.tbd.lab1.repositories.EmergencyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergencyService {

    private final EmergencyRepository emergencyRepository;
    EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergencies(){
        return emergencyRepository.getAllEmergencies();
    }

    @GetMapping("emergencie/{id}")
    public List<Emergency> getEmergencyById(@PathVariable("id") int id){
        return emergencyRepository.getEmergencyById(id);
    }

    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        Emergency result = emergencyRepository.createEmergency(emergency);
        return result;
    }

    @PutMapping("/emergencies/{id}")
    public String editEmergency(@PathVariable("id") int id, @RequestBody Emergency emergency){
        emergency.setId_emergency(id);
        boolean result = emergencyRepository.editEmergency(emergency);
        if(result){
            return "Emergencia editada";
        }else {
            return "Emergencia no encontrada";
        }
    }

    @DeleteMapping("/emergencies/{id}")
    public String deleteEmergency(@PathVariable("id") int id){
        boolean result = emergencyRepository.deleteEmergency(id);
        if(result){
            return "Emergencia eliminada";
        }else{
            return "Emergencia no encontrada";
        }
    }
}
