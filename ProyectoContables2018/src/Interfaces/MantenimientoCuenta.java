package Interfaces;

import Conexion.Conexion;
import Modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MantenimientoCuenta extends javax.swing.JFrame {

    private Conexion conexion = new Conexion();
    public CuentaTableModel cuentaTabla = new CuentaTableModel();
    private int cantidadCaracteres = 0;
    private Cuenta cuentaActual=null;
    private boolean guardar;

    public MantenimientoCuenta() {
        initComponents();
        inicializarColumnas();
        conexion.getConexion();
        consultaInicial();
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        for (int i = 0; i < 4; i++) {
            TableColumn col = new TableColumn(i);

            switch (i) {
                case 0:
                    col.setHeaderValue("Codigo Cuenta");
                    break;
                case 1:
                    col.setHeaderValue("Nombre de Cuenta");
                    break;
                case 2:
                    col.setHeaderValue("Grupo de la Cuenta");
                    break;
                case 3:
                    col.setHeaderValue("Saldo Final");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tableCuenta.setColumnModel(tColumnModel);
    }

    private void consultaInicial() {
        try {
            String sql = "SELECT * FROM cuenta";
            Statement statement = this.conexion.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setCodigo(resultado.getInt("codigocuenta"));
                cuenta.setNombreCuenta(resultado.getString("nombrecuenta"));
                cuenta.setGrupoCuenta(resultado.getString("grupocuenta"));
                cuenta.setSaldoFinal(resultado.getDouble("saldofinal"));
                System.out.print(cuenta.toString());
                this.cuentaTabla.cuentas.add(cuenta);
            }
            tableCuenta.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos");
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
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MantenimientoCuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("fCuenta"); // NOI18N

        lblListadoCuenta.setText("Listado de Cuentas");
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

        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); // NOI18N

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setName("btnLimpiar"); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtADescripcion.setColumns(20);
        txtADescripcion.setLineWrap(true);
        txtADescripcion.setRows(5);
        txtADescripcion.setWrapStyleWord(true);
        txtADescripcion.setName("txtADescripcion"); // NOI18N
        jScrollPane1.setViewportView(txtADescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListadoCuenta)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblCuentaMayor)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(lblGrupoCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEstadoFin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTableCuenta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListadoCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuentaMayor)
                    .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrupoCuenta)
                    .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEstadoFin)
                                .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSaldoDeudor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbSaldoDeudor))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSaldoAcreedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbSaldoAcreedor)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar))
                .addContainerGap())
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
        txtSaldoAcreedor.setText("");
        txtSaldoDeudor.setEnabled(true);
    }//GEN-LAST:event_rbSaldoDeudorActionPerformed

    private void rbSaldoAcreedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSaldoAcreedorActionPerformed
        // TODO add your handling code here:
        txtSaldoDeudor.setEnabled(false);
        txtSaldoDeudor.setText("");
        txtSaldoAcreedor.setEnabled(true);
    }//GEN-LAST:event_rbSaldoAcreedorActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtCodigo.setText("");
        txtNombre.setText("");
        txtADescripcion.setText("");
        rbSaldoDeudor.setSelected(false);
        rbSaldoAcreedor.setSelected(false);
        txtSaldoDeudor.setText("");
        txtSaldoAcreedor.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
        
        if(clics == 2)
        {
            Cuenta c = cuentaTabla.cuentas.get(row);
            cuentaActual = c;
            
            txtCodigo.setText(String.valueOf(c.getCodigo()));
            txtNombre.setText(c.getNombreCuenta());
            txtADescripcion.setText(c.getDescripcion());
            txtSaldoDeudor.setText(String.valueOf(c.getSaldoDeudor()));
            txtSaldoAcreedor.setText(String.valueOf(c.getSaldoAcreedor()));
            txtCodigo.disable();
            cmbEstadoFin.setSelectedItem(c.getEstadoFinanciero());
            guardar = false;
        }
    }//GEN-LAST:event_tableCuentaMouseClicked

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
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoCuenta().setVisible(true);
            }
        });
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        try {
            conexion.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión con la base de datos");
        }
        JOptionPane.showMessageDialog(this, "La conexión a la base de datos ha sido cerrada");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGRadio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCuentaMayor;
    private javax.swing.JComboBox<String> cmbEstadoFin;
    private javax.swing.JComboBox<String> cmbGrupoCuenta;
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
