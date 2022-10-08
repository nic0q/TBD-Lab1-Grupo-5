package com.tbd.lab1.models;

public class TaskHability {
    private Integer id_task_hability;
    private Integer id_task;
    private Integer id_eme_hability;

    public Integer getId_task_hability() {
        return id_task_hability;
    }

    public Integer getId_task() {
        return id_task;
    }

    public Integer getId_eme_hability() {
        return id_eme_hability;
    }

    public void setId_task_hability(Integer id_task_hability) {
        this.id_task_hability = id_task_hability;
    }

    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }

    public void setId_eme_hability(Integer id_eme_hability) {
        this.id_eme_hability = id_eme_hability;
    }

    @Override
    public String toString() {
        return "taskHability{" +
                "id_task_hability=" + id_task_hability +
                ", id_task=" + id_task +
                ", id_eme_hability=" + id_eme_hability +
                '}';
    }
}
