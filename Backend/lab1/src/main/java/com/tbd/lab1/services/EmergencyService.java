package com.tbd.lab1.services;

import com.tbd.lab1.models.Emergency;
import com.tbd.lab1.repositories.EmergencyRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
