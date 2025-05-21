
package Clases;


public class TipoUsuario {
   private int idTipousuario;
   private String descripcion;
   private int idInt;

    public TipoUsuario(int idTipousuario, String descripcion, int idInt) {
        this.idTipousuario = idTipousuario;
        this.descripcion = descripcion;
        this.idInt = idInt;
    }

    public int getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(int idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdInt() {
        return idInt;
    }

    public void setIdInt(int idInt) {
        this.idInt = idInt;
    }
   
   
    
    
}
