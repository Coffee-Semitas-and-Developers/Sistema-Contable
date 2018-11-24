package Interfaces;

import Conexion.Conexion;
import javax.swing.JOptionPane;

public class MantenimientoCuenta extends javax.swing.JFrame {

    private Conexion conexion = new Conexion();

    public MantenimientoCuenta() {
        initComponents();
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
        panelTxtADescripcion = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        cmbCuentaMayor = new javax.swing.JComboBox<>();
        cmbGrupoCuenta = new javax.swing.JComboBox<>();
        cmbEstadoFin = new javax.swing.JComboBox<>();
        txtSaldorDeudor = new javax.swing.JTextField();
        txtSaldorAcreedor = new javax.swing.JTextField();
        rbSaldoDeudor = new javax.swing.JRadioButton();
        rbSaldoAcreedor = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MantenimientoCuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("fCuenta"); // NOI18N

        lblListadoCuenta.setText("Listado de Cuentas");
        lblListadoCuenta.setName("lblListadoCuentas"); // NOI18N

        tableCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableCuenta.setName("tableCuenta"); // NOI18N
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

        txtCodigo.setEnabled(false);
        txtCodigo.setName("txtCodigo"); // NOI18N

        txtNombre.setName("txtNombre"); // NOI18N

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        txtADescripcion.setName("txtADescripcion"); // NOI18N
        panelTxtADescripcion.setViewportView(txtADescripcion);

        cmbCuentaMayor.setName("cmbCuentaMayor"); // NOI18N

        cmbGrupoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Corriente", "No Corriente", "Diferido", "Distribuido", "Ganado", "Inversión", "Desinversión" }));
        cmbGrupoCuenta.setName("cmbGrupoCuenta"); // NOI18N

        cmbEstadoFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado de Resultado", "Estado de Capital", "Balance General", " " }));
        cmbEstadoFin.setName("cmbEstadoFinanciero"); // NOI18N

        txtSaldorDeudor.setEnabled(false);
        txtSaldorDeudor.setName("txtSaldoDeudor"); // NOI18N

        txtSaldorAcreedor.setEnabled(false);
        txtSaldorAcreedor.setName("txtSaldoAcreedor"); // NOI18N

        btnGRadio.add(rbSaldoDeudor);
        rbSaldoDeudor.setText("Saldo Deudor");
        rbSaldoDeudor.setName("rbSaldoDeudor"); // NOI18N

        btnGRadio.add(rbSaldoAcreedor);
        rbSaldoAcreedor.setText("Saldo Acreedor");
        rbSaldoAcreedor.setName("rbSaldoAcreedor"); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N

        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); // NOI18N

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setName("btnLimpiar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTableCuenta)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblListadoCuenta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblCodigo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblNombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNombre))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(lblDescripcion)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(panelTxtADescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(rbSaldoAcreedor)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(rbSaldoDeudor)
                                                            .addGap(16, 16, 16)))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtSaldorDeudor)
                                                        .addComponent(txtSaldorAcreedor, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(lblCuentaMayor)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblGrupoCuenta)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblEstadoFin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addGap(26, 26, 26))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListadoCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(panelTxtADescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCuentaMayor)
                            .addComponent(cmbCuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrupoCuenta)
                            .addComponent(cmbGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoFin)
                    .addComponent(cmbEstadoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSaldorDeudor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSaldoDeudor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldorAcreedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSaldoAcreedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCuentaMayor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstadoFin;
    private javax.swing.JLabel lblGrupoCuenta;
    private javax.swing.JLabel lblListadoCuenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JScrollPane panelTableCuenta;
    private javax.swing.JScrollPane panelTxtADescripcion;
    private javax.swing.JRadioButton rbSaldoAcreedor;
    private javax.swing.JRadioButton rbSaldoDeudor;
    private javax.swing.JTable tableCuenta;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldorAcreedor;
    private javax.swing.JTextField txtSaldorDeudor;
    // End of variables declaration//GEN-END:variables
}
