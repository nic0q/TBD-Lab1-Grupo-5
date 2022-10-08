package com.tbd.lab1.models;

public class TaskAbility {
    private Integer id_task_ability;
    private Integer id_task;
    private Integer id_eme_ability;

    public Integer getId_task_ability() {
        return id_task_ability;
    }

    public Integer getId_task() {
        return id_task;
    }

    public Integer getId_eme_ability() {
        return id_eme_ability;
    }

    public void setId_task_ability(Integer id_task_ability) {
        this.id_task_ability = id_task_ability;
    }

    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }

    public void setId_eme_ability(Integer id_eme_ability) {
        this.id_eme_ability = id_eme_ability;
    }

    @Override
    public String toString() {
        return "taskAbility{" +
                "id_task_ability=" + id_task_ability +
                ", id_task=" + id_task +
                ", id_eme_ability=" + id_eme_ability +
                '}';
    }
}