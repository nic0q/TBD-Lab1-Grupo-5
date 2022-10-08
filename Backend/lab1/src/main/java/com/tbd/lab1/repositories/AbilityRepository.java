package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Ability;

import java.util.List;


public interface AbilityRepository {

    public List<Ability> getAllHabilities();
    public List<Ability> getHabilityById(Integer id);
    public Ability createHability(Ability ability);
    public boolean editHability(Ability ability);
    public boolean deleteHability(Integer id);

}
