/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leslie
 */
public class Documento {
    protected String nombre;
    protected String path;
    protected String fecha_subida;
    protected float peso;

    public Documento(String nombre, String path, String fecha_subida, float peso) {
        this.nombre = nombre;
        this.path = path;
        this.fecha_subida = fecha_subida;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(String fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    
}
