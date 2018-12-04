/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Cuenta;
import Modelos.DetalleTransaccion;
import Modelos.DetalleTransaccionTableModel;
import Modelos.ServCuentaTableModel;
import Modelos.Transaccion;
import java.awt.List;
import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Elmer
 */
public class InsertarTransaccion extends javax.swing.JFrame {

    private Connection conexion;
    public ServCuentaTableModel detalleTmodel = new ServCuentaTableModel();
    public DetalleTransaccionTableModel detalleTransaccionTModel = new DetalleTransaccionTableModel();
    Transaccion t = new Transaccion();
    double tDebe, tHaber = 0.00;

    /**
     * Creates new form InsertarMovimiento
     */
    public InsertarTransaccion() {

        initComponents();
        conectar();
        llenarCombobox();
        inicializarColumnas();
        lbPartidaDoble.setVisible(false);
        btnGuardar.setEnabled(false);
    }

    //Metodo para insertar planillas// tiPlanilla es 0 es planilla de salrio, si es 1 planilla de vacaiones, si es 2 es planilla de aguinaldos
    public InsertarTransaccion(int tiPlanilla, double totalIsss, double totalAFP, double totalRenta, double totalDesc, double totalBoni, double totalSalarioNeto, double totalIsssPatrono, double totalAFPPatrono, double totalAportePatrono) {

        initComponents();
        conectar();
        llenarCombobox();
        inicializarColumnas();
        lbPartidaDoble.setVisible(false);
        btnGuardar.setEnabled(true);
        switch (tiPlanilla) {
            case 0:
                insertarPlanilla(totalIsss, totalAFP, totalRenta, totalDesc, totalBoni, totalSalarioNeto, totalIsssPatrono, totalAFPPatrono, totalAportePatrono);
                break;
            case 1:
                insertarPlanillaVac(totalIsss, totalAFP, totalRenta, totalDesc, totalBoni, totalSalarioNeto, totalIsssPatrono, totalAFPPatrono, totalAportePatrono);
                break;
            case 2:
                insertarPlanillaAgui(totalIsss, totalAFP, totalRenta, totalDesc, totalBoni, totalSalarioNeto, totalIsssPatrono, totalAFPPatrono, totalAportePatrono);
        }
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic",
                    "semitas", "semita");
        } catch (Exception ex) {
            Logger.getLogger(GestionarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCombobox() {
        //Vector<Cuenta> lista = new Vector<Cuenta>();
        try {
            String sentenciaSql = "SELECT * FROM cuenta";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
              cuenta.setCodigo(resultado.getInt("codigocuenta"));
                cuenta.setNombreCuenta(resultado.getString("nombrecuenta"));
              cuenta.setDescripcion(resultado.getString("descripcion"));
              cuenta.setGrupoCuenta(resultado.getString("grupocuenta"));
                cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));
                cmbCuenta.addItem(cuenta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 3; i++) {
            TableColumn col = new TableColumn(i);

            switch (i) {
                case 0:
                    col.setHeaderValue("Cuenta");
                    break;
                case 1:
                    col.setHeaderValue("Debe");
                    break;
                case 2:
                    col.setHeaderValue("Haber");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        jTable1.setColumnModel(tColumnModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnGDebeHaber = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCuenta = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbDebe = new javax.swing.JRadioButton();
        rbHaber = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jdfecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        txtDebe = new javax.swing.JTextField();
        txtHaber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbPartidaDoble = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cuenta");

        cmbCuenta.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCuentaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentaActionPerformed(evt);
            }
        });

        jLabel6.setText("Monto (DOLARES)");

        jLabel4.setText("Tipo");

        btnGDebeHaber.add(rbDebe);
        rbDebe.setText("Debe");
        rbDebe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDebeActionPerformed(evt);
            }
        });

        btnGDebeHaber.add(rbHaber);
        rbHaber.setText("Haber");
        rbHaber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHaberActionPerformed(evt);
            }
        });

        btnAceptar.setText("Agregar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(cmbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbDebe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbHaber))
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(89, 89, 89)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbDebe)
                    .addComponent(rbHaber))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel5.setText("Fecha");

        jLabel7.setText("Descripcion");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jLabel10.setText("INSERTAR TRANSACCION");

        jLabel11.setText("SELECCIONE CUENTAS A UTILIZAR");

        jTable1.setModel(detalleTmodel);
        jScrollPane1.setViewportView(jTable1);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtDebe.setEditable(false);

        txtHaber.setEditable(false);

        jLabel12.setText("Total (Dolares)");

        jLabel2.setText("Detalles de transaccion");

        lbPartidaDoble.setForeground(new java.awt.Color(255, 0, 0));
        lbPartidaDoble.setText("No cumple partida doble");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(266, 266, 266))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(56, 56, 56)
                                .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbPartidaDoble)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPartidaDoble)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:   
        try {

            DetalleTransaccion d = new DetalleTransaccion();
            d.cuenta = (Cuenta) cmbCuenta.getSelectedItem();
            if (rbDebe.isSelected() || rbHaber.isSelected()) {
                if (rbDebe.isSelected()) {
                    d.debe = Double.parseDouble(txtMonto.getText());
                    tDebe += Double.parseDouble(txtMonto.getText());
                } else {
                    d.haber = Double.parseDouble(txtMonto.getText());
                    tHaber += Double.parseDouble(txtMonto.getText());
                }
                detalleTmodel.detalles.add(d);
                detalleTmodel.fireTableDataChanged();
                txtMonto.setText("");
                cmbCuenta.setSelectedIndex(0);
                btnGDebeHaber.clearSelection();
                txtDebe.setText(String.valueOf(tDebe));
                txtHaber.setText(String.valueOf(tHaber));
                if (tHaber == tDebe) {
                    lbPartidaDoble.setVisible(false);
                    btnGuardar.setEnabled(true);
                } else {
                    lbPartidaDoble.setVisible(true);
                    btnGuardar.setEnabled(false);
                }
                t.setMonto(tHaber);

            } else {
                JOptionPane.showMessageDialog(this, "Uno de los botones debe seleccionar el tipo de monto", "Seleccione una opcion", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingresar monto de la transaccion");

        }


    }//GEN-LAST:event_btnAceptarActionPerformed

    /*private void UpdateJTable(){
         detalleTmodel.detalles.clear();
        try {
            PreparedStatement statement = null;
            String sentenciaSql = "SELECT idtransaccion,descripciondetalle,fechatransaccion,monto FROM transaccion ";
            statement = this.conexion.prepareStatement(sentenciaSql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                DetalleTransaccion dt = new DetalleTransaccion();
                
                
                transaccion.idTransaccion = resultado.getInt("idtransaccion");
                transaccion.descripcion = resultado.getString("descripciondetalle");
                transaccion.fecha = resultado.getDate("fechatransaccion");
                transaccion.monto = resultado.getDouble("monto");
                detalleTransaccionTModel.transacciones.add(transaccion);
            }
            jTable1.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar las transacciones de la base de datos");
        }*/

    private void cmbCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCuentaActionPerformed

//llenamos los textbox dependiendo del valor seleccioando del combobox
    private void cmbCuentaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCuentaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        //llenamos textbox a partir de un combobox
        /* String Seleccion = (String) cmbCuenta.getSelectedItem();
        try {
            String sentenciaSql = "SELECT nombrecuenta,saldofinal FROM cuenta WHERE nombrecuenta=?";
            PreparedStatement statement = null;
            statement = this.conexion.prepareStatement(sentenciaSql);
            statement.setString(1, Seleccion);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombrecuenta");
                txtNombre.setText(nombre);
                Double saldo = resultado.getDouble("saldofinal");
                txtSaldo.setText(String.valueOf(saldo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar las cuentas de la base de datos");
        }*/
    }//GEN-LAST:event_cmbCuentaPopupMenuWillBecomeInvisible

    public void selectDebehaber() {
        if (rbDebe.isSelected()) {

        }
    }
    private void rbDebeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDebeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbDebeActionPerformed

    private void rbHaberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHaberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbHaberActionPerformed
    /* //metodo para obtener las fechas de los jdchooser
                DateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
                Calendar fechacon =  jdfecha.getCurrent();
                int año = fechacon.get(Calendar.YEAR);
                int mes = fechacon.get(Calendar.MONTH);
                int dia = fechacon.get(Calendar.DAY_OF_MONTH);
                String fecha1= (dia+"/"+mes+"/"+año).toString();
                Date j = new Date();
                j = formato.parse(fecha1);
                tra.fecha = new java.sql.Date(j.getTime());
               //hasta a qui con el metodo para enviar las fechas
     */
    public Date fechaDC() throws ParseException {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fechacon = jdfecha.getCalendar();
        int año = fechacon.get(Calendar.YEAR);
        int mes = fechacon.get(Calendar.MONTH);
        int dia = fechacon.get(Calendar.DAY_OF_MONTH);
        String fecha1 = (dia + "/" + mes + "/" + año).toString();
        Date j = new Date();
        j = formato.parse(fecha1);
        return j;
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        try {
            DetalleTransaccion det = new DetalleTransaccion();
            Transaccion tra = new Transaccion();

            tra.descripcion = txtDescripcion.getText();
            java.sql.Date f = new java.sql.Date(fechaDC().getTime());

            String sentenciaSql1 = "INSERT INTO transaccion (idperiodocontable,"
                    + "descripciondetalle,fechatransaccion,monto) VALUES" + "(?,?,?,?)";
            PreparedStatement preparedStatement1 = conexion.prepareStatement(sentenciaSql1);
            preparedStatement1.setInt(1, 1);
            preparedStatement1.setString(2, tra.descripcion);
            preparedStatement1.setDate(3, f);
            preparedStatement1.setDouble(4, t.monto);
            preparedStatement1.execute();
            this.detalleTransaccionTModel.transacciones.add(tra);

            String sentenciaSql = "SELECT idtransaccion FROM transaccion order by idtransaccion desc limit 1";
            PreparedStatement statement = null;
            statement = this.conexion.prepareStatement(sentenciaSql);
            ResultSet resultado = statement.executeQuery();
            detalleTransaccionTModel.transacciones.add(tra);

            for (int i = 0; i < detalleTmodel.detalles.size(); i++) {
                String sentenciaSql2 = "INSERT INTO detalletransaccion (idtransaccion,codigocuenta,"
                        + "debe,haber) VALUES" + "(?,?,?,?)";

                DetalleTransaccion detalle = (DetalleTransaccion) detalleTmodel.detalles.get(i);
                det.cuenta = detalle.cuenta;
                det.debe = detalle.debe;
                det.haber = detalle.haber;
                if (resultado.next()) {
                    int r = resultado.getInt("idtransaccion");
                    PreparedStatement preparedStatement2 = conexion.prepareStatement(sentenciaSql2);
                    preparedStatement2.setInt(1, r);
                    preparedStatement2.setInt(2, det.cuenta.getCodigo());
                    preparedStatement2.setDouble(3, det.haber);
                    preparedStatement2.setDouble(4, det.debe);
                    preparedStatement2.execute();
                    System.out.println("Pelamela");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ParseException ex) {
            Logger.getLogger(InsertarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void insertarPlanilla(double totalIsss, double totalAFP, double totalRenta, double totalDesc, double totalBoni, double totalSalarioNeto, double totalIsssPatrono, double totalAFPPatrono, double totalAportePatrono) {
        Cuenta c = new Cuenta();
        DetalleTransaccion d = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Gastos por Salario")) {
                c = cmbCuenta.getItemAt(i);
            }
        }
        d.cuenta = c;
        d.debe = totalSalarioNeto - totalBoni;
        detalleTmodel.detalles.add(d);
        detalleTmodel.fireTableDataChanged();

        Cuenta c0 = new Cuenta();
        DetalleTransaccion d0 = new DetalleTransaccion();
        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("ISSS")) {
                c0 = cmbCuenta.getItemAt(i);
            }
        }

        d0.cuenta = c0;
        d0.debe = totalIsss;
        detalleTmodel.detalles.add(d0);
        detalleTmodel.fireTableDataChanged();

        Cuenta c1 = new Cuenta();
        DetalleTransaccion d1 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Pension")) {
                c1 = cmbCuenta.getItemAt(i);
            }
        }
        d1.cuenta = c1;
        d1.debe = totalAFP;
        detalleTmodel.detalles.add(d1);
        detalleTmodel.fireTableDataChanged();

        Cuenta c2 = new Cuenta();
        DetalleTransaccion d2 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Retenciones Laborales")) {
                c2 = cmbCuenta.getItemAt(i);
            }
        }
        d2.cuenta = c2;
        d2.debe = totalDesc;
        detalleTmodel.detalles.add(d2);
        detalleTmodel.fireTableDataChanged();

        Cuenta c3 = new Cuenta();
        DetalleTransaccion d3 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Bonificaciones y aguinaldo")) {
                c3 = cmbCuenta.getItemAt(i);
            }
        }
        d3.cuenta = c3;
        d3.debe = totalBoni;
        detalleTmodel.detalles.add(d3);
        detalleTmodel.fireTableDataChanged();
        Cuenta c4 = new Cuenta();
        DetalleTransaccion d4 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Impuesto sobre renta")) {
                c4 = cmbCuenta.getItemAt(i);
            }
        }
        d4.cuenta = c4;
        d4.debe = totalRenta;
        detalleTmodel.detalles.add(d4);
        detalleTmodel.fireTableDataChanged();

        Cuenta c5 = new Cuenta();
        DetalleTransaccion d5 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("ISSS Salud")) {
                c5 = cmbCuenta.getItemAt(i);
            }
        }
        d5.cuenta = c5;
        d5.debe = totalIsssPatrono;
        detalleTmodel.detalles.add(d5);
        detalleTmodel.fireTableDataChanged();
        Cuenta c6 = new Cuenta();
        DetalleTransaccion d6 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("AFP CONFIA")) {
                c6 = cmbCuenta.getItemAt(i);
            }
        }
        d6.cuenta = c6;
        d6.debe = totalAFPPatrono;
        detalleTmodel.detalles.add(d6);
        detalleTmodel.fireTableDataChanged();

        tDebe = totalIsss + totalAFP + totalRenta + totalDesc + totalAFPPatrono + totalIsssPatrono + totalSalarioNeto;
        txtDebe.setText(String.valueOf(tDebe));
    }

    private void insertarPlanillaVac(double totalIsss, double totalAFP, double totalRenta, double totalDesc, double totalBoni, double totalSalarioNeto, double totalIsssPatrono, double totalAFPPatrono, double totalAportePatrono) {
        Cuenta c = new Cuenta();
        DetalleTransaccion d = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Vacaciones empleado")) {
                c = cmbCuenta.getItemAt(i);
            }
        }
        d.cuenta = c;
        d.debe = totalSalarioNeto;
        detalleTmodel.detalles.add(d);
        detalleTmodel.fireTableDataChanged();

        Cuenta c0 = new Cuenta();
        DetalleTransaccion d0 = new DetalleTransaccion();
        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("ISSS")) {
                c0 = cmbCuenta.getItemAt(i);
            }
        }

        d0.cuenta = c0;
        d0.debe = totalIsss;
        detalleTmodel.detalles.add(d0);
        detalleTmodel.fireTableDataChanged();

        Cuenta c1 = new Cuenta();
        DetalleTransaccion d1 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Pension")) {
                c1 = cmbCuenta.getItemAt(i);
            }
        }
        d1.cuenta = c1;
        d1.debe = totalAFP;
        detalleTmodel.detalles.add(d1);
        detalleTmodel.fireTableDataChanged();

        Cuenta c2 = new Cuenta();
        DetalleTransaccion d2 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Vacaciones patrono")) {
                c2 = cmbCuenta.getItemAt(i);
            }
        }
        d2.cuenta = c2;
        d2.debe = totalAportePatrono;
        detalleTmodel.detalles.add(d2);
        detalleTmodel.fireTableDataChanged();

        Cuenta c4 = new Cuenta();
        DetalleTransaccion d4 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Impuesto sobre renta")) {
                c4 = cmbCuenta.getItemAt(i);
            }
        }
        d4.cuenta = c4;
        d4.debe = totalRenta;
        detalleTmodel.detalles.add(d4);
        detalleTmodel.fireTableDataChanged();

        Cuenta c5 = new Cuenta();
        DetalleTransaccion d5 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("ISSS Salud")) {
                c5 = cmbCuenta.getItemAt(i);
            }
        }
        d5.cuenta = c5;
        d5.debe = totalIsssPatrono;
        detalleTmodel.detalles.add(d5);
        detalleTmodel.fireTableDataChanged();
        Cuenta c6 = new Cuenta();
        DetalleTransaccion d6 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("AFP CONFIA")) {
                c6 = cmbCuenta.getItemAt(i);
            }
        }
        d6.cuenta = c6;
        d6.debe = totalAFPPatrono;
        detalleTmodel.detalles.add(d6);
        detalleTmodel.fireTableDataChanged();

        tDebe = totalIsss + totalAFP + totalRenta + totalAFPPatrono + totalIsssPatrono + totalSalarioNeto + totalAportePatrono;
        txtDebe.setText(String.valueOf(tDebe));
    }

    private void insertarPlanillaAgui(double totalIsss, double totalAFP, double totalRenta, double totalDesc, double totalBoni, double totalSalarioNeto, double totalIsssPatrono, double totalAFPPatrono, double totalAportePatrono) {
        Cuenta c = new Cuenta();
        DetalleTransaccion d = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Aguinaldo")) {
                c = cmbCuenta.getItemAt(i);
            }
        }
        d.cuenta = c;
        d.debe = totalSalarioNeto;
        detalleTmodel.detalles.add(d);
        detalleTmodel.fireTableDataChanged();

        Cuenta c4 = new Cuenta();
        DetalleTransaccion d4 = new DetalleTransaccion();

        for (int i = 0; i < cmbCuenta.getItemCount(); i++) {
            if (cmbCuenta.getItemAt(i).getNombreCuenta().equals("Impuesto sobre renta")) {
                c4 = cmbCuenta.getItemAt(i);
            }
        }
        d4.cuenta = c4;
        d4.debe = totalRenta;
        detalleTmodel.detalles.add(d4);
        detalleTmodel.fireTableDataChanged();

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
            java.util.logging.Logger.getLogger(InsertarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarTransaccion().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup btnGDebeHaber;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Cuenta> cmbCuenta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JLabel lbPartidaDoble;
    private javax.swing.JRadioButton rbDebe;
    private javax.swing.JRadioButton rbHaber;
    private javax.swing.JTextField txtDebe;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtHaber;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
