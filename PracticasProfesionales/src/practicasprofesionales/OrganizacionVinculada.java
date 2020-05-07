package practicasprofesionales;

public class OrganizacionVinculada {
    private String direccion;
    private String nombre;
    
    public OrganizacionVinculada(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
    }
        
    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String nombre) {
        this.nombre = nombre;
    }
  
}
