package practicasprofesionales;

public class Eleccion {
    private String fecha; //
    private int nivelEleccion;
    private String periodo;
    
    
    public Eleccion(String fecha, int nivelEleccion, String periodo){
        this.fecha=fecha;
        this.nivelEleccion=nivelEleccion;
        this.periodo=periodo;
    }
    
    public String getFecha() {
        return fecha;
    }

    public int getNivelEleccion() {
        return nivelEleccion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNivelEleccion(int nivelEleccion) {
        this.nivelEleccion = nivelEleccion;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
