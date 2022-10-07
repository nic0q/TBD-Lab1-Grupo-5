package com.tbd.lab1.models;

public class Voluntary {
    private Integer id_voluntary;
    private String name;
    private Integer age;
    private String inventory;
    private Integer health;
    private Boolean avalaible;

    public Integer getId() {
        return id_voluntary;
    }

    public void setId(Integer id_voluntary) {
        this.id_voluntary = id_voluntary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Boolean getAvalaible() {
        return avalaible;
    }

    public void setAvalaible(Boolean avalaible) {
        this.avalaible = avalaible;
    }

    public void changeAvalaible(){
        this.avalaible = !this.avalaible;
    }

    public void notAvalaible(){
        this.avalaible = false;
    }

    public void trueAvalaible(){
        this.avalaible = true;
    }

    @Override
    public String toString() {
        return "Voluntary{" +
                "id_voluntary=" + id_voluntary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", inventory='" + inventory + '\'' +
                ", health=" + health +
                ", avalaible=" + avalaible +
                '}';
    }
}