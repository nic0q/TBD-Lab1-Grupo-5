package com.tbd.lab1.repositories;

import com.tbd.lab1.models.EmeAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeAbilityRepositoryImp implements EmeAbilityRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public EmeAbility createEmeAbility(EmeAbility emeAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Eme_ability\" (id_ability, id_emergency) "+
                            "VALUES (:id_ability, :id_emergency)")
                    .addParameter("id_ability", emeAbility.getId_ability())
                    .addParameter("id_emergency", emeAbility.getId_emergency())
                    .executeUpdate().getKey();
            return emeAbility;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmeAbility> getAllEmeAbilities() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Eme_ability\"").
                    executeAndFetch(EmeAbility.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmeAbility> getEmeAbilityById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Eme_ability\" WHERE id_eme_ability = :id")
                    .addParameter("id", id)
                    .executeAndFetch(EmeAbility.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editEmeAbility(EmeAbility emeAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Eme_ability\" SET id_eme_ability = :emeAbilityIdEmeAbility, id_ability = :emeAbilityIdAbility, id_emergency = :emeAbilityIdEmergency WHERE id_eme_ability = :emeAbilityIdEmeAbility")
                    .addParameter("id_eme_ability", emeAbility.getId_eme_ability())
                    .addParameter("id_ability", emeAbility.getId_ability())
                    .addParameter("id_emergency", emeAbility.getId_emergency())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmeAbility(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM \"Eme_ability\" WHERE id_eme_ability = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
