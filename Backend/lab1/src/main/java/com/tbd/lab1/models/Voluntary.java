package com.tbd.lab1.models;

public class Voluntary {
    private String rut;
    private String name;
    private Integer age;
    private Boolean avalaible;
    public void setRut(String rut) {
      this.rut = rut;
    }
    public void setName(String name) {
      this.name = name;
    }
    public void setAge(Integer age) {
      this.age = age;
    }
    public void setAvalaible(Boolean avalaible) {
      this.avalaible = avalaible;
    }
    public String getRut() {
        return rut;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Boolean getAvalaible() {
        return avalaible;
    }
}