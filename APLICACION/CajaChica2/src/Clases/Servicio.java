package Clases;

/**
 *
 * @author Victor Pino
 */
public class Servicio {
    
    private Integer idServicio;
    private String nombre;
    private String descripcion;

    public Servicio(Integer idServicio, String nombre, String descripcion) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
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
    
    
    
}
