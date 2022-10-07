package com.tbd.lab1.models;

public class Emergency{
    private Integer id_emergency;
    private String emergency_details;
    private String requirements;
    private String status;
    private Integer id_institucion;


    public Integer getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getEmergency_details() {
        return emergency_details;
    }

    public void setEmergency_details(String emergency_details) {
        this.emergency_details = emergency_details;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "id_emergency=" + id_emergency +
                ", emergency_details='" + emergency_details + '\'' +
                ", requirements='" + requirements + '\'' +
                ", status='" + status + '\'' +
                ", id_institucion=" + id_institucion +
                '}';
    }
}
