package com.tbd.lab1.services;

import com.tbd.lab1.models.TaskAbility;
import com.tbd.lab1.repositories.TaskAbilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskAbilityService {
    private final TaskAbilityRepository taskAbilityRepository;

    TaskAbilityService(TaskAbilityRepository taskAbilityRepository){
        this.taskAbilityRepository = taskAbilityRepository;
    }

    @PostMapping("/tasks-abilities")
    @ResponseBody
    TaskAbility createTaskHability(@RequestBody TaskAbility taskHability){
        TaskAbility result = taskAbilityRepository.createTaskAbility(taskHability);
        return result;
    }

    @GetMapping("/tasks-abilities")
    public List<TaskAbility> getAllTaskHabilities(){
        return taskAbilityRepository.getAllTaskAbilities();
    }

    @GetMapping("/tasks-abilities/{id}")
    public List<TaskAbility> getTaskHabilityById(@PathVariable("id") int id){
        return taskAbilityRepository.getTaskAbilityById(id);
    }

    @PutMapping("/tasks-abilities/{id}")
    @ResponseBody
    public String editTaskHability(@PathVariable("id") int id, @RequestBody TaskAbility taskHability){
        taskHability.setId_task_ability(id);
        boolean result = taskAbilityRepository.editTaskAbility(taskHability);
        if (result){
            return "Tarea de habilidad editada";
        }else{
            return "Tarea de habilidad no encontrada";
        }
    }

    @DeleteMapping("/tasks-abilities/{id}")
    @ResponseBody
    public String deleteTaskHability(@PathVariable("id") int id){
        boolean result = taskAbilityRepository.deleteTaskAbility(id);
        if (result){
            return "Tarea de habilidad eliminada";
        }else{
            return "Tarea de habilidad no encontrada";
        }
    }

}
