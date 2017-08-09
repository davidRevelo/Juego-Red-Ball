package Clases;

/**
 *
 * @author Victor Pino
 */
public class ProyeGere {
    
    private Integer idProyecto;
    private Integer idGerente;

    public ProyeGere(Integer idProyecto, Integer idGerente) {
        this.idProyecto = idProyecto;
        this.idGerente = idGerente;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }
    
}
