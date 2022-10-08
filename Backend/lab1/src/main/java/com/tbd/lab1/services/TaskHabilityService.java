package com.tbd.lab1.services;

import com.tbd.lab1.models.TaskHability;
import com.tbd.lab1.repositories.TaskHabilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskHabilityService {
    private final TaskHabilityRepository taskHabilityRepository;

    TaskHabilityService(TaskHabilityRepository taskHabilityRepository){
        this.taskHabilityRepository = taskHabilityRepository;
    }

    @PostMapping("/tasksHabilities")
    @ResponseBody
    TaskHability createTaskHability(@RequestBody TaskHability taskHability){
        TaskHability result = taskHabilityRepository.createTaskHability(taskHability);
        return result;
    }

    @GetMapping("/tasksHabilities")
    public List<TaskHability> getAllTaskHabilities(){
        return taskHabilityRepository.getAllTaskHabilities();
    }

    @GetMapping("/tasksHabilities/{id}")
    public List<TaskHability> getTaskHabilityById(@PathVariable("id") int id){
        return taskHabilityRepository.getTaskHabilityById(id);
    }

    @PutMapping("/tasksHabilities/{id}")
    @ResponseBody
    public String editTaskHability(@PathVariable("id") int id, @RequestBody TaskHability taskHability){
        taskHability.setId_task_hability(id);
        boolean result = taskHabilityRepository.editTaskHability(taskHability);
        if (result){
            return "Tarea de habilidad editada";
        }else{
            return "Tarea de habilidad no encontrada";
        }
    }

    @DeleteMapping("/tasksHabilities/{id}")
    @ResponseBody
    public String deleteTaskHability(@PathVariable("id") int id){
        boolean result = taskHabilityRepository.deleteTaskHability(id);
        if (result){
            return "Tarea de habilidad eliminada";
        }else{
            return "Tarea de habilidad no encontrada";
        }
    }

}
