package com.tbd.lab1.repositories;

import com.tbd.lab1.models.TaskHability;

import java.util.List;

public interface TaskHabilityRepository {

    public TaskHability createTaskHability(TaskHability taskHability);
    public List<TaskHability> getAllTaskHabilities();
    public List<TaskHability> getTaskHabilityById(int id);
    public boolean editTaskHability(TaskHability taskHability);
    public boolean deleteTaskHability(int id);
}
