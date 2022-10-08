package com.tbd.lab1.repositories;

import com.tbd.lab1.models.TaskHability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskHabilityRepositoryImp implements TaskHabilityRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public TaskHability createTaskHability(TaskHability taskHability) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"TaskHability\" (id_task_hability, id_task, id_eme_hability) "+
                            "VALUES (:id_task_hability, :id_task, :id_hability)")
                    .addParameter("id_task_hability", taskHability.getId_task_hability())
                    .addParameter("id_task", taskHability.getId_task())
                    .addParameter("id_eme_hability", taskHability.getId_eme_hability())
                    .executeUpdate().getKey();
            return taskHability;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskHability> getAllTaskHabilities(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"TaskHability\"").
                    executeAndFetch(TaskHability.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskHability> getTaskHabilityById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"TaskHability\" WHERE id_task_hability = :id")
                    .addParameter("id", id)
                    .executeAndFetch(TaskHability.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editTaskHability(TaskHability taskHability){
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"TaskHability\" SET id_task_hability = :taskHabilityIdTaskHability, id_task = :taskHabilityIdTask, id_eme_hability = :taskHabilityIdEmeHability WHERE id_task_hability = :taskHabilityIdTaskHability")
                    .addParameter("id_task_hability", taskHability.getId_task_hability())
                    .addParameter("id_task", taskHability.getId_task())
                    .addParameter("id_eme_hability", taskHability.getId_eme_hability())
                    .executeUpdate();
            return true;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTaskHability(int id){
        int deletedTaskHability;
        try(Connection conn = sql2o.open()){
            deletedTaskHability = conn.createQuery("DELETE FROM \"TaskHability\" WHERE id_task_hability = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedTaskHability == 1;
    }

}
