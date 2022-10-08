package com.tbd.lab1.models;

public class Ability {
    private Integer id_ability;
    private String name_ability;
    private String description_ability;

    public Ability(Integer id_ability, String name_ability, String description_ability) {
        this.id_ability = id_ability;
        this.name_ability = name_ability;
        this.description_ability = description_ability;
    }
    public Integer getId_ability() {
        return id_ability;
    }
    public void setId_ability(Integer id_ability) {
        this.id_ability = id_ability;
    }
    public String getName_ability() {
        return name_ability;
    }
    public void setName_ability(String name_ability) {
        this.name_ability = name_ability;
    }
    public String getDescription_ability() {
        return description_ability;
    }
    public void setDescription_ability(String description_ability) {
        this.description_ability = description_ability;
    }
    @Override
    public String toString() {
        return "ability{" +
                "id_ability=" + id_ability +
                ", name_ability='" + name_ability + '\'' +
                ", description_ability='" + description_ability + '\'' +
                '}';
    }
}
