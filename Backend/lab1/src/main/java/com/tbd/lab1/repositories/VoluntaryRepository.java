package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Voluntary;
import java.util.List;

public interface VoluntaryRepository {
  public int countVoluntary();

  public List<Voluntary> getAllVoluntaries();

  public Voluntary createVoluntary(Voluntary voluntary);

  public List<Voluntary> getVoluntaryById(int id);

  public boolean deleteVoluntary(int id);

  public boolean editVoluntary(Voluntary voluntary);
}