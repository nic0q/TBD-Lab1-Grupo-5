package com.tbd.lab1.models;

/**
 * Clase que representa un ranking
 */
public class Ranking {
    private Integer id_ranking;
    private Integer id_task;
    private String rut_voluntary;

    
    /** 
     * Obtiene el id (integer) de un Ranking
     * @return Integer
     */
    public Integer getId_ranking() {
        return id_ranking;
    }

    
    /** 
     * Modifica un id (integer) a un Ranking
     * @param id_ranking
     */
    public void setId_ranking(Integer id_ranking) {
        this.id_ranking = id_ranking;
    }

    
    /** 
     * Obtiene el id de una tarea (integer) de un Ranking
     * @return Integer
     */
    public Integer getId_task() {
        return id_task;
    }

    
    /** 
     * Modifica el id de una tarea (integer) a un Ranking
     * @param id_task
     */
    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }

    
    /** 
     * Obtiene el rut de un voluntario (string) de un Ranking
     * @return String
     */
    public String getRut_voluntary() {
        return rut_voluntary;
    }

    
    /** 
     * Modifica el rut de un voluntario (string) a un Ranking
     * @param rut_voluntary
     */
    public void setRut_voluntary(String rut_voluntary) {
        this.rut_voluntary = rut_voluntary;
    }
}
