package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilityRepositoryImp implements HabilityRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ability> getAllHabilities() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Hability\"").
                    executeAndFetch(Ability.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ability> getHabilityById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Hability\" WHERE id_hability = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ability createHability(Ability ability) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO \"Hability\" (name, description) " +
                            "values (:name, :description")
                    .addParameter("name", ability.getName_ability())
                    .addParameter("description", ability.getDescription_ability())
                    .executeUpdate().getKey();
            return ability;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editHability(Ability ability) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Hability\" SET name = :name, description = :description WHERE id_hability = :id_hability")
                    .addParameter("name", ability.getName_ability())
                    .addParameter("description", ability.getDescription_ability())
                    .addParameter("id_hability", ability.getId_ability())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteHability(Integer id) {
        int deletedHability;
        try(Connection conn = sql2o.open()){
            deletedHability = conn.createQuery("DELETE FROM \"Hability\" WHERE id_hability = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedHability == 1;
    }
}
