package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Voluntary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntaryRepositoryImp implements VoluntaryRepository{
  @Autowired
    private Sql2o sql2o;
    @Override
    public int countVoluntary() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM \"Voluntary\"").executeScalar(Integer.class);
        }
        return total;
    }
    @Override
    public List<Voluntary> getAllVoluntaries() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary\"")
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Voluntary> getVoluntaryById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary\" WHERE id_voluntary = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Voluntary createVoluntary(Voluntary voluntary){
      try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO \"Voluntary\" (name,age,inventory,health,avalaible)"+
            "values (:voluntaryName,:voluntaryAge,:voluntaryInventory,:voluntaryHealth,:voluntaryAvalaible)")
                    .addParameter("voluntaryName", voluntary.getName())
                    .addParameter("voluntaryAge", voluntary.getAge())
                    .addParameter("voluntaryInventory", voluntary.getInventory())
                    .addParameter("voluntaryHealth", voluntary.getHealth())
                    .addParameter("voluntaryAvalaible", voluntary.getAvalaible())
                    .executeUpdate().getKey();
            return voluntary;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean editVoluntary(Voluntary voluntary) {
        try(Connection conn = sql2o.open()){
                conn.createQuery("UPDATE \"Voluntary\" SET name = :voluntaryName, age = :voluntaryAge, inventory = :voluntaryInventory, health = :voluntaryHealth, avalaible = :voluntaryAvalaible WHERE id_voluntary = :voluntaryId")
                        .addParameter("voluntaryName", voluntary.getName())
                        .addParameter("voluntaryAge", voluntary.getAge())
                        .addParameter("voluntaryInventory", voluntary.getInventory())
                        .addParameter("voluntaryAvalaible", voluntary.getAvalaible())
                        .addParameter("voluntaryHealth", voluntary.getHealth())
                        .addParameter("voluntaryId", voluntary.getId())
                        .executeUpdate();
                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
    }
    @Override
    public boolean deleteVoluntary(int id) {
        int deletedVoluntary;
        try(Connection conn = sql2o.open()){
            deletedVoluntary = conn.createQuery("DELETE FROM \"Voluntary\" WHERE id_voluntary = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedVoluntary == 1;
    }
}