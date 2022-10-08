package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
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

    @Override
    public List<Emergency> getEmergencyById(int id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Emergency\" WHERE id_emergency = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Emergency.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergency createEmergency(Emergency emergency){
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Emergency\" (emergency_details, requirements, id_institution, status)" +
                    "values (:emergencyDetails, :emergencyRequirements, :emergencyInstitution, :emergencyStatus)")
                    .addParameter("emergencyDetails", emergency.getEmergency_details())
                    .addParameter("emergencyRequirements", emergency.getRequirements())
                    .addParameter("emergencyInstitution", emergency.getId_institution())
                    .addParameter("emergencyStatus", emergency.getStatus())
                    .executeUpdate().getKey();
            return emergency;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editEmergency(Emergency emergency){
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Emergency\" SET emergency_details = :emergencyDetails, requirements = :emergencyRequirements, id_institution = :emergencyInstitution, status = :emergencyStatus WHERE id_emergency = :emergencyId")
                    .addParameter("emergencyDetails", emergency.getEmergency_details())
                    .addParameter("emergencyRequirements", emergency.getRequirements())
                    .addParameter("emergencyInstitution", emergency.getId_institution())
                    .addParameter("emergencyStatus", emergency.getStatus())
                    .addParameter("emergencyId", emergency.getId_emergency())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmergency(int id){
        int deletedEmergency;
        try(Connection conn = sql2o.open()){
            deletedEmergency = conn.createQuery("DELETE FROM \"Emergency\" WHERE id_emergency = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedEmergency == 1;
    }
}
