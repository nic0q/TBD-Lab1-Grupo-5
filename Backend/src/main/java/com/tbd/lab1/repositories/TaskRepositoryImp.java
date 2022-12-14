package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Clase que implementa la interfaz TaskRepository.
 */
@Repository
public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;
    
    /** 
     * Método que cuenta la cantidad de tareas en la base de datos
     * @return int
     */
    @Override
    public int countTask() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM \"Task\"").executeScalar(Integer.class);
        }
        return total;
    }
    
    /** 
     * Método que retorna una lista con todas las tareas en la base de datos
     * @return List<Task>
     */
    @Override
    public List<Task> getAllTasks() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task\"")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /** 
     * Método que obtiene una tarea por su id
     * @param id
     * @return List<Task>
     */
    @Override
    public List<Task> getTaskById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task\" WHERE id_task = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /** 
     * Método que crea una tarea en la base de datos
     * @param task
     * @return Task
     */
    @Override
    public Task createTask(Task task){
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Task\" (description,fk_emergency,fk_state_task)"+
                            "values (:taskDescription,:taskFkEmergency,:taskFkState)")
                    .addParameter("taskDescription", task.getDescription())
                    .addParameter("taskFkEmergency", task.getFk_emergency())
                    .addParameter("taskFkState", task.getFk_state_task())
                    .executeUpdate().getKey();
            return task;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /** 
     * Método que edita una tarea en la base de datos	
     * @param task
     * @return boolean
     */
    @Override
    public boolean editTask(Task task) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Task\" SET description = :taskDescription, fk_emergency = :taskFkEmergency, fk_state_task = :taskFkState WHERE id_task = :taskId")
                    .addParameter("taskDescription", task.getDescription())
                    .addParameter("taskFkEmergency", task.getFk_emergency())
                    .addParameter("taskFkState", task.getFk_state_task())
                    .addParameter("voluntaryId", task.getId())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /** 
     * Método que elimina una tarea en la base de datos
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteTask(int id) {
        int deletedTask;
        try(Connection conn = sql2o.open()){
            deletedTask = conn.createQuery("DELETE FROM \"Task\" WHERE id_task = :id")
                    .addParameter("id_task", id)
                    .executeUpdate().getResult();
        }
        return deletedTask == 1;
    }

    /**
     * Método que elimina las tareas de la base de datos
     * @return int
     */
    @Override
    public int deleteAllTask() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Task\" CASCADE")
                    .executeUpdate().getResult();
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}