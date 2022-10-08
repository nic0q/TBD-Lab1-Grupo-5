package com.tbd.lab1.models;

public class EmeAbility {
    private Integer id_eme_ability;
    private Integer id_ability;
    private Integer id_emergency;

    public Integer getId_eme_ability() {
        return id_eme_ability;
    }

    public Integer getId_ability() {
        return id_ability;
    }

    public Integer getId_emergency() {
        return id_emergency;
    }

    public void setId_eme_ability(Integer id_eme_ability) {
        this.id_eme_ability = id_eme_ability;
    }

    public void setId_ability(Integer id_ability) {
        this.id_ability = id_ability;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

    @Override
    public String toString() {
        return "emeAbility{" +
                "id_eme_ability=" + id_eme_ability +
                ", id_ability=" + id_ability +
                ", id_emergency=" + id_emergency +
                '}';
    }
}
