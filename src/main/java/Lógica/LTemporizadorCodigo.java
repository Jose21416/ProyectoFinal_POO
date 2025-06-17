
package Lógica;
import javax.swing.*;
import java.awt.event.*;
public class LTemporizadorCodigo {
    private int segundos;
    private final int DURACION_DEFAULT = 60;
    private Timer timer;
    private JLabel lblContador;
    private JButton btnReenviar;

    public LTemporizadorCodigo(int segundos, JLabel lblContador, JButton btnReenviar) {
        this.segundos = DURACION_DEFAULT;
        this.lblContador = lblContador;
        this.btnReenviar = btnReenviar;
        configurarTemporizador();
    }

    private void configurarTemporizador() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos--;
                lblContador.setText("Código valido por: "+segundos+ " segundos");
                
                if (segundos <= 0 ){
                    Detener ();
                    lblContador.setText("Código expirado");
                    btnReenviar.setEnabled(true);
                }
            }
        });
    }
    public void Iniciar(){
        segundos = DURACION_DEFAULT;
        lblContador.setText("Código valido por: "+segundos+ " segundos");
        btnReenviar.setEnabled(false);
        timer.start();
    }
    
    public void Reiniciar (){
        Detener ();
        Iniciar();
    }

    private void Detener() {
        if (timer != null && timer.isRunning()){
            timer.stop();
        }
    }
    
    public boolean estaCorriendo(){
        return timer != null && timer.isRunning();
    }
}
