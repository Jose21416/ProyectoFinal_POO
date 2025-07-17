
package Datos;

import java.sql.Date;


public class DCodigo_verificacion {
    private int idCodigo;
    private int idUsuario;
    private int codigo;
    private Metodo metodo;
    private Date fecha_creacion; 
    private Date fecha_expiracion; 
    private int usado; 
    private int intentos;

    public DCodigo_verificacion() {
    }

    public DCodigo_verificacion(int idCodigo, int idUsuario, int codigo, Metodo metodo, Date fecha_creacion, Date fecha_expiracion, int usado, int intentos) {
        this.idCodigo = idCodigo;
        this.idUsuario = idUsuario;
        this.codigo = codigo;
        this.metodo = metodo;
        this.fecha_creacion = fecha_creacion;
        this.fecha_expiracion = fecha_expiracion;
        this.usado = usado;
        this.intentos = intentos;
    }
    
    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public int getUsado() {
        return usado;
    }

    public void setUsado(int usado) {
        this.usado = usado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    public enum Metodo{
        CORREO, SMS
    }
  
}
