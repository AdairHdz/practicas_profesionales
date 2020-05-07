/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leslie
 */
public class Expediente {
    private String comentarios;
    private float calificacion_final;
    private int total_horas_realizadas;

    public Expediente(String comentarios, float calificacion_final, int total_horas_realizadas) {
        this.comentarios = comentarios;
        this.calificacion_final = calificacion_final;
        this.total_horas_realizadas = total_horas_realizadas;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public float getCalificacion_final() {
        return calificacion_final;
    }

    public void setCalificacion_final(float calificacion_final) {
        this.calificacion_final = calificacion_final;
    }

    public int getTotal_horas_realizadas() {
        return total_horas_realizadas;
    }

    public void setTotal_horas_realizadas(int total_horas_realizadas) {
        this.total_horas_realizadas = total_horas_realizadas;
    }
    
    
}
