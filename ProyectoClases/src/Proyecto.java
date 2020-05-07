/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leslie
 */
public class Proyecto {
    private String nombre;
    private String descripcion;
    private String fecha;
    private String horario;
    private String status;
    private String metodologia;
    private String actividades;
    private String objetivo_general;
    private String objetivos_inmediatos;
    private String objetivos_mediatos;
    private int numero_de_estudiantes_solicitados;
    private int numero_de_estudiantes_asignados;

    public Proyecto(String nombre, String descripcion, String fecha, String horario, String status, String metodologia, String actividades, String objetivo_general, String objetivos_inmediatos, String objetivos_mediatos, int numero_de_estudiantes_solicitados, int numero_de_estudiantes_asignados) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horario = horario;
        this.status = status;
        this.metodologia = metodologia;
        this.actividades = actividades;
        this.objetivo_general = objetivo_general;
        this.objetivos_inmediatos = objetivos_inmediatos;
        this.objetivos_mediatos = objetivos_mediatos;
        this.numero_de_estudiantes_solicitados = numero_de_estudiantes_solicitados;
        this.numero_de_estudiantes_asignados = numero_de_estudiantes_asignados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getObjetivo_general() {
        return objetivo_general;
    }

    public void setObjetivo_general(String objetivo_general) {
        this.objetivo_general = objetivo_general;
    }

    public String getObjetivos_inmediatos() {
        return objetivos_inmediatos;
    }

    public void setObjetivos_inmediatos(String objetivos_inmediatos) {
        this.objetivos_inmediatos = objetivos_inmediatos;
    }

    public String getObjetivos_mediatos() {
        return objetivos_mediatos;
    }

    public void setObjetivos_mediatos(String objetivos_mediatos) {
        this.objetivos_mediatos = objetivos_mediatos;
    }

    public int getNumero_de_estudiantes_solicitados() {
        return numero_de_estudiantes_solicitados;
    }

    public void setNumero_de_estudiantes_solicitados(int numero_de_estudiantes_solicitados) {
        this.numero_de_estudiantes_solicitados = numero_de_estudiantes_solicitados;
    }

    public int getNumero_de_estudiantes_asignados() {
        return numero_de_estudiantes_asignados;
    }

    public void setNumero_de_estudiantes_asignados(int numero_de_estudiantes_asignados) {
        this.numero_de_estudiantes_asignados = numero_de_estudiantes_asignados;
    }
    
    
}
