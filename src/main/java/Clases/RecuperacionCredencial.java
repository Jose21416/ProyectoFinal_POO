
package Clases;

import java.time.LocalDateTime;


public class RecuperacionCredencial {
    private int idRecuperacion;
    private String metodo;
    private String token;
    private java.time.LocalDateTime fechaSolicitud;
    private boolean expirado;
    private int idUsuario;

    public RecuperacionCredencial(int idRecuperacion, String metodo, String token, LocalDateTime fechaSolicitud, boolean expirado, int idUsuario) {
        this.idRecuperacion = idRecuperacion;
        this.metodo = metodo;
        this.token = token;
        this.fechaSolicitud = fechaSolicitud;
        this.expirado = expirado;
        this.idUsuario = idUsuario;
    }

    public int getIdRecuperacion() {
        return idRecuperacion;
    }

    public void setIdRecuperacion(int idRecuperacion) {
        this.idRecuperacion = idRecuperacion;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public boolean isExpirado() {
        return expirado;
    }

    public void setExpirado(boolean expirado) {
        this.expirado = expirado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
