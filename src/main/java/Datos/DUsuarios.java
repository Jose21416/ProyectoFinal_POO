/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author joset
 */
public class DUsuarios {
    
    private int id_usuario;
    private String usuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private String telefono;
    private TipoUsuario tipoUsuario;
    private Estado estado;

    public enum TipoUsuario {
        ESTUDIANTE, EGRESADO, SUPERVISOR, ADMINISTRADOR
    }
    
    public enum Estado {
        ACTIVO, INACTIVO
    }
    
    public DUsuarios() {
    }

    public DUsuarios(int id_usuario, String usuario, String nombre, String correo, String contraseña, String telefono, TipoUsuario tipoUsuario, Estado estado) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario != null ? tipoUsuario : TipoUsuario.ESTUDIANTE;
        this.estado = estado != null ? estado: Estado.ACTIVO;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
