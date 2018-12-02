/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.DetalleTarjetaDeTiempo;
import Modelos.TarjetaDeTiempo;
//import Modelos.Empleado;
import Modelos.DetalleTarjetaTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AxlHrndz
 */
public class DetalleTarjetaDeTiempoForm extends javax.swing.JFrame {

    public DetalleTarjetaTableModel DetTarjetaTM = new DetalleTarjetaTableModel();
    private Connection conexion;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = new GregorianCalendar();
    Date d = new Date();
    java.sql.Date sqlDate;
    String dat;
    int diaSeleccionado;
    public TarjetaDeTiempo tar = new TarjetaDeTiempo();

    /**
     * Creates new form tarjetaDeTiempo
     */
    public DetalleTarjetaDeTiempoForm() {
        initComponents();
        inicializarColumnas();
        conectar();
        consultaInicial();
        background();
        setFecha();
        lbDate.setText(dat);
        comboDia.removeAllItems();
        comboDia.addActionListener(comboDia);
        comboDia.addItem("Lunes");
        comboDia.addItem("Martes");
        comboDia.addItem("Miércoles");
        comboDia.addItem("Jueves");
        comboDia.addItem("Viernes");
        comboDia.addItem("Sábado");
        comboDia.addItem("Domingo");

    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 3; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Días");
                    break;
                case 1:
                    col.setHeaderValue("Nombres");
                    break;
                case 2:
                    col.setHeaderValue("Apellidos");
                    break;
                case 3:
                    col.setHeaderValue("Horas trabajadas");
                    break;
                case 4:
                    col.setHeaderValue("Horas extra trabajadas");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        detalleTarjetaTabla.setColumnModel(tColumnModel);
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
            String sentenciaSql = "SELECT * FROM detalletarjetadetiempo";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                int dia = resultado.getInt("diadetrabajo");
                DetalleTarjetaDeTiempo de = new DetalleTarjetaDeTiempo();
                switch (dia) {
                    case 1:
                        de.setDiaSeleccionado("Lunes");
                        break;
                    case 2:
                        de.setDiaSeleccionado("Martes");
                        break;
                    case 3:
                        de.setDiaSeleccionado("Miércoles");
                        break;
                    case 4:
                        de.setDiaSeleccionado("Jueves");
                        break;
                    case 5:
                        de.setDiaSeleccionado("Viernes");
                        break;
                    case 6:
                        de.setDiaSeleccionado("Sábado");
                        break;
                    case 7:
                        de.setDiaSeleccionado("Domingo");
                        break;
                }
                de.getEmpleado().setNombres(resultado.getString("nombre"));
                de.getEmpleado().setApellidos(resultado.getString("apellido"));
                de.setHorasTrabajadas(resultado.getInt("horastrabajadas"));
                de.setHorasExtras(resultado.getInt("horasextras"));
                this.DetTarjetaTM.add(de);
            }
            detalleTarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos de la base de datos.");
        }
    }

    private void background() {
        Fondo f = new Fondo();
        f.setSize(1333, 650);
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
        detalleTarjetaTabla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        horasTrabajadasTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        horasExtraTextField = new javax.swing.JTextField();
        agregarButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Detalle tarjeta de tiempo");

        detalleTarjetaTabla.setModel(DetTarjetaTM);
        jScrollPane1.setViewportView(detalleTarjetaTabla);

        jLabel4.setText("Día:");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDiaItemStateChanged(evt);
            }
        });
        comboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Horas trabajadas:");

        horasTrabajadasTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horasTrabajadasTextFieldKeyTyped(evt);
            }
        });

        jLabel6.setText("Horas extra:");

        horasExtraTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horasExtraTextFieldKeyTyped(evt);
            }
        });

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha:");

        lbDate.setText("---------");

        jButton1.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horasTrabajadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horasExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(agregarButton)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDate)
                .addContainerGap(756, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(220, 741, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDate)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(horasTrabajadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(horasExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        try {
            DetalleTarjetaDeTiempo det = new DetalleTarjetaDeTiempo();
            String dia = (String) comboDia.getSelectedItem();
            switch (dia) {
                case "Lunes":
                    diaSeleccionado = 1;
                    break;
                case "Martes":
                    diaSeleccionado = 2;
                    break;
                case "Miércoles":
                    diaSeleccionado = 3;
                    break;
                case "Jueves":
                    diaSeleccionado = 4;
                    break;
                case "Viernes":
                    diaSeleccionado = 5;
                    break;
                case "Sábado":
                    diaSeleccionado = 6;
                    break;
                case "Domingo":
                    diaSeleccionado = 7;
                    break;
            }
            det.setDiaDeTrabajo(diaSeleccionado);
            det.setHorasTrabajadas(Integer.parseInt(horasTrabajadasTextField.getText()));
            det.setHorasExtras(Integer.parseInt(horasExtraTextField.getText()));
            tar.detalle.add(det);
            String sentenciaSql;
            sentenciaSql = "INSERT INTO detalletarjetadetiempo(diadetrabajo,fechatarjeta,horastrabajadas,horasextras) VALUES"
                    + "(?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql);
            preparedStatement.setInt(1, det.getDiaDeTrabajo());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setInt(3, det.getHorasTrabajadas());
            preparedStatement.setInt(4, det.getHorasExtras());
            preparedStatement.execute();
            this.DetTarjetaTM.add(det);
            detalleTarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }

        JOptionPane.showMessageDialog(null, "Detalle registrado con éxito", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        horasTrabajadasTextField.setText(null);
        horasExtraTextField.setText(null);
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión a la base de datos");
        }
        JOptionPane.showMessageDialog(this, "La conexión a la base de datos ha sido cerrada");
    }//GEN-LAST:event_formWindowClosing

    private void horasTrabajadasTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasTrabajadasTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_horasTrabajadasTextFieldKeyTyped

    private void horasExtraTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasExtraTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_horasExtraTextFieldKeyTyped

    private void comboDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDiaItemStateChanged
        // TODO add your handling code here:
        if (evt.getSource() == comboDia) {
            String seleccionado = (String) comboDia.getSelectedItem();
        }
    }//GEN-LAST:event_comboDiaItemStateChanged

    private void comboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboDiaActionPerformed

    //String seleccionado=(String)combo1Dia.getSelectedItem();
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
            java.util.logging.Logger.getLogger(DetalleTarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleTarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleTarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleTarjetaDeTiempoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleTarjetaDeTiempoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JTable detalleTarjetaTabla;
    private javax.swing.JTextField horasExtraTextField;
    private javax.swing.JTextField horasTrabajadasTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDate;
    // End of variables declaration//GEN-END:variables
}
