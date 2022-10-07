package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class EmergencyRepositoryImp implements EmergencyRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergency> getAllEmergencies(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Emergency\"").
                    executeAndFetch(Emergency.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
