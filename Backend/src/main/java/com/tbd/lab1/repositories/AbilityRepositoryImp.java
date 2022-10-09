package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class AbilityRepositoryImp implements AbilityRepository {

    @Autowired
    private Sql2o sql2o;
    @Override
    public List<Ability> getAllAbilities() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Ability\"").
                    executeAndFetch(Ability.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Ability> getAbilityById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Ability\" WHERE id_ability = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Ability createAbility(Ability ability) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Ability\" (name_ability, description_ability) " +
            "VALUES (:name_ability,:description_ability")
                    .addParameter("name_ability", ability.getName_ability())
                    .addParameter("description_ability", ability.getDescription_ability())
                    .executeUpdate().getKey();
            return ability;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean editAbility(Ability ability) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Ability\" SET name_ability = :name_ability, description_ability = :description_ability WHERE id_ability = :id_ability")
                    .addParameter("name_ability", ability.getName_ability())
                    .addParameter("description_ability", ability.getDescription_ability())
                    .addParameter("id_ability", ability.getId_ability())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public boolean deleteAbility(Integer id) {
        int deletedAbility;
        try(Connection conn = sql2o.open()){
            deletedAbility = conn.createQuery("DELETE FROM \"Ability\" WHERE id_ability = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedAbility == 1;
    }
}
