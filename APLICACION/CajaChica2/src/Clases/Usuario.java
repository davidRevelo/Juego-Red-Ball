package Clases;

/**
 *
 * @author Victor Pino
 */
public class Usuario {
    
    private Integer idUsuario;
    private Integer idTipo;
    private String usuario;
    private String clave;
    private String correo;

    public Usuario(Integer idUsuario, Integer idTipo, String usuario, String clave, String correo) {
        this.idUsuario = idUsuario;
        this.idTipo = idTipo;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
