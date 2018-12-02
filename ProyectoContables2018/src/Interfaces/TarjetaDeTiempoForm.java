/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.DetalleTarjetaDeTiempo;
import Modelos.TarjetaDeTiempo;
import Modelos.TarjetaTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author AxlHrndz
 */
public class TarjetaDeTiempoForm extends javax.swing.JFrame {

    public TarjetaTableModel TarjetaTM = new TarjetaTableModel();
    private Connection conexion;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = new GregorianCalendar();
    Date d = new Date();
    java.sql.Date sqlDate;
    String dat;

    /**
     * Creates new form TarjetaDeTiempoForm
     */
    public TarjetaDeTiempoForm() {
        initComponents();
        inicializarColumnas();
        conectar();
        comboEmpleado.removeAllItems();
        getEmpleados();
        consultaInicial();
        background();
        setFecha();
        lbDate.setText(dat);
        comboEmpleado.addActionListener(comboEmpleado);
    }

    private void getEmpleados() {
        try {
            String sentenciaSql = "SELECT * FROM empleado";
            String nombreCompleto;
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                nombreCompleto = resultado.getString("nombre") + " " + resultado.getString("apellido");
                comboEmpleado.addItem(nombreCompleto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los empleados de la base de datos");
        }
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 8; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("ID tarjeta");
                    break;
                case 1:
                    col.setHeaderValue("ID orden");
                    break;
                case 2:
                    col.setHeaderValue("Fecha tarjeta");
                    break;
                case 3:
                    col.setHeaderValue("DUI");
                    break;
                case 4:
                    col.setHeaderValue("Costo hora");
                    break;
                case 5:
                    col.setHeaderValue("Costo hora extra");
                    break;
                case 6:
                    col.setHeaderValue("Total horas trabajadas");
                    break;
                case 7:
                    col.setHeaderValue("Total horas extra trabajadas");
            }
            tColumnModel.addColumn(col);
        }
        tarjetaTabla.setColumnModel(tColumnModel);
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic", "semitas",
                    "semita");

        } catch (SQLException ex) {
            Logger.getLogger(AdminEmpleadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void consultaInicial() {
        try {
            String sentenciaSql = "SELECT * FROM tarjetadetiempo";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                int i = 0;
                TarjetaDeTiempo ta = new TarjetaDeTiempo();
                List<DetalleTarjetaDeTiempo> de = new ArrayList<DetalleTarjetaDeTiempo>();
                ta.setId(resultado.getInt("idtarjeta"));
                ta.setIdOrden(resultado.getInt("idorden"));
                ta.setFechaTarjeta(resultado.getDate("fechatarjeta"));
                ta.setSalHora(resultado.getDouble("salariohoranormal"));
                ta.setSalHoraExtra(resultado.getDouble("salariohoraextra"));
                ta.setTotalHorasTrabajadas(resultado.getInt("totalhorastrabajadas"));
                ta.setTotalHorasExtras(resultado.getInt("totalhorasextras"));
                this.TarjetaTM.add(ta);
            }
            tarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos de la base de datos.");
        }
    }

    private void background() {
        Fondo f = new Fondo();
        f.setSize(1360, 750);
        this.add(f);
    }

    public void setFecha() {

        //Instanciamos el objeto Calendar en fecha obtenemos la fecha y hora del sistema
        //Calendar fecha = new GregorianCalendar(); Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        dat = ("" + dia + "/" + mes + "/" + año + "").toString();
        try {
            d = dateFormat.parse(dat);
            sqlDate = new java.sql.Date(d.getTime());;

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private String getDui() {
        String dui = "";
        try {
            String sentenciaSql = "SELECT * FROM empleado";
            String nombreCompleto;
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                nombreCompleto = resultado.getString("nombre") + " " + resultado.getString("apellido");
                if (nombreCompleto.equals(comboEmpleado.getSelectedItem().toString())) {
                    dui = resultado.getString("dui");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTarjetaDeTiempoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboEmpleado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ordenTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        costoHoraTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        costoHoraExtraTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tarjetaTabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        calcularHorasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setText("Tarjeta de tiempo");

        jLabel3.setText("Seleccione empleado:");

        comboEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Ingrese orden de trabajo:");

        jLabel5.setText("Ingrese costo/hora:");

        jLabel6.setText("Ingrese costo hora/extra:");

        costoHoraExtraTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoHoraExtraTextFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar Tarjeta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tarjetaTabla.setModel(TarjetaTM);
        jScrollPane1.setViewportView(tarjetaTabla);

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha:");

        lbDate.setText("---------");

        jButton3.setText("Agregar detalles");

        jLabel1.setText("Ingrese el ID de la tarjeta de la cual quiere calcular el total de horas:");

        calcularHorasButton.setText("Calcular horas");
        calcularHorasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularHorasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(420, 420, 420)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costoHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costoHoraExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(543, 543, 543)
                .addComponent(jLabel2)
                .addContainerGap(568, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(calcularHorasButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lbDate))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ordenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(costoHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(costoHoraExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcularHorasButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void costoHoraExtraTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoHoraExtraTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costoHoraExtraTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión a la base de datos");
        }
        JOptionPane.showMessageDialog(this, "La conexión a la base de datos ha sido cerrada");
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String sentenciaSql = "SELECT * FROM detalletarjetadetiempo";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            TarjetaDeTiempo ta = new TarjetaDeTiempo();

            ta.setIdOrden(Integer.parseInt(ordenTextField.getText()));
            ta.setSalHora(Double.parseDouble(costoHoraTextField.getText()));
            ta.setSalHoraExtra(Double.parseDouble(costoHoraExtraTextField.getText()));
            ta.setDui(getDui());
            String sentenciaSql1 = "INSERT INTO tarjetadetiempo(fechatarjeta,idorden,dui,salariohoranormal,salariohoraextra)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql1);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, ta.getIdOrden());
            preparedStatement.setString(3, ta.getDui());
            preparedStatement.setDouble(4, ta.getSalHora());
            preparedStatement.setDouble(5, ta.getSalHoraExtra());
            this.TarjetaTM.add(ta);
            tarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos de la base de datos.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void calcularHorasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularHorasButtonActionPerformed
        // TODO add your handling code here:
        try {
            String sentenciaSql = "SELECT SUM(horastrabajadas) FROM detalletarjetadetiempo WHERE idtarjeta = "+idTextField.getText();
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            TarjetaDeTiempo ta = new TarjetaDeTiempo();
            /*int i = Integer.parseInt(idTextField.getText());
            while (resultado.next()) {
                if (i == resultado.getInt("idtarjeta")) {
                    DetalleTarjetaDeTiempo de = new DetalleTarjetaDeTiempo();
                    de.setHorasTrabajadas(resultado.getInt("horastrabajadas"));
                    de.setHorasExtras(resultado.getInt("horasextras"));
                    ta.detalle.add(de);
                }
            }*/
            ta.setTotalHorasTrabajadas(resultado.getInt("sum"));
            //ta.setTotalHorasExtras(ta.calcularHorasExtras());
            String sentenciaSql1 = "INSERT INTO tarjetadetiempo(totalhorastrabajadas,totalhorasextra)"
                    + " VALUES(?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql1);
            preparedStatement.setInt(1, ta.getTotalHorasTrabajadas());
            preparedStatement.setInt(2, ta.getTotalHorasExtras());
            this.TarjetaTM.add(ta);
            tarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos de la base de datos.");
        }
    }//GEN-LAST:event_calcularHorasButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarjetaDeTiempoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularHorasButton;
    private javax.swing.JComboBox<String> comboEmpleado;
    private javax.swing.JTextField costoHoraExtraTextField;
    private javax.swing.JTextField costoHoraTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTextField ordenTextField;
    private javax.swing.JTable tarjetaTabla;
    // End of variables declaration//GEN-END:variables

}
