/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Mejia
 */
public class MenuConta extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuConta(){
        initComponents();
    }
    
    
    public MenuConta(int a) {
        initComponents();
        background();
        getIconImage();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("Menu Principal");
        if(a==1){
            btnAdminUs.setEnabled(false);
        }  
        
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LOGO PEQUEÑO.jpg"));
        return retValue;
    }
        public void background() {
            Fondo ima = new Fondo();
            ima.setSize(this.getSize());
            this.add(ima);
        }
     
    public void cerrar() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog // Sigue en la siguiente linea
                (rootPane, "¿En realidad desea cerrar la aplicacion?", "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMovimientos = new javax.swing.JButton();
        btnPlanillas = new javax.swing.JButton();
        btnCostos = new javax.swing.JButton();
        btnBalances = new javax.swing.JButton();
        btnAdminUs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO PEQUEÑO.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel2.setText("Menu Principal");

        btnMovimientos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cal2.png"))); // NOI18N
        btnMovimientos.setText("Movimientos Contables");
        btnMovimientos.setToolTipText("");
        btnMovimientos.setBorderPainted(false);
        btnMovimientos.setContentAreaFilled(false);
        btnMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMovimientos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cal1.png"))); // NOI18N
        btnMovimientos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnPlanillas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPlanillas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/repo2.png"))); // NOI18N
        btnPlanillas.setText("Planillas");
        btnPlanillas.setBorderPainted(false);
        btnPlanillas.setContentAreaFilled(false);
        btnPlanillas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlanillas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/repo1.png"))); // NOI18N
        btnPlanillas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCostos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo2.png"))); // NOI18N
        btnCostos.setText("Costos");
        btnCostos.setBorderPainted(false);
        btnCostos.setContentAreaFilled(false);
        btnCostos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCostos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo1.png"))); // NOI18N
        btnCostos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnBalances.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBalances.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finanza2.png"))); // NOI18N
        btnBalances.setText("Reportes y Balances");
        btnBalances.setBorderPainted(false);
        btnBalances.setContentAreaFilled(false);
        btnBalances.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBalances.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finanza.png"))); // NOI18N
        btnBalances.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnAdminUs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdminUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ojo2.png"))); // NOI18N
        btnAdminUs.setText("Administrar Usuarios");
        btnAdminUs.setBorderPainted(false);
        btnAdminUs.setContentAreaFilled(false);
        btnAdminUs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminUs.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ojo1.png"))); // NOI18N
        btnAdminUs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBalances, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMovimientos))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdminUs, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPlanillas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnCostos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(btnCostos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnPlanillas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBalances, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminUs, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnAdminUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUsActionPerformed
        AdministrarUsuariosForm obj = new AdministrarUsuariosForm();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminUsActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConta().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminUs;
    private javax.swing.JButton btnBalances;
    private javax.swing.JButton btnCostos;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnPlanillas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
