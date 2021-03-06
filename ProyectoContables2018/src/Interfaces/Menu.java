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
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */

    
    public Menu() {
        initComponents();
        background();
        getIconImage();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("Menu Principal");
        
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
        btnCostos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        btnMovimientos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/general1.png"))); // NOI18N
        btnMovimientos.setText("Contabilidad General");
        btnMovimientos.setToolTipText("");
        btnMovimientos.setBorderPainted(false);
        btnMovimientos.setContentAreaFilled(false);
        btnMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMovimientos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/general1.png"))); // NOI18N
        btnMovimientos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/general.png"))); // NOI18N
        btnMovimientos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnCostos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/costos1.png"))); // NOI18N
        btnCostos.setText("Contabilidad de Costos");
        btnCostos.setBorderPainted(false);
        btnCostos.setContentAreaFilled(false);
        btnCostos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCostos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/costos1.png"))); // NOI18N
        btnCostos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/costos.png"))); // NOI18N
        btnCostos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostosActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sal2.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sal3.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(btnCostos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(154, 154, 154)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(299, 299, 299))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCostos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        MenuConta menuAdmin = new MenuConta();
        menuAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Login ima = new Login();
            ima.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostosActionPerformed
        MenuCostos ima = new MenuCostos();
        ima.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCostosActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCostos;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
