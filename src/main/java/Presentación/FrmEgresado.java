package Presentación;

import ViewEgresado.Cursos;
import ViewEgresado.Inicio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import javax.swing.JPanel;

public class FrmEgresado extends javax.swing.JFrame {

    private static final Color COLOR_NORMAL = Color.WHITE;
    private static final Color COLOR_HOVER = new Color(213, 229, 240);
    private static final Color COLOR_ACTIVE = new Color(236, 244, 249);

    private JPanel activePanel = null;

    public FrmEgresado() {
        initComponents();
        pnlContent.setLayout(new BorderLayout());
        setupMenuPanel(pnlInicio);
        setupMenuPanel(pnlCursos);
        initContent();

        activePanel = pnlInicio;
        activePanel.setBackground(COLOR_ACTIVE);
    }

    private void setupMenuPanel(JPanel panel) {
        panel.setBackground(COLOR_NORMAL);

        panel.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (activePanel != null) {
                    activePanel.setBackground(COLOR_NORMAL);
                }
                panel.setBackground(COLOR_ACTIVE);
                activePanel = panel;

                if (panel == pnlInicio) {
                    cargarPanel(new Inicio());
                } else if (panel == pnlCursos) {
                    cargarPanel(new Cursos());
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (panel != activePanel) {
                    panel.setBackground(COLOR_HOVER);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (panel != activePanel) {
                    panel.setBackground(COLOR_NORMAL);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        txtInicio = new javax.swing.JLabel();
        pnlCursos = new javax.swing.JPanel();
        txtCursos = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlBackground.setBackground(new java.awt.Color(236, 244, 249));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(13, 27, 42));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnlBackground.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 70));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInicio.setForeground(new java.awt.Color(0, 0, 0));
        txtInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtInicio.setText("Inicio");
        txtInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtInicio.setFocusable(false);

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(pnlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        pnlCursos.setBackground(new java.awt.Color(255, 255, 255));
        pnlCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtCursos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCursos.setForeground(new java.awt.Color(0, 0, 0));
        txtCursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCursos.setText("Cursos");

        javax.swing.GroupLayout pnlCursosLayout = new javax.swing.GroupLayout(pnlCursos);
        pnlCursos.setLayout(pnlCursosLayout);
        pnlCursosLayout.setHorizontalGroup(
            pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCursosLayout.createSequentialGroup()
                .addComponent(txtCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCursosLayout.setVerticalGroup(
            pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCursosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(pnlCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 70));

        pnlBackground.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 730));

        pnlContent.setBackground(new java.awt.Color(236, 244, 249));

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 1310, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEgresado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEgresado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEgresado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEgresado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEgresado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlCursos;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JLabel txtCursos;
    private javax.swing.JLabel txtInicio;
    // End of variables declaration//GEN-END:variables

    private void initContent() {
        cargarPanel(new Inicio());

    }

    private void cargarPanel(JPanel panel) {
        panel.setSize(pnlContent.getSize());
        panel.setLocation(0, 0);
        pnlContent.removeAll();
        pnlContent.add(panel, BorderLayout.CENTER);
        pnlContent.revalidate();
        pnlContent.repaint();
    }

}
