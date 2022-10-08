package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institution> getAllInstitutions(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Institution\"").
                    executeAndFetch(Institution.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institution> getInstitutionById(int id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Institution\" WHERE id_institution = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institution createInstitution(Institution institution){
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Institution\" (name, coordinator)" +
                    "values (:institutionName, :institutionCoordinator)")
                    .addParameter("institutionName", institution.getName())
                    .addParameter("institutionCoordinator", institution.getName_coordinator())
                    .executeUpdate().getKey();
            return institution;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editInstitution(Institution institution){
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Institution\" SET name = :institutionName")
                    .addParameter("institutionName", institution.getName())
                    .addParameter("institutionCoordinator", institution.getName_coordinator())
                    .addParameter("institutionId", institution.getId_institution())
                    .executeUpdate();
            return true;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteInstitution(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM \"Institution\" WHERE id_institution = :id")
                    .addParameter("id",id)
                    .executeUpdate();
            return true;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
