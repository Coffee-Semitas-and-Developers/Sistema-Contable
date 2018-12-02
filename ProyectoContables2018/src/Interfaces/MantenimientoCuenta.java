package Interfaces;

import Conexion.Conexion;
import Modelos.*;
import java.awt.HeadlessException;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MantenimientoCuenta extends javax.swing.JFrame {

    private final Conexion conexion = new Conexion();
    public CuentaTableModel cuentaTabla = new CuentaTableModel();
    private Cuenta cuentaActual = null;
    private boolean guardar = true;

    public MantenimientoCuenta() {
        initComponents();
        inicializarColumnas();
        conexion.getConexion();
        listarCuentaMayores();
        consultaInicial();
        background();
    }

    private void background() {
        Fondo f = new Fondo();
        f.setSize(this.getSize());
        this.add(f);
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        for (int i = 0; i < 7; i++) {
            TableColumn col = new TableColumn(i);

            switch (i) {
                case 0:
                    col.setHeaderValue("Código Cuenta");
                    break;
                case 1:
                    col.setHeaderValue("Nombre de Cuenta");
                    break;
                case 2:
                    col.setHeaderValue("Descripción");
                    break;
                case 3:
                    col.setHeaderValue("Cuenta Mayor");
                    break;
                case 4:
                    col.setHeaderValue("Grupo de la Cuenta");
                    break;
                case 5:
                    col.setHeaderValue("Estado Financiero");
                    break;
                case 6:
                    col.setHeaderValue("Saldo Final");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tableCuenta.setColumnModel(tColumnModel);
    }

    private void consultaInicial() {
        try {
            String sql = "SELECT * FROM cuenta order by codigocuenta asc";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setCodigo(resultado.getInt("codigocuenta"));
                cuenta.setNombreCuenta(resultado.getString("nombrecuenta"));
                cuenta.setGrupoCuenta(resultado.getString("grupocuenta"));
                cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));;
                cuenta.setDescripcion(resultado.getString("descripcion"));
                cuenta.setNombreMayor(getNombreCuentaPadre(resultado.getInt("cue_codigocuenta")));
                cuenta.setCodigoMayor(resultado.getInt("cue_codigocuenta"));
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(0), 0);
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(1), 1);
                this.cuentaTabla.cuentas.add(cuenta);
            }
            tableCuenta.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos" + ex);
        }
    }

    private void listarCuentaMayores() {
        try {
            String sql = "SELECT codigocuenta,nombrecuenta FROM cuenta order by codigocuenta asc";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            cmbCuentaMayor.addItem(new Cuenta(0, "N/A"));
            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setCodigo(resultado.getInt("codigocuenta"));
                cuenta.setNombreCuenta(resultado.getString("nombrecuenta"));
                cmbCuentaMayor.addItem(cuenta);
            }
            //tableCuenta.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos " + ex);
        }
    }

    private void UpdateJTable() {
        cuentaTabla.cuentas.clear();

        try {
            String sql = "SELECT * FROM cuenta order by codigocuenta asc";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setCodigo(resultado.getInt("codigocuenta"));
                cuenta.setNombreCuenta(resultado.getString("nombrecuenta"));
                cuenta.setGrupoCuenta(resultado.getString("grupocuenta"));
                if (cbSaldoFinal.isSelected()) {
                    cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));
                }
                cuenta.setDescripcion(resultado.getString("descripcion"));
                cuenta.setNombreMayor(getNombreCuentaPadre(resultado.getInt("cue_codigocuenta")));
                cuenta.setCodigoMayor(resultado.getInt("cue_codigocuenta"));
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(0), 0);
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(1), 1);
                this.cuentaTabla.cuentas.add(cuenta);
            }
            tableCuenta.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar las peliculas de la base de datos." + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGRadio = new javax.swing.ButtonGroup();
        lblListadoCuenta = new javax.swing.JLabel();
        panelTableCuenta = new javax.swing.JScrollPane();
        tableCuenta = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEstadoFin = new javax.swing.JLabel();
        lblGrupoCuenta = new javax.swing.JLabel();
        lblCuentaMayor = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cmbCuentaMayor = new javax.swing.JComboBox<>();
        cmbGrupoCuenta = new javax.swing.JComboBox<>();
        cmbEstadoFin = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevaCuenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        lblLogo = new javax.swing.JLabel();
        lblEstadoFin2 = new javax.swing.JLabel();
        cmbEstadoFin2 = new javax.swing.JComboBox<>();
        cbSaldoFinal = new javax.swing.JCheckBox();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MantenimientoCuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("fCuenta"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblListadoCuenta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblListadoCuenta.setText("Catálogo de Cuentas");
        lblListadoCuenta.setName("lblListadoCuentas"); // NOI18N

        tableCuenta.setModel(cuentaTabla);
        tableCuenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCuenta.setName("tableCuenta"); // NOI18N
        tableCuenta.setRowHeight(48);
        tableCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCuentaMouseClicked(evt);
            }
        });
        panelTableCuenta.setViewportView(tableCuenta);

        lblCodigo.setText("Código de Cuenta");
        lblCodigo.setName("lblCodigo"); // NOI18N

        lblNombre.setText("Nombre de la Cuenta");
        lblNombre.setName("lblNombre"); // NOI18N

        lblDescripcion.setText("Descripción");
        lblDescripcion.setName("lblDescripcion"); // NOI18N

        lblEstadoFin.setText("Estado Financiero");
        lblEstadoFin.setName("lblEstadoFin"); // NOI18N

        lblGrupoCuenta.setText("Grupo de la Cuenta");
        lblGrupoCuenta.setName("lblGrupoCuenta"); // NOI18N

        lblCuentaMayor.setText("Cuenta Mayor");
        lblCuentaMayor.setName("lblCuentaPadre"); // NOI18N

        txtCodigo.setToolTipText("Sólo se permiten números");
        txtCodigo.setName("txtCodigo"); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtNombre.setName("txtNombre"); // NOI18N

        cmbCuentaMayor.setModel(cmbCuentaMayor.getModel());
        cmbCuentaMayor.setName("cmbCuentaMayor"); // NOI18N

        cmbGrupoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Corriente", "No Corriente", "Diferido", "Distribuido", "Ganado", "Inversión", "Desinversión" }));
        cmbGrupoCuenta.setName("cmbGrupoCuenta"); // NOI18N

        cmbEstadoFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado de Resultado", "Estado de Capital", "Balance General" }));
        cmbEstadoFin.setName("cmbEstadoFinanciero"); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevaCuenta.setText("Nueva Cuenta");
        btnNuevaCuenta.setName("btnNuevaCuenta"); // NOI18N
        btnNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCuentaActionPerformed(evt);
            }
        });

        txtADescripcion.setColumns(20);
        txtADescripcion.setLineWrap(true);
        txtADescripcion.setRows(5);
        txtADescripcion.setWrapStyleWord(true);
        txtADescripcion.setName("txtADescripcion"); // NOI18N
        jScrollPane1.setViewportView(txtADescripcion);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO PEQUEÑO.jpg"))); // NOI18N
        lblLogo.setName("lblLogo"); // NOI18N

        lblEstadoFin2.setText("Estado Financiero 2");
        lblEstadoFin2.setName("lblEstadoFin"); // NOI18N

        cmbEstadoFin2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Estado de Resultado", "Estado de Capital", "Balance General" }));
        cmbEstadoFin2.setName("cmbEstadoFinanciero"); // NOI18N

        cbSaldoFinal.setText("Saldo Final");
        cbSaldoFinal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbSaldoFinalStateChanged(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTableCuenta)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstadoFin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstadoFin2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoFin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLogo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevaCuenta)
                        .addGap(33, 33, 33)
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblGrupoCuenta)
                                .addGap(18, 18, 18)
                                .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCuentaMayor)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCuentaMayor, 0, 151, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSaldoFinal)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblListadoCuenta)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListadoCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblCuentaMayor)
                    .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrupoCuenta)
                            .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSaldoFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstadoFin)
                                    .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstadoFin2)
                                    .addComponent(cmbEstadoFin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar)
                            .addComponent(btnNuevaCuenta)
                            .addComponent(btnSalir)))
                    .addComponent(lblLogo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void btnNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuentaActionPerformed
        // TODO add your handling code here:
        txtCodigo.setText("");
        txtCodigo.setEnabled(true);
        txtNombre.setText("");
        txtADescripcion.setText("");
        btnGRadio.clearSelection();
        cmbCuentaMayor.setSelectedIndex(0);
        cmbGrupoCuenta.setSelectedIndex(0);
        cmbEstadoFin.setSelectedIndex(0);
        cmbEstadoFin2.setSelectedIndex(0);
        guardar = true;
    }//GEN-LAST:event_btnNuevaCuentaActionPerformed

    private void tableCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCuentaMouseClicked
        // TODO add your handling code here:
        int clics = evt.getClickCount();
        int row = tableCuenta.rowAtPoint(evt.getPoint());

        if (clics == 2) {
            Cuenta c = cuentaTabla.cuentas.get(row);
            cuentaActual = c;

            txtCodigo.setText(String.valueOf(c.getCodigo()));
            txtNombre.setText(c.getNombreCuenta());
            txtADescripcion.setText(c.getDescripcion());
            txtCodigo.setEnabled(false);
            cmbEstadoFin.setSelectedItem(Cuenta.tipoBalance(c.getEstadoFinanciero(0)));
            cmbEstadoFin2.setSelectedItem(Cuenta.tipoBalance(c.getEstadoFinanciero(1)));
            cmbGrupoCuenta.setSelectedItem(c.getGrupoCuenta());
            cmbCuentaMayor.setSelectedIndex(indexPadre(c.getCodigoMayor()));
            guardar = false;
        }
    }//GEN-LAST:event_tableCuentaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "¡Debe seleccionar la cuenta que desea eliminar. Luego Dar clic en el botón \'Eliminar\'!", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {

                    /*double deudor = Double.parseDouble(txtSaldoDeudor.getText());
                    double acreedor = Double.parseDouble(txtSaldoAcreedor.getText());*/
                    boolean padre = false;

                    Iterator<Cuenta> i = cuentaTabla.cuentas.iterator();
                    while (i.hasNext()) {
                        Cuenta c = i.next();
                        if (Integer.compare(cuentaActual.getCodigo(), c.getCodigoMayor()) == 0) {
                            padre = true;
                            break;
                        }
                    }

                    if (padre) {
                        JOptionPane.showMessageDialog(this, "¡No es posible eliminar una cuenta de Mayor. Debe Eliminar las subcuentas, previamente!", "Información", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (cuentaActual.getSaldoFinal()==0) {
                            JOptionPane.showMessageDialog(this, "¡No es posible eliminar una cuenta con saldos mayores a cero!", "Información", JOptionPane.WARNING_MESSAGE);
                        } else {
                            String sqlE = "Delete FROM cuenta where codigocuenta=?";
                            PreparedStatement statementE = this.conexion.prepareStatement(sqlE);
                            statementE.setInt(1, Integer.parseInt(txtCodigo.getText()));
                            statementE.execute();
                            btnNuevaCuentaActionPerformed(evt);
                            UpdateJTable();
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error en la eliminación. " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            Cuenta m = (Cuenta) cmbCuentaMayor.getSelectedItem(); //Cuenta mayor de la nueva cuenta
            if (guardar) {
                if (codigoExistente(Integer.parseInt(txtCodigo.getText()))) {
                    JOptionPane.showMessageDialog(this, "¡El código de la nueva cuenta que desea guardar ya existe!", "Error en el guardado", JOptionPane.WARNING_MESSAGE);
                } else {
                    Cuenta c = new Cuenta();
                    c.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    c.setNombreCuenta(txtNombre.getText());
                    c.setDescripcion(txtADescripcion.getText());
                    c.setCodigoMayor(m.getCodigo());
                    c.setNombreMayor(m.getNombreCuenta());
                    c.setGrupoCuenta(cmbGrupoCuenta.getSelectedItem().toString());
                    c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()), 0);
                    c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin2.getSelectedItem().toString()), 1);

                    //Conversion de chars (Estado Financiero) a string 
                    StringBuilder str = new StringBuilder(2);
                    str.append(c.getEstadoFinanciero(0));
                    str.append(c.getEstadoFinanciero(1));

                    String sentenciaSql;
                    PreparedStatement statement;
                    switch (c.getCodigoMayor()) {
                        case 0:
                            sentenciaSql = "INSERT INTO cuenta(codigocuenta,nombrecuenta,descripcion,grupocuenta,estadofinanciero) VALUES" + "(?,?,?,?,?)";

                            statement = this.conexion.prepareStatement(sentenciaSql);
                            statement.setInt(1, c.getCodigo());
                            statement.setString(2, c.getNombreCuenta());
                            statement.setString(3, c.getDescripcion());
                            statement.setString(4, c.getGrupoCuenta());
                            statement.setCharacterStream(5, new StringReader(str.toString()), 2);
                            break;
                        default:
                            sentenciaSql = "INSERT INTO cuenta(codigocuenta,cue_codigocuenta,nombrecuenta,descripcion,grupocuenta,estadofinanciero) VALUES" + "(?,?,?,?,?,?)";

                            statement = this.conexion.prepareStatement(sentenciaSql);
                            statement.setInt(1, c.getCodigo());
                            statement.setInt(2, c.getCodigoMayor());
                            statement.setString(3, c.getNombreCuenta());
                            statement.setString(4, c.getDescripcion());
                            statement.setString(5, c.getGrupoCuenta());
                            statement.setCharacterStream(6, new StringReader(str.toString()), 2);
                            break;
                    }

                    statement.execute();
                    JOptionPane.showMessageDialog(this, "La nuevo cuenta ha sido guardada existosamente");
                    btnNuevaCuentaActionPerformed(evt);
                    UpdateJTable();
                }

            } else {
                Cuenta c = new Cuenta();
                c.setCodigo(Integer.parseInt(txtCodigo.getText()));
                c.setNombreCuenta(txtNombre.getText());
                c.setDescripcion(txtADescripcion.getText());
                c.setCodigoMayor(m.getCodigo());
                c.setNombreMayor(m.getNombreCuenta());
                c.setGrupoCuenta(cmbGrupoCuenta.getSelectedItem().toString());
                c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()), 0);
                c.setEstadoFinanciero(Cuenta.tipoBalanceLetra(cmbEstadoFin2.getSelectedItem().toString()), 1);

                //Conversion de chars (Estado Financiero) a string 
                StringBuilder str = new StringBuilder(2);
                str.append(c.getEstadoFinanciero(0));
                str.append(c.getEstadoFinanciero(1));

                String sentenciaSql;
                PreparedStatement preparedStatement;
                switch (m.getCodigo()) {
                    case 0:
                        sentenciaSql = "UPDATE cuenta SET nombrecuenta= ? , descripcion = ? , grupocuenta = ?, estadofinanciero= ? WHERE codigocuenta = ?";
                        preparedStatement = this.conexion.prepareStatement(sentenciaSql);
                        preparedStatement.setString(1, c.getNombreCuenta());
                        preparedStatement.setString(2, c.getDescripcion());
                        preparedStatement.setString(3, c.getGrupoCuenta());
                        preparedStatement.setCharacterStream(4, new StringReader(str.toString()), 2);
                        preparedStatement.setInt(5, c.getCodigo());
                        break;
                    default:
                        sentenciaSql = "UPDATE cuenta SET cue_codigocuenta=?, nombrecuenta= ? , descripcion = ? , grupocuenta = ?, estadofinanciero= ? WHERE codigocuenta = ?";
                        preparedStatement = this.conexion.prepareStatement(sentenciaSql);
                        preparedStatement.setInt(1, m.getCodigo());
                        preparedStatement.setString(2, c.getNombreCuenta());
                        preparedStatement.setString(3, c.getDescripcion());
                        preparedStatement.setString(4, c.getGrupoCuenta());
                        preparedStatement.setCharacterStream(5, new StringReader(str.toString()), 2);
                        preparedStatement.setInt(6, c.getCodigo());
                        break;
                }
                preparedStatement.execute();
                btnNuevaCuentaActionPerformed(evt);
                UpdateJTable();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la cuenta\n" + ex);
        }
        UpdateJTable();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbSaldoFinalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbSaldoFinalStateChanged
        // TODO add your handling code here:
        UpdateJTable();
    }//GEN-LAST:event_cbSaldoFinalStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        MenuAdmin obj = new MenuAdmin();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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

    private String getNombreCuentaPadre(int codigo) {
        String nombre = null;
        try {
            if (codigo == 0) {
                nombre = "N/A";
            } else {
                String sql = "SELECT nombrecuenta FROM cuenta where codigocuenta=?";
                PreparedStatement statement = this.conexion.prepareStatement(sql);
                statement.setInt(1, codigo);
                ResultSet resultado = statement.executeQuery();
                while (resultado.next()) {
                    nombre = resultado.getString(1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos" + ex);
        }
        return nombre;
    }

    private boolean codigoExistente(int codigo) {
        boolean existe = false;

        Iterator<Cuenta> i = cuentaTabla.cuentas.iterator();
        while (i.hasNext()) {
            Cuenta c = i.next();
            if (Integer.compare(codigo, c.getCodigo()) == 0) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    private int indexPadre(int codigo) {
        int index = 0;
        switch (codigo) {
            case 0:
                break;
            default:
                Iterator<Cuenta> i = cuentaTabla.cuentas.iterator();
                while (i.hasNext()) {
                    Cuenta c = i.next();
                    if (Integer.compare(codigo, c.getCodigo()) == 0) {
                        index++;
                        break;
                    }
                    index++;
                }
                break;
        }
        return index;
    }

    private Cuenta getCuentaPadreDB(int codigoMayor) {
        Cuenta padre = new Cuenta();
        try {
            if (codigoMayor == 0) {
                padre.setCodigo(0);
                padre.setNombreCuenta("N/A");
            } else {
                String sql = "SELECT codigocuenta,nombrecuenta FROM cuenta where codigocuenta=?";
                PreparedStatement statement = this.conexion.prepareStatement(sql);

                statement.setInt(1, codigoMayor);

                ResultSet resultado = statement.executeQuery();

                while (resultado.next()) {
                    padre.setCodigo(resultado.getInt("codigocuenta"));
                    padre.setNombreCuenta(resultado.getString("nombrecuenta"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos " + ex);
        }
        System.out.println(padre.toString());
        return padre;
    }

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
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MantenimientoCuenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGRadio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaCuenta;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JCheckBox cbSaldoFinal;
    private javax.swing.JComboBox<Cuenta> cmbCuentaMayor;
    private javax.swing.JComboBox<String> cmbEstadoFin;
    private javax.swing.JComboBox<String> cmbEstadoFin2;
    private javax.swing.JComboBox<String> cmbGrupoCuenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCuentaMayor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstadoFin;
    private javax.swing.JLabel lblEstadoFin2;
    private javax.swing.JLabel lblGrupoCuenta;
    private javax.swing.JLabel lblListadoCuenta;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JScrollPane panelTableCuenta;
    private javax.swing.JTable tableCuenta;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
