package com.tbd.lab1.services;

import com.tbd.lab1.models.Task;
import com.tbd.lab1.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskService {
    private final TaskRepository taskRepository;
    TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllVoluntaries() {
        return taskRepository.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public List<Task> getTaskById(@PathVariable("id") int id) {
        return taskRepository.getTaskById(id);
    }
    @GetMapping("/tasks/count")
    public String countTask(){
        int total = taskRepository.countTask();
        return String.format("Tienes %s tareas", total);
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task task){
        Task result = taskRepository.createTask(task);
        return result;
    }

    @PutMapping("/task/{id}")
    @ResponseBody
    public String editTask(@PathVariable("id") int id, @RequestBody Task task){
        task.setId(id);
        boolean result = taskRepository.editTask(task);
        if (result){
            return "Tarea editada";
        }else{
            return "Tarea no encontrada";
        }
    }
    @DeleteMapping("/task/{id}")
    @ResponseBody
    public String deleteTask(@PathVariable("id") int id){
        boolean result = taskRepository.deleteTask(id);
        if (result){
            return "Tarea eliminada";
        }else{
            return "Tarea no encontrada";
        }
    }
}
