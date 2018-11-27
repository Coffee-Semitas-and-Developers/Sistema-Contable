/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.*;
import Modelos.Empleado;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


/**
 *
 * @author jorge
 */
public class PlanillaForm extends javax.swing.JFrame {
    String dat;
    private Connection conexion;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = new GregorianCalendar();
    Date d= new Date();
    java.sql.Date sqlDate;
    LineaPlanillaTableModel lineaTM= new LineaPlanillaTableModel();
    
    public PlanillaForm() {
        initComponents();
        background();
        setFecha();
        llenarCombos();
        conectar();
        inicializarColumnas();
        consultaInicial();
    }

       private void background() {
        Fondo f =new Fondo();
        f.setSize(this.getSize());
        this.add(f);
}  
    public void setFecha(){

        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        //Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        dat = ("" + dia + "/" + mes + "/" + año + "").toString();
        try {
            d = dateFormat.parse(dat);
            sqlDate = new java.sql.Date(d.getTime());

        } catch (Exception ex) {
            System.out.println(ex);
        }
        lbDate.setText(dat);
    }
       
    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic", "semitas",
                    "semita");

        } catch (SQLException ex) {
            Logger.getLogger(AdminEmpleadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 12; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Habilitado");
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
                    col.setHeaderValue("Horas Trabajadas");
                    break;
                case 5:
                    col.setHeaderValue("Horas Extra");
                    break;
                case 6:
                    col.setHeaderValue("ISSS");
                    break;
                case 7:
                    col.setHeaderValue("AFP");
                    break;
                case 8:
                    col.setHeaderValue("Renta");
                    break;
                case 9:
                    col.setHeaderValue("Bonificaciones");
                    break;
                case 10:
                    col.setHeaderValue("Otros descuentos");
                    break;
                case 11:
                    col.setHeaderValue("Salario");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tablaLinea.setColumnModel(tColumnModel);
    }    
        
    private void consultaInicial() {
        try {
            String sentenciaSql = "SELECT * FROM Empleado";
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
                e.setTel(resultado.getString("tel"));

                this.lineaTM.ln.add(new LineaPlanilla(e));
            }
            tablaLinea.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los Empleados de la base de datos");
            ex.printStackTrace();
        }
    }       
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcTipo = new javax.swing.JComboBox<>();
        jcOcasion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLinea = new javax.swing.JTable();
        jbProcesar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        jLabel1.setText("Fecha:");

        lbDate.setText("--/--/--");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Ocasión:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(jcOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO 2.jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel10.setText("PLANILLA");

        tablaLinea.setModel(lineaTM);
        tablaLinea.setName("tablaLinea"); // NOI18N
        jScrollPane1.setViewportView(tablaLinea);

        jbProcesar.setText("Procesar ");
        jbProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel11)
                        .addGap(322, 322, 322)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(jLabel10))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1659, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbProcesar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcesarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbProcesarActionPerformed

    private void llenarCombos(){
        //TIPO DE PLANILLA
        jcTipo.addItem("Empleado");
        jcTipo.addItem("Patronal");
        
        //OCASION DE LA PLANILLA
        jcOcasion.addItem("Salarios");
        jcOcasion.addItem("Vacaciones");
        jcOcasion.addItem("Aguinaldo");
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
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanillaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbProcesar;
    private javax.swing.JComboBox<String> jcOcasion;
    private javax.swing.JComboBox<String> jcTipo;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTable tablaLinea;
    // End of variables declaration//GEN-END:variables
}
