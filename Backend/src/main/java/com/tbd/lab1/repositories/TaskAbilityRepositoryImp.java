package com.tbd.lab1.repositories;

import com.tbd.lab1.models.TaskAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskAbilityRepositoryImp implements TaskAbilityRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public TaskAbility createTaskAbility(TaskAbility taskAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Task_ability\" (id_task, id_eme_ability) "+
                            "VALUES (:id_task, :id_ability)")
                    .addParameter("id_task", taskAbility.getId_task())
                    .addParameter("id_eme_ability", taskAbility.getId_eme_ability())
                    .executeUpdate().getKey();
            return taskAbility;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskAbility> getAllTaskAbilities(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task_ability\"").
                    executeAndFetch(TaskAbility.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskAbility> getTaskAbilityById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task_ability\" WHERE id_task_ability = :id")
                    .addParameter("id", id)
                    .executeAndFetch(TaskAbility.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editTaskAbility(TaskAbility taskAbility){
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Task_ability\" SET id_task = :taskAbilityIdTask, id_eme_ability = :taskAbilityIdEmeHability WHERE id_task_ability = :taskHabilityIdTaskAbility")
                    .addParameter("id_task_ability", taskAbility.getId_task_ability())
                    .addParameter("id_task", taskAbility.getId_task())
                    .addParameter("id_eme_ability", taskAbility.getId_eme_ability())
                    .executeUpdate();
            return true;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTaskAbility(int id){
        int deletedTaskAbility;
        try(Connection conn = sql2o.open()){
            deletedTaskAbility = conn.createQuery("DELETE FROM \"Task_ability\" WHERE id_task_ability = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedTaskAbility == 1;
    }

}