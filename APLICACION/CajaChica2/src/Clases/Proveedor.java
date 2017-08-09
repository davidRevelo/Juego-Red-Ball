package Clases;

/**
 *
 * @author Victor Pino
 */
public class Proveedor {
    
    private Integer idProveedor;
    private String rifCed;
    private String nombre;
    private String telefono;
    private String descripcion;

    public Proveedor(Integer idProveedor, String rifCed, String nombre, String telefono, String descripcion) {
        this.idProveedor = idProveedor;
        this.rifCed = rifCed;
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRifCed() {
        return rifCed;
    }

    public void setRifCed(String rifCed) {
        this.rifCed = rifCed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
