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
    public List<Voluntary> getVoluntaryByRut(String rut) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary\" WHERE rut = :rut")
                    .addParameter("rut", rut)
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Voluntary createVoluntary(Voluntary voluntary){
      try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Voluntary\" (rut,name,age,avalaible)"+
            "values (:voluntaryRut,:voluntaryName,:voluntaryAge,:voluntaryAvalaible)")
                    .addParameter("voluntaryRut", voluntary.getRut())
                    .addParameter("voluntaryName", voluntary.getName())
                    .addParameter("voluntaryAge", voluntary.getAge())
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
                conn.createQuery("UPDATE \"Voluntary\" SET name = :name, age = :age, avalaible = :avalaible WHERE rut = :rut")
                        .addParameter("rut", voluntary.getRut())
                        .addParameter("name", voluntary.getName())
                        .addParameter("age", voluntary.getAge())
                        .addParameter("avalaible", voluntary.getAvalaible())
                        .executeUpdate();
                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
    }
    @Override
    public boolean deleteVoluntary(String rut) {
        int deletedVoluntary;
        try(Connection conn = sql2o.open()){
            deletedVoluntary = conn.createQuery("DELETE FROM \"Voluntary\" WHERE rut = :rut")
                    .addParameter("rut", rut)
                    .executeUpdate().getResult();
        }
        return deletedVoluntary == 1;
    }
}