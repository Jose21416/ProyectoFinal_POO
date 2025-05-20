
package Clases;

public class Permiso_has_rol {
    private int idPermiso;
    private int idRol;
    private int idUsuario;

    public Permiso_has_rol(int idPermiso, int idRol, int idUsuario) {
        this.idPermiso = idPermiso;
        this.idRol = idRol;
        this.idUsuario = idUsuario;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
