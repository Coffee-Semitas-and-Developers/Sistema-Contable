package Interfaces;

import Conexion.Conexion;
import Modelos.*;
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
    private int cantidadCaracteres = 0;
    private Cuenta cuentaActual = null;
    private boolean guardar = true;

    public MantenimientoCuenta() {
        initComponents();
        inicializarColumnas();
        conexion.getConexion();
        listarCuentaMayores();
        consultaInicial();
        txtSaldoDeudor.setText("0.00");
        txtSaldoAcreedor.setText("0.00");
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
                cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));
                cuenta.setSaldoDeudor(resultado.getDouble("saldodeudor"));
                cuenta.setSaldoAcreedor(resultado.getDouble("saldoacreedor"));
                cuenta.setDescripcion(resultado.getString("descripcion"));
                cuenta.setNombreMayor(getNombreCuentaPadre(resultado.getInt("cue_codigocuenta")));
                cuenta.setCodigoMayor(resultado.getInt("cue_codigocuenta"));
                //System.out.println(resultado.getInt("cue_codigocuenta"));
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(0));
                this.cuentaTabla.cuentas.add(cuenta);
            }
            tableCuenta.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos");
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
                cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));
                cuenta.setSaldoDeudor(resultado.getDouble("saldodeudor"));
                cuenta.setSaldoAcreedor(resultado.getDouble("saldoacreedor"));
                cuenta.setDescripcion(resultado.getString("descripcion"));
                cuenta.setNombreMayor(getNombreCuentaPadre(resultado.getInt("cue_codigocuenta")));
                cuenta.setCodigoMayor(resultado.getInt("cue_codigocuenta"));
                cuenta.setEstadoFinanciero(resultado.getString("estadofinanciero").charAt(0));
                this.cuentaTabla.cuentas.add(cuenta);
            }
            tableCuenta.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar las peliculas de la base de datos.");
            ex.printStackTrace();
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
        txtSaldoDeudor = new javax.swing.JTextField();
        txtSaldoAcreedor = new javax.swing.JTextField();
        rbSaldoDeudor = new javax.swing.JRadioButton();
        rbSaldoAcreedor = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevaCuenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

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

        txtSaldoDeudor.setEnabled(false);
        txtSaldoDeudor.setName("txtSaldoDeudor"); // NOI18N
        txtSaldoDeudor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoDeudorKeyTyped(evt);
            }
        });

        txtSaldoAcreedor.setEnabled(false);
        txtSaldoAcreedor.setName("txtSaldoAcreedor"); // NOI18N
        txtSaldoAcreedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoAcreedorKeyTyped(evt);
            }
        });

        btnGRadio.add(rbSaldoDeudor);
        rbSaldoDeudor.setText("Saldo Deudor");
        rbSaldoDeudor.setName("rbSaldoDeudor"); // NOI18N
        rbSaldoDeudor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSaldoDeudorActionPerformed(evt);
            }
        });

        btnGRadio.add(rbSaldoAcreedor);
        rbSaldoAcreedor.setText("Saldo Acreedor");
        rbSaldoAcreedor.setName("rbSaldoAcreedor"); // NOI18N
        rbSaldoAcreedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSaldoAcreedorActionPerformed(evt);
            }
        });

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO PEQUEÑO.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTableCuenta)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGrupoCuenta)
                                .addGap(18, 18, 18)
                                .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblEstadoFin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblCuentaMayor)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCuentaMayor, 0, 151, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rbSaldoAcreedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbSaldoDeudor)
                                        .addGap(16, 16, 16)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSaldoDeudor)
                                    .addComponent(txtSaldoAcreedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaCuenta))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addComponent(panelTableCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblCuentaMayor)
                    .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrupoCuenta)
                            .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoFin)
                            .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaldoDeudor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbSaldoDeudor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSaldoAcreedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbSaldoAcreedor))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnNuevaCuenta)
                            .addComponent(btnEliminar))))
                .addGap(31, 31, 31))
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

    private void txtSaldoDeudorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoDeudorKeyTyped
        // TODO add your handling code here:
        if (txtSaldoDeudor.getText().contains(".")) {
            if (txtSaldoDeudor.getText().length() >= cantidadCaracteres + 3) {
                getToolkit().beep();
                evt.consume();
            }
        }

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            getToolkit().beep();
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtSaldoDeudor.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        } else {
            if (evt.getKeyChar() == '.') {
                cantidadCaracteres = txtSaldoDeudor.getText().length();
            }
        }

    }//GEN-LAST:event_txtSaldoDeudorKeyTyped

    private void rbSaldoDeudorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSaldoDeudorActionPerformed
        // TODO add your handling code here:
        txtSaldoAcreedor.setEnabled(false);
        txtSaldoAcreedor.setText("0.00");
        txtSaldoDeudor.setEnabled(true);
    }//GEN-LAST:event_rbSaldoDeudorActionPerformed

    private void rbSaldoAcreedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSaldoAcreedorActionPerformed
        // TODO add your handling code here:
        txtSaldoDeudor.setEnabled(false);
        txtSaldoDeudor.setText("0.00");
        txtSaldoAcreedor.setEnabled(true);
    }//GEN-LAST:event_rbSaldoAcreedorActionPerformed

    private void btnNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuentaActionPerformed
        // TODO add your handling code here:
        txtCodigo.setText("");
        txtCodigo.setEnabled(true);
        txtNombre.setText("");
        txtADescripcion.setText("");
        btnGRadio.clearSelection();
        txtSaldoDeudor.setText("0.00");
        txtSaldoAcreedor.setText("0.00");
        txtSaldoDeudor.setEnabled(false);
        txtSaldoAcreedor.setEnabled(false);
        rbSaldoDeudor.setEnabled(true);
        rbSaldoAcreedor.setEnabled(true);
        cmbCuentaMayor.setSelectedIndex(0);
        cmbGrupoCuenta.setSelectedIndex(0);
        cmbEstadoFin.setSelectedIndex(0);
        guardar = true;
    }//GEN-LAST:event_btnNuevaCuentaActionPerformed

    private void txtSaldoAcreedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAcreedorKeyTyped
        // TODO add your handling code here:
        if (txtSaldoAcreedor.getText().contains(".")) {
            if (txtSaldoAcreedor.getText().length() >= cantidadCaracteres + 3) {
                getToolkit().beep();
                evt.consume();
            }
        }

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            getToolkit().beep();
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtSaldoAcreedor.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        } else {
            if (evt.getKeyChar() == '.') {
                cantidadCaracteres = txtSaldoAcreedor.getText().length();
            }
        }
    }//GEN-LAST:event_txtSaldoAcreedorKeyTyped

    private void tableCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCuentaMouseClicked
        // TODO add your handling code here:
        int clics = evt.getClickCount();
        int row = tableCuenta.rowAtPoint(evt.getPoint());

        if (clics == 2) {
            Cuenta c = cuentaTabla.cuentas.get(row);
            cuentaActual = c;

            rbSaldoDeudor.setEnabled(false);
            rbSaldoAcreedor.setEnabled(false);
            txtCodigo.setText(String.valueOf(c.getCodigo()));
            txtNombre.setText(c.getNombreCuenta());
            txtADescripcion.setText(c.getDescripcion());
            txtSaldoDeudor.setText(String.valueOf(c.getSaldoDeudor()));
            txtSaldoAcreedor.setText(String.valueOf(c.getSaldoAcreedor()));
            txtCodigo.setEnabled(false);
            cmbEstadoFin.setSelectedItem(tipoBalance(c.getEstadoFinanciero()));
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

                    double deudor = Double.parseDouble(txtSaldoDeudor.getText());
                    double acreedor = Double.parseDouble(txtSaldoAcreedor.getText());
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
                        if (!(saldoFinal(deudor, acreedor))) {
                            JOptionPane.showMessageDialog(this, "¡No es posible eliminar una cuenta con saldos mayores a cero!", "Información", JOptionPane.WARNING_MESSAGE);
                        } else {
                            String sqlE = "delete FROM cuenta where codigocuenta=?";
                            PreparedStatement statementE = this.conexion.prepareStatement(sqlE);
                            statementE.setInt(1, Integer.parseInt(txtCodigo.getText()));
                            statementE.execute();
                            btnNuevaCuentaActionPerformed(evt);
                            UpdateJTable();
                        }
                    }
                }
            }
        } catch (Exception ex) {
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
                    c.setEstadoFinanciero(tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()));
                    c.setSaldoDeudor(Double.parseDouble(txtSaldoDeudor.getText()));
                    c.setSaldoAcreedor(Double.parseDouble(txtSaldoAcreedor.getText()));

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
                            statement.setObject(5, c.getEstadoFinanciero(), 1);
                            break;
                        default:
                            sentenciaSql = "INSERT INTO cuenta(codigocuenta,cue_codigocuenta,nombrecuenta,descripcion,grupocuenta,estadofinanciero) VALUES" + "(?,?,?,?,?,?)";

                            statement = this.conexion.prepareStatement(sentenciaSql);
                            statement.setInt(1, c.getCodigo());
                            statement.setInt(2, c.getCodigoMayor());
                            statement.setString(3, c.getNombreCuenta());
                            statement.setString(4, c.getDescripcion());
                            statement.setString(5, c.getGrupoCuenta());
                            statement.setObject(6, c.getEstadoFinanciero(), 1);
                            break;
                    }

                    statement.execute();
                    JOptionPane.showMessageDialog(this, "La nuevo cuenta ha sido guardada existosamente");
                    btnNuevaCuentaActionPerformed(evt);
                    UpdateJTable();
                }

            } else {
                String sentenciaSql = null;
                PreparedStatement preparedStatement = null;
                switch (m.getCodigo()) {
                    case 0:
                        sentenciaSql = "UPDATE cuenta SET nombrecuenta= ? , descripcion = ? , grupocuenta = ?, estadofinanciero= ? WHERE codigocuenta = ?";
                        preparedStatement = this.conexion.prepareStatement(sentenciaSql);
                        preparedStatement.setString(1, txtNombre.getText());
                        preparedStatement.setString(2, txtADescripcion.getText());
                        preparedStatement.setString(3, cmbGrupoCuenta.getSelectedItem().toString());
                        preparedStatement.setObject(4, tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()), 1);
                        preparedStatement.setInt(5, Integer.parseInt(txtCodigo.getText()));
                        break;
                    default:
                        sentenciaSql = "UPDATE cuenta SET cue_codigocuenta=?, nombrecuenta= ? , descripcion = ? , grupocuenta = ?, estadofinanciero= ? WHERE codigocuenta = ?";
                        preparedStatement = this.conexion.prepareStatement(sentenciaSql);
                        preparedStatement.setInt(1, m.getCodigo());
                        preparedStatement.setString(2, txtNombre.getText());
                        preparedStatement.setString(3, (txtADescripcion.getText()));
                        preparedStatement.setString(4, cmbGrupoCuenta.getSelectedItem().toString());
                        preparedStatement.setObject(5, tipoBalanceLetra(cmbEstadoFin.getSelectedItem().toString()), 1);
                        preparedStatement.setInt(6, Integer.parseInt(txtCodigo.getText()));
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

    private void cerrar() {
        try {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar el programa?", "Cerrar aplicación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                conexion.close();
                System.exit(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión con la base de datos "+ex);
        }
    }

    //Transforma el char correspondiente al Estado Financiero en String
    public static String tipoBalance(char estado) {
        String estadoFinanciero = null;

        switch (estado) {
            case 'G':
                estadoFinanciero = "Balance General";
                break;
            case 'R':
                estadoFinanciero = " Estado de Resultado";
                break;
            case 'C':
                estadoFinanciero = "Estado de Capital";
                break;
        }

        return estadoFinanciero;
    }

    //Transforma el String correspondiente al Estado Financiero en char para guardar en la Base
    private char tipoBalanceLetra(String estado) {
        char estadoFin = ' ';
        switch (estado) {
            case "Balance General":
                estadoFin = 'G';
                break;
            case "Estado de Resultado":
                estadoFin = 'R';
                break;
            case "Estado de Capital":
                estadoFin = 'C';
                break;
        }
        return estadoFin;
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
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos");
        }
        return nombre;
    }

    private boolean saldoFinal(double deudor, double acreedor) {
        boolean r = false;
        if ((deudor - acreedor) == 0) {
            r = true;
        }
        return r;
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

    private Cuenta getCuentaPadre(int codigoMayor) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGRadio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaCuenta;
    private javax.swing.JComboBox<Cuenta> cmbCuentaMayor;
    private javax.swing.JComboBox<String> cmbEstadoFin;
    private javax.swing.JComboBox<String> cmbGrupoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCuentaMayor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstadoFin;
    private javax.swing.JLabel lblGrupoCuenta;
    private javax.swing.JLabel lblListadoCuenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JScrollPane panelTableCuenta;
    private javax.swing.JRadioButton rbSaldoAcreedor;
    private javax.swing.JRadioButton rbSaldoDeudor;
    private javax.swing.JTable tableCuenta;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldoAcreedor;
    private javax.swing.JTextField txtSaldoDeudor;
    // End of variables declaration//GEN-END:variables

}
