
package Clases;

import java.time.LocalDate;

public class PerfilUsuario {
    private int idPerfil;
    private String direccion;
    private java.time.LocalDate fechaNacimiento;
    private String ocupacion;
    private String experienciaLaboral;
    private int idUsuario;

    public PerfilUsuario(int idPerfil, String direccion, LocalDate fechaNacimiento, String ocupacion, String experienciaLaboral, int idUsuario) {
        this.idPerfil = idPerfil;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.ocupacion = ocupacion;
        this.experienciaLaboral = experienciaLaboral;
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
