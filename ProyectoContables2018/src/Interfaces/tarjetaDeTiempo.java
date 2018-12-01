/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.DetalleTarjetaDeTiempo;
import Modelos.TarjetaDeTiempo;
//import Modelos.Empleado;
import Modelos.TarjetaTableModel;
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
public class tarjetaDeTiempo extends javax.swing.JFrame {

    public TarjetaTableModel TarjetaTM = new TarjetaTableModel();
    private Connection conexion;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = new GregorianCalendar();
    Date d = new Date();
    java.sql.Date sqlDate;
    String dat;
    int id;
    TarjetaDeTiempo tar = new TarjetaDeTiempo();

    /**
     * Creates new form tarjetaDeTiempo
     */
    public tarjetaDeTiempo() {
        initComponents();
        inicializarColumnas();
        conectar();
        consultaInicial();
        background();
        setFecha();
        lbDate.setText(dat);
        comboDia.removeAllItems();
        comboEmpleado.removeAllItems();
        comboDia.addItem("Lunes");
        comboDia.addItem("Martes");
        comboDia.addItem("Miércoles");
        comboDia.addItem("Jueves");
        comboDia.addItem("Viernes");
        comboDia.addItem("Sábado");
        comboDia.addItem("Domingo");
        comboDia.addActionListener(comboDia);
        comboEmpleado.addActionListener(comboEmpleado);
        getEmpleados();
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 2; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Días");
                    break;
                case 1:
                    col.setHeaderValue("Horas trabajadas");
                    break;
                case 2:
                    col.setHeaderValue("Horas extra trabajadas");
                    break;
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
                de.setHorasTrabajadas(resultado.getInt("horastrabajadas"));
                de.setHorasExtras(resultado.getInt("horasextras"));
                id = resultado.getInt("idtarjeta");
                this.TarjetaTM.add(de);
            }
            tarjetaTabla.repaint();
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
            sqlDate = new java.sql.Date(d.getTime());

        } catch (Exception ex) {
            System.out.println(ex);
        }
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

    private String getDui() {
        String dui = "";
        try {
            String sentenciaSql = "SELECT * FROM empleado";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (!dui.equals(resultado.getString("dui"))) {
                dui = resultado.getString("dui");
                resultado.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(tarjetaDeTiempo.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tarjetaTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalHorasTrabajadasTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        costoHoraTextField = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        costoHoraExtraTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboEmpleado = new javax.swing.JComboBox<>();
        ordenTextField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Tarjeta de tiempo");

        tarjetaTabla.setModel(TarjetaTM);
        jScrollPane1.setViewportView(tarjetaTabla);

        jLabel2.setText("Total horas trabajadas:");

        totalHorasTrabajadasTextField.setEditable(false);

        jLabel3.setText("Costo/hora:");

        costoHoraTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoHoraTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Día:");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDiaItemStateChanged(evt);
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

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel9.setText("Muebles Rivera S.A. de C.V.");

        jLabel10.setText("Orden de trabajo:");

        jLabel12.setText("Costo/hora extra:");

        costoHoraExtraTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoHoraExtraTextFieldKeyTyped(evt);
            }
        });

        jLabel15.setText("Seleccione el nombre del empleado: ");

        comboEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ordenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ordenTextFieldKeyTyped(evt);
            }
        });

        guardarButton.setText("Guardar tarjeta");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalHorasTrabajadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costoHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costoHoraExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guardarButton)
                        .addGap(220, 220, 220))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(agregarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDate)
                        .addGap(58, 58, 58)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDate)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(ordenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalHorasTrabajadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(costoHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(costoHoraExtraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarButton)
                    .addComponent(jButton1))
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
                    det.setDiaDeTrabajo(1);
                    break;
                case "Martes":
                    det.setDiaDeTrabajo(2);
                    break;
                case "Miércoles":
                    det.setDiaDeTrabajo(3);
                    break;
                case "Jueves":
                    det.setDiaDeTrabajo(4);
                    break;
                case "Viernes":
                    det.setDiaDeTrabajo(5);
                    break;
                case "Sábado":
                    det.setDiaDeTrabajo(6);
                    break;
                case "Domingo":
                    det.setDiaDeTrabajo(7);
                    break;
            }
            det.setIdTarjeta(id++);
            det.setHorasTrabajadas(Integer.parseInt(horasTrabajadasTextField.getText()));
            det.setHorasExtras(Integer.parseInt(horasExtraTextField.getText()));

            String sentenciaSql = "INSERT INTO detalletarjetadetiempo(diadetrabajo,idtarjeta,fechatarjeta,horastrabajadas,horasextras) VALUES "
                    + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql);
            preparedStatement.setInt(1, det.getDiaDeTrabajo());
            preparedStatement.setInt(2, id++);
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setInt(4, det.getHorasTrabajadas());
            preparedStatement.setInt(5, det.getHorasExtras());
            preparedStatement.execute();
            tar.setDetalle((List<DetalleTarjetaDeTiempo>) det);
            this.TarjetaTM.add(det);
            tarjetaTabla.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
        JOptionPane.showMessageDialog(null, "Detalle registrado con éxito", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        ordenTextField.setText(null);
        horasTrabajadasTextField.setText(null);
        horasExtraTextField.setText(null);
        totalHorasTrabajadasTextField.setText(Integer.toString(tar.calcularHoras()));
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

    private void ordenTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ordenTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_ordenTextFieldKeyTyped

    private void horasExtraTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasExtraTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_horasExtraTextFieldKeyTyped

    private void costoHoraTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoHoraTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_costoHoraTextFieldKeyTyped

    private void costoHoraExtraTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoHoraExtraTextFieldKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_costoHoraExtraTextFieldKeyTyped

    private void comboDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDiaItemStateChanged
        // TODO add your handling code here:
        if (evt.getSource() == comboDia) {
            String seleccionado = (String) comboDia.getSelectedItem();
        }
    }//GEN-LAST:event_comboDiaItemStateChanged

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        try {
            tar.setIdOrden(Integer.parseInt(ordenTextField.getText()));
            tar.setDui(getDui());
            tar.setSalHora(Double.parseDouble(costoHoraTextField.getText()));
            tar.setSalHoraExtra(Double.parseDouble(costoHoraTextField.getText()));
            String sentenciaSql = "INSERT INTO tarjetadetiempo(idtarjeta,fechatarjeta,idorden,dui,salariohoranormal,salariohoraextra,totalhorastrabajadas,totalhorasextras) VALUES "
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql);
            preparedStatement.setInt(1, id++);
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setInt(3, tar.getIdOrden());
            preparedStatement.setString(4, tar.getDui());
            preparedStatement.setDouble(5, tar.SalHoras());
            preparedStatement.setDouble(6, tar.SalHorasExtras());
            preparedStatement.setInt(7, tar.calcularHoras());
            preparedStatement.setInt(8, tar.calcularHorasExtras());
            preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        } 
        JOptionPane.showMessageDialog(null, "Tarjeta registrada con éxito", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        totalHorasTrabajadasTextField.setText(null);
        costoHoraTextField.setText(null);
        costoHoraExtraTextField.setText(null);
    }//GEN-LAST:event_guardarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(tarjetaDeTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tarjetaDeTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tarjetaDeTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tarjetaDeTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tarjetaDeTiempo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboEmpleado;
    private javax.swing.JTextField costoHoraExtraTextField;
    private javax.swing.JTextField costoHoraTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JTextField horasExtraTextField;
    private javax.swing.JTextField horasTrabajadasTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTextField ordenTextField;
    private javax.swing.JTable tarjetaTabla;
    private javax.swing.JTextField totalHorasTrabajadasTextField;
    // End of variables declaration//GEN-END:variables
}
