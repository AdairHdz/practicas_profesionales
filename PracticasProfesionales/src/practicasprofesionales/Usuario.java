package practicasprofesionales;


abstract class Usuario {
    private String apellidos;
    private String constrasenia;
    private String correo;
    private String nombres;
 
    public Usuario(String apellidos, String constrasenia, String correo, String nombres) {
        this.apellidos = apellidos;
        this.constrasenia = constrasenia;
        this.correo = correo;
        this.nombres = nombres;
    }
    public void cerrarSesion(){
        
    }
    public boolean iniciarSesion(){
        
    }
    public boolean registrar(){
      
    }
   
    public String getApellidos() {
        return apellidos;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombres() {
        return nombres;
    }
    
        public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
}
