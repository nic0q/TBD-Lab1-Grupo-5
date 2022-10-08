package com.tbd.lab1.models;

public class Task {
    private Integer id_task;
    private String description;
    private Integer fk_emergency;
    private Integer fk_state_task;


    public Integer getId() {
        return id_task;
    }

    public void setId(Integer id_task) {
        this.id_task = id_task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFk_emergency() {
        return fk_emergency;
    }

    public void setFk_emergency(Integer fk_emergency) {
        this.fk_emergency = fk_emergency;
    }

    public Integer getFk_state_task() {
        return fk_state_task;
    }

    public void setFk_state_task(Integer fk_state_task) {
        this.fk_state_task = fk_state_task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id_task=" + id_task +
                ", description='" + description + '\'' +
                ", fk_emergency=" + fk_emergency +
                ", fk_state_task=" + fk_state_task +
                '}';
    }
}
