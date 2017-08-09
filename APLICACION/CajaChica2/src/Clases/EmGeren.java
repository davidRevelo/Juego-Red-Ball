package Clases;

/**
 *
 * @author Victor Pino
 */
public class EmGeren {
    
    private Integer idEmpleado;
    private Integer idGerente;

    public EmGeren(Integer idEmpleado, Integer idGerente) {
        this.idEmpleado = idEmpleado;
        this.idGerente = idGerente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }
    
}
