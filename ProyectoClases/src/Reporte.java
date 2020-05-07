/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leslie
 */
public class Reporte {
    public String fecha_inicio;
    public String fecha_fin;
    public String status;
    public int horas_cubiertas;

    public Reporte(String fecha_inicio, String fecha_fin, String status, int horas_cubiertas) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.status = status;
        this.horas_cubiertas = horas_cubiertas;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHoras_cubiertas() {
        return horas_cubiertas;
    }

    public void setHoras_cubiertas(int horas_cubiertas) {
        this.horas_cubiertas = horas_cubiertas;
    }
    
    
}
