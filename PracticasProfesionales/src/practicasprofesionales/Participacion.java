package practicasprofesionales;

public class Participacion {
    private String fechafinal; //
    private String fechaInicio; //
    private String periodo;
    
    public Participacion(String fechaFinal, String fechaInicio, String periodo){
        this.fechafinal=fechaFinal;
        this.fechaInicio=fechaInicio;
        this.periodo=periodo;
    }
    
    public String getFechafinal() {
        return fechafinal;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
