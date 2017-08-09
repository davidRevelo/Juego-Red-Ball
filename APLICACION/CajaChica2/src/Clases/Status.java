package Clases;

/**
 *
 * @author Victor Pino
 */
public class Status {
    
    private Integer idStatus;
    private String nombre;

    public Status(Integer idStatus, String nombre) {
        this.idStatus = idStatus;
        this.nombre = nombre;
    }
    
    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
