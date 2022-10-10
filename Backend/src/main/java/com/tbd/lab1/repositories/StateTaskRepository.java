package com.tbd.lab1.repositories;


import com.tbd.lab1.models.StateTask;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StateTaskRepository {
    public List<StateTask> getAllStateTask();
    public List<StateTask> getStateTaskById(Integer id);
    public StateTask createStateTask(StateTask stateTask);
    public boolean editStateTask(StateTask stateTask);
    public boolean deleteStateTask(Integer id);

    public boolean deleteAllStateTask();
}
