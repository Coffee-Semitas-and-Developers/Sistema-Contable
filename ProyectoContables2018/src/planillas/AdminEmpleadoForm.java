/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planillas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class AdminEmpleadoForm extends javax.swing.JFrame {

    public EmpleadoTableModel empleadoTM = new EmpleadoTableModel(); 
     private Connection conexion;

    
    
    /**
     * Creates new form AdminEmpleadoForm
     */
    public AdminEmpleadoForm() {
        initComponents();
        inicializarColumnas();
        conectar();
        consultaInicial();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Administración de empleados");

        tablaEmpleados.setModel(empleadoTM);
        tablaEmpleados.setName("tablaEmpleados"); // NOI18N
        jScrollPane1.setViewportView(tablaEmpleados);

        jButton1.setText("Agregar Empleado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jButton2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AgregarEmpForm a= new AgregarEmpForm();      
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inicializarColumnas() {
    TableColumnModel tColumnModel = new DefaultTableColumnModel();
    for (int i = 0; i < 7; i++) {
    TableColumn col = new TableColumn(i);
    switch (i) {
        case 0:
        col.setHeaderValue("DUI");
        break;
        case 1:
        col.setHeaderValue("Nombres");
        break;
        case 2:
        col.setHeaderValue("Apellidos");
        break;
        case 3:
        col.setHeaderValue("Cargo");
        break;
        case 4:
        col.setHeaderValue("NIT");
        break;
        case 5:
        col.setHeaderValue("NUP");
        break;
        case 6:
        col.setHeaderValue("Numero ISSS");
        break;
        case 7:
        col.setHeaderValue("fecha Contrato");
        break;
    }
    tColumnModel.addColumn(col);
    }
    tablaEmpleados.setColumnModel(tColumnModel);
 }
    
    private void conectar() {
 try {
 conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Planilla", "postgres",
"administrador");

 } catch (SQLException ex) {
 Logger.getLogger(AdminEmpleadoForm.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
    
     private void consultaInicial() {
    try {
    String sentenciaSql = "SELECT * FROM Empleado ";
    Statement statement = this.conexion.createStatement();
    ResultSet resultado = statement.executeQuery(sentenciaSql);
    while (resultado.next()) {
    Empleado e = new Empleado();
    e.setDui(resultado.getString("dui"));
    e.setNombres(resultado.getString("nombre"));
    e.setApellidos(resultado.getString("apellido"));
    e.setCargo(resultado.getString("cargo"));
    e.setNit(resultado.getString("nit"));
    e.setNup(resultado.getString("nup"));
    e.setNumIss(resultado.getString("numIsss"));

    this.empleadoTM.empleados.add(e);
    }
    tablaEmpleados.repaint();
    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");
    ex.printStackTrace();
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(AdminEmpleadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEmpleadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEmpleadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEmpleadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEmpleadoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
