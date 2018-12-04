/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Conexion.Conexion;
import Modelos.*;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dalton
 */
public class MantenimientoKardex extends javax.swing.JFrame {

    KardexTableModel kardexTableModel = new KardexTableModel();
    private final Conexion conexion = new Conexion();
    private Kardex karActual = null;
    private boolean guardar = true;
    private int cantidadCaracteres = 0;
    private final Calendar fecha = new GregorianCalendar();
    private String dat = null;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#.00");
    private Date d = new Date();
    java.sql.Date sqlDate;

    /**
     * Creates new form MantenimientoKardex
     */
    public MantenimientoKardex() {
        initComponents();
        consultaInicial();
        inicializarColumnas();
        setFecha();
        conexion.getConexion();
        background();
    }

    private void background() {
        Fondo f = new Fondo();
        f.setSize(this.getSize());
        this.add(f);
    }

    private void consultaInicial() {
        try {
            String sql = "select  k.fechaapertura, k.idkardex, mp.codigomateria, mp.nombremateria, mp.directa,"
                    + "mp.descripcionmateria, mp.unidadesmateria, k.cantidadtotal, k.costounitariototal, k.montototal "
                    + "from kardex k inner join materiaprima mp on k.codigomateria=mp.codigomateria";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Kardex kardex = new Kardex();
                kardex.setFechaApertura(resultado.getDate(1));
                kardex.setIdKardex(resultado.getInt(2));
                kardex.setMp(new MateriaPrima(resultado.getInt(3), resultado.getString(4), resultado.getBoolean(5), resultado.getString(6), resultado.getString(7)));
                kardex.setCantidadesTotales(resultado.getDouble(8));
                kardex.setCostoUnitarioTotales(resultado.getDouble(9));;
                kardex.setMontoTotales(resultado.getDouble(10));
                this.kardexTableModel.kars.add(kardex);
            }
            tableKardex.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos" + ex);
        }
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        for (int i = 0; i < 6; i++) {
            TableColumn col = new TableColumn(i);

            switch (i) {
                case 0:
                    col.setHeaderValue("Fecha de apertura");
                    break;
                case 1:
                    col.setHeaderValue("ID Kardex");
                    break;
                case 2:
                    col.setHeaderValue("Código Materia");
                    break;
                case 3:
                    col.setHeaderValue("Nombre Materia");
                    break;
                case 4:
                    col.setHeaderValue("Cantidad");
                    break;
                case 5:
                    col.setHeaderValue("Costo Unitario");
                    break;
                case 6:
                    col.setHeaderValue("Monto Total");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tableKardex.setColumnModel(tColumnModel);
    }

    private void cerrar() {
        try {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar el programa?", "Cerrar aplicación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                conexion.close();
                System.exit(0);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión con la base de datos " + ex);
        }
    }

    private void UpdateJTable() {
        kardexTableModel.kars.clear();

        try {
            String sql = "select  k.fechaapertura, k.idkardex, mp.codigomateria, mp.nombremateria, mp.directa,"
                    + "mp.descripcionmateria, mp.unidadesmateria, k.cantidadtotal, k.costounitariototal, k.montototal "
                    + "from kardex k inner join materiaprima mp on k.codigomateria=mp.codigomateria";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Kardex kardex = new Kardex();
                kardex.setFechaApertura(resultado.getDate(1));
                kardex.setIdKardex(resultado.getInt(2));
                kardex.setMp(new MateriaPrima(resultado.getInt(3), resultado.getString(4), resultado.getBoolean(5), resultado.getString(6), resultado.getString(7)));
                kardex.setCantidadesTotales(resultado.getDouble(8));
                kardex.setCostoUnitarioTotales(resultado.getDouble(9));;
                kardex.setMontoTotales(resultado.getDouble(10));
                this.kardexTableModel.kars.add(kardex);
                kardexTableModel.fireTableDataChanged();
            }
            tableKardex.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos" + ex);
        }
    }

    public void setFecha() {
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
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos" + ex);
        }
    }

    public int lastMateriaPrima() {
        int codigo = 0;
        try {
            String ultimo = "SELECT codigomateria FROM materiaprima ORDER BY codigomateria DESC LIMIT 1";
            Statement st = conexion.createStatement();
            ResultSet r = st.executeQuery(ultimo);
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la cuenta\n" + ex);
        }

        return codigo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKardex = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKardex = new javax.swing.JTable();
        lblNombreMateria = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        btnNuevaMateria = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbDirecta = new javax.swing.JCheckBox();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblMontoTotal = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        cmbUnidad = new javax.swing.JComboBox<>();
        lblUnidadMateria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblKardex.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblKardex.setText("Kardex");

        tableKardex.setModel(kardexTableModel);
        tableKardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKardexMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKardex);

        lblNombreMateria.setText("Materia");
        lblNombreMateria.setName("lblNombreMateria"); // NOI18N

        txtMateria.setToolTipText("Sólo se permiten números");
        txtMateria.setName("txtMateria"); // NOI18N

        txtADescripcion.setColumns(20);
        txtADescripcion.setLineWrap(true);
        txtADescripcion.setRows(5);
        txtADescripcion.setWrapStyleWord(true);
        txtADescripcion.setName("txtADescripcion"); // NOI18N
        jScrollPane2.setViewportView(txtADescripcion);

        lblDescripcion.setText("Descripción");
        lblDescripcion.setName("lblDescripcion"); // NOI18N

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO PEQUEÑO.jpg"))); // NOI18N
        lblLogo.setName("lblLogo"); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnDetalle.setText("Detalle");
        btnDetalle.setName("btnDetalle"); // NOI18N
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        btnNuevaMateria.setText("Nueva Cuenta");
        btnNuevaMateria.setName("btnNuevaMateria"); // NOI18N
        btnNuevaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMateriaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cbDirecta.setText("Directa");

        lblCantidad.setText("Cantidad");
        lblCantidad.setName("lblNombreMateria"); // NOI18N

        txtCantidad.setToolTipText("Sólo se permiten números");
        txtCantidad.setName("txtCodigo"); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        lblMontoTotal.setText("Monto Total");
        lblMontoTotal.setName(""); // NOI18N

        txtMontoTotal.setName("txtNombre"); // NOI18N
        txtMontoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoTotalKeyTyped(evt);
            }
        });

        cmbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metro", "Libra", "Yarda", "Kilogramo", "Metro Cuadrado" }));
        cmbUnidad.setName("cmbUnidad"); // NOI18N

        lblUnidadMateria.setText("Unidad de Medida");
        lblUnidadMateria.setName("lblUnidadMateria"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbDirecta)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMontoTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombreMateria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCantidad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblUnidadMateria)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblKardex)
                                .addGap(226, 226, 226)))
                        .addComponent(lblLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaMateria)
                                .addGap(33, 33, 33)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKardex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUnidadMateria)
                                .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombreMateria)
                                .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCantidad)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoTotal)
                            .addComponent(cbDirecta))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnDetalle)
                    .addComponent(btnNuevaMateria)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            if (guardar) {
                Kardex k = new Kardex();
                MateriaPrima mp = new MateriaPrima();
                mp.setNombreMateria(txtMateria.getText());
                mp.setDescripcionMateria(txtADescripcion.getText());
                mp.setDirecta(cbDirecta.isSelected());
                mp.setUnidadesMateria(cmbUnidad.getSelectedItem().toString());
                k.setMp(mp);
                k.setFechaApertura(sqlDate);
                k.setCantidadesTotales(Double.parseDouble(txtCantidad.getText()));
                k.setMontoTotales(Double.parseDouble(txtMontoTotal.getText()));
                double cu = k.getMontoTotales() / k.getCantidadesTotales();
                k.setCostoUnitarioTotales(Double.valueOf(df.format(cu)));

                String sentenciaSql;
                PreparedStatement statement;

                sentenciaSql = "INSERT INTO materiaprima (nombremateria, directa, descripcionmateria, unidadesmateria)"
                        + "VALUES (?, ?, ?, ?)";

                statement = this.conexion.prepareStatement(sentenciaSql);
                statement.setString(1, mp.getNombreMateria());
                statement.setBoolean(2, mp.isDirecta());
                statement.setString(3, mp.getDescripcionMateria());
                statement.setString(4, mp.getUnidadesMateria());
                statement.execute();

                btnNuevaMateriaActionPerformed(evt);
                UpdateJTable();

            } else {
                /*Cuenta c = new Cuenta();
                c.setCodigo(Integer.parseInt(txtMateria.getText()));
                c.setNombreCuenta(txtNombre.getText());
                c.setDescripcion(txtADescripcion.getText());
                c.setCodigoMayor(m.getCodigo());
                c.setNombreMayor(m.getNombreCuenta());
                c.setGrupoCuenta(cmbUnidad.getSelectedItem().toString());
                c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()), 0);
                c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin2.getSelectedItem().toString()), 1);

                StringBuilder str = new StringBuilder(2);
                str.append(c.getEstadoFinanciero(0));
                str.append(c.getEstadoFinanciero(1));

                String sentenciaSql;
                PreparedStatement preparedStatement;

                sentenciaSql = "UPDATE cuenta SET cue_codigocuenta=?, nombrecuenta= ? , descripcion = ? , grupocuenta = ?, estadofinanciero= ? WHERE codigocuenta = ?";
                preparedStatement = this.conexion.prepareStatement(sentenciaSql);
                preparedStatement.setInt(1, m.getCodigo());
                preparedStatement.setString(2, c.getNombreCuenta());
                preparedStatement.setString(3, c.getDescripcion());
                preparedStatement.setString(4, c.getGrupoCuenta());
                preparedStatement.setCharacterStream(5, new StringReader(str.toString()), 2);
                preparedStatement.setInt(6, c.getCodigo());
                preparedStatement.execute();
                btnNuevaMateriaActionPerformed(evt);
                UpdateJTable();*/
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la cuenta\n" + ex);
        }
        UpdateJTable();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        // TODO add your handling code here:
        /*try {
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error en la eliminación. " + ex.getMessage());
        }*/
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnNuevaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMateriaActionPerformed
        // TODO add your handling code here:
        txtMateria.setText("");
        txtCantidad.setText("");
        txtMontoTotal.setText("");
        txtADescripcion.setText("");
        cmbUnidad.setSelectedIndex(0);
        cbDirecta.setSelected(false);
        guardar = true;
    }//GEN-LAST:event_btnNuevaMateriaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        MenuAdmin obj = new MenuAdmin();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        if (txtCantidad.getText().contains(".")) {
            if (txtCantidad.getText().length() >= cantidadCaracteres + 3) {
                getToolkit().beep();
                evt.consume();
            }
        }

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            getToolkit().beep();
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtCantidad.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        } else {
            if (evt.getKeyChar() == '.') {
                cantidadCaracteres = txtCantidad.getText().length();
            }
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtMontoTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoTotalKeyTyped
        // TODO add your handling code here:
        if (txtMontoTotal.getText().contains(".")) {
            if (txtMontoTotal.getText().length() >= cantidadCaracteres + 3) {
                getToolkit().beep();
                evt.consume();
            }
        }

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            getToolkit().beep();
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtMontoTotal.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        } else {
            if (evt.getKeyChar() == '.') {
                cantidadCaracteres = txtMontoTotal.getText().length();
            }
        }
    }//GEN-LAST:event_txtMontoTotalKeyTyped

    private void tableKardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKardexMouseClicked
        // TODO add your handling code here:
        int clics = evt.getClickCount();
        int row = tableKardex.rowAtPoint(evt.getPoint());

        if (clics == 2) {
            Kardex k = kardexTableModel.kars.get(row);
            karActual = k;

            txtMateria.setText(String.valueOf(k.getMp().getNombreMateria()));
            txtCantidad.setText(String.valueOf(k.getCantidadesTotales()));
            txtADescripcion.setText(k.getMp().getDescripcionMateria());
            txtMontoTotal.setText(String.valueOf(k.getMontoTotales()));
            cbDirecta.setSelected(k.getMp().isDirecta());
            cmbUnidad.setSelectedItem(k.getMp().getUnidadesMateria());
            guardar = false;
        }
    }//GEN-LAST:event_tableKardexMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();

    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MantenimientoKardex.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoKardex.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoKardex.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoKardex.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoKardex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaMateria;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbDirecta;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblKardex;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombreMateria;
    private javax.swing.JLabel lblUnidadMateria;
    private javax.swing.JTable tableKardex;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtMontoTotal;
    // End of variables declaration//GEN-END:variables
}
