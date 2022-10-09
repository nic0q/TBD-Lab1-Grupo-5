package com.tbd.lab1.services;

import com.tbd.lab1.models.StateTask;
import com.tbd.lab1.repositories.StateTaskRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StateTaskService {
    private final StateTaskRepository stateTaskRepository;

    public StateTaskService(StateTaskRepository stateTaskRepository) {
        this.stateTaskRepository = stateTaskRepository;
    }

    @GetMapping("/stateTasks")
    public List<StateTask> getAllStateTasks(){
        return stateTaskRepository.getAllStateTask();
    }

    @GetMapping("stateTasks/{id}")
    public List<StateTask> getStateTaskById(@PathVariable("id") Integer id){
        return stateTaskRepository.getStateTaskById(id);
    }

    @PostMapping("/stateTasks")
    @ResponseBody
    public StateTask createStateTask(@RequestBody StateTask stateTask){
        StateTask result = stateTaskRepository.createStateTask(stateTask);
        return result;
    }

    @PutMapping("/stateTasks/{id}")
    public String editStateTask(@PathVariable("id") int id, @RequestBody StateTask stateTask){
        stateTask.setId_state_task(id);
        boolean result = stateTaskRepository.editStateTask(stateTask);
        if(result) return "Estado de tarea editado";
        else return "Error al editar el estado de la tarea";
    }

    @DeleteMapping("/stateTasks/{id}")
    public String deleteStateTask(@PathVariable("id") int id){
        boolean result = stateTaskRepository.deleteStateTask(id);
        if(result) return "Estado de tarea eliminado";
        else return "Error al eliminar el estado de la tarea";
    }
}
