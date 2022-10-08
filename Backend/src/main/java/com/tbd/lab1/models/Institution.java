package com.tbd.lab1.models;

public class Institution {
    private Integer id_institution;
    private String name;
    private String name_coordinator;

    public Integer getId_institution() {
        return id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_coordinator() {
        return name_coordinator;
    }

    public void setName_coordinator(String name_coordinator) {
        this.name_coordinator = name_coordinator;
    }
    
    @Override
    public String toString() {
        return "Institution{" +
                "id_institution=" + id_institution +
                ", name='" + name + '\'' +
                ", name_coordinator='" + name_coordinator + '\'' +
                '}';
    }
}
