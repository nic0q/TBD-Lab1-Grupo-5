package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Emergency;

import java.util.List;

public interface EmergencyRepository {

    public List<Emergency> getAllEmergencies();

    public List<Emergency> getEmergencyById(int id);

    public Emergency createEmergency(Emergency emergency);
}
