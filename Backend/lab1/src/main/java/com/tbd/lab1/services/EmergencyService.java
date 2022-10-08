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

    @GetMapping("emergency/{id}")
    public List<Emergency> getEmergencyById(@PathVariable("id") int id){
        return emergencyRepository.getEmergencyById(id);
    }

    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        Emergency result = emergencyRepository.createEmergency(emergency);
        return result;
    }
}
