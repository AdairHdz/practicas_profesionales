public class Profesor {
   private String apellidos;
   private String nombres;
   private String numDePersonal;

   public Profesor(String apellidos, String nombres, String numDePersonal){
       this.apellidos=apellidos;
       this.nombres=nombres;
       this.numDePersonal=numDePersonal;
   }
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumDePersonal() {
        return numDePersonal;
    }

    public void setNumDePersonal(String numDePersonal) {
        this.numDePersonal = numDePersonal;
    }
}
