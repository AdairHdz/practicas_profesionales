package practicasprofesionales;


public class Estudiante extends Usuario{
    private String matricula;
    public String telefono;

    public Estudiante(String matricula, String telefono, String apellidos, String constrasenia, String correo, String nombres) {
        super(apellidos, constrasenia, correo, nombres);
        this.matricula = matricula;
        this.telefono = telefono;
    }
    
    public void consultarProgreso(){
        
    }
    
    public boolean elegirProyecto(){
        
    }
    
    public String getMatricula() {
        return matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTelefono(String telefono) { 
        this.telefono = telefono;
    }

}
