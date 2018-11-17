/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import static BDContabilidad.Conexion.conect;
import static BDContabilidad.Conexion.conectar;
import ModeloContabilidad.Cuenta;
import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class MenuContador extends javax.swing.JFrame {

    Vector<Cuenta> subCuentas = new Vector<Cuenta>();
    int periodoProceso = 4;
    int numPeriodo;

    /**
     * Creates new form MenuContador
     */
    public MenuContador() {
        initComponents();
        this.setTitle("Menú");
        PanelImagen obj = new PanelImagen();
        obj.setImagen("/Imagenes/fondoverdesi.jpg");
        this.add(obj, BorderLayout.CENTER);
        this.pack();
        periodoProceso();

    }

    public void periodoProceso() {

        conectar();
        try {
            CallableStatement cstmt = conect.prepareCall("{call sic.sp_proceso_periodo(?,?)}");
            cstmt.registerOutParameter("periodoProceso", Types.INTEGER);
            cstmt.registerOutParameter("numPeriodo", Types.INTEGER);
            cstmt.execute();
            int outputValue = cstmt.getInt("periodoProceso");
            numPeriodo = cstmt.getInt("numPeriodo");
            periodoProceso = outputValue;

        } catch (Exception e) {
            e.printStackTrace();

        }

        if (periodoProceso == 2) {
            btnGestionarTransaccion.setEnabled(false);
            btnFinalizarPeriodo.setEnabled(false);
            btnEstadosFinancieros.setEnabled(false);
            btnAjustes.setEnabled(false);

        } else {
            if (periodoProceso == 1) {
                btnGestionarTransaccion.setEnabled(true);
                btnFinalizarPeriodo.setEnabled(true);
                btnEstadosFinancieros.setEnabled(false);
                btnAjustes.setEnabled(false);
                btnIniciarPeriodo.setEnabled(false);

            } else {
                if (periodoProceso == 0) {
                    btnIniciarPeriodo.setEnabled(true);
                    btnGestionarTransaccion.setEnabled(false);
                    btnFinalizarPeriodo.setEnabled(false);
                    btnEstadosFinancieros.setEnabled(true);
                    btnAjustes.setEnabled(true);

                }

            }
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnEstadosFinancieros = new javax.swing.JButton();
        btnGestionarTransaccion = new javax.swing.JButton();
        btnIniciarPeriodo = new javax.swing.JButton();
        btnFinalizarPeriodo = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("CONTABILIDAD GENERAL");

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(16, 32, 17));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sal2.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(-3);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sal3.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sal1.png"))); // NOI18N
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnEstadosFinancieros.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEstadosFinancieros.setForeground(new java.awt.Color(16, 32, 17));
        btnEstadosFinancieros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estado2.png"))); // NOI18N
        btnEstadosFinancieros.setText("Estados Financieros");
        btnEstadosFinancieros.setBorder(null);
        btnEstadosFinancieros.setBorderPainted(false);
        btnEstadosFinancieros.setContentAreaFilled(false);
        btnEstadosFinancieros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstadosFinancieros.setIconTextGap(-3);
        btnEstadosFinancieros.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estado3.png"))); // NOI18N
        btnEstadosFinancieros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estado1.png"))); // NOI18N
        btnEstadosFinancieros.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEstadosFinancieros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstadosFinancieros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadosFinancierosActionPerformed(evt);
            }
        });

        btnGestionarTransaccion.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnGestionarTransaccion.setForeground(new java.awt.Color(16, 32, 17));
        btnGestionarTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trans2.png"))); // NOI18N
        btnGestionarTransaccion.setText("Gestionar Transacción");
        btnGestionarTransaccion.setBorder(null);
        btnGestionarTransaccion.setBorderPainted(false);
        btnGestionarTransaccion.setContentAreaFilled(false);
        btnGestionarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarTransaccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGestionarTransaccion.setIconTextGap(-3);
        btnGestionarTransaccion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Trans3.png"))); // NOI18N
        btnGestionarTransaccion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Trans1.png"))); // NOI18N
        btnGestionarTransaccion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGestionarTransaccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGestionarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarTransaccionActionPerformed(evt);
            }
        });

        btnIniciarPeriodo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnIniciarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniper2.png"))); // NOI18N
        btnIniciarPeriodo.setText("Iniciar Periodo Contable");
        btnIniciarPeriodo.setBorderPainted(false);
        btnIniciarPeriodo.setContentAreaFilled(false);
        btnIniciarPeriodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarPeriodo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniper1.png"))); // NOI18N
        btnIniciarPeriodo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniper1.png"))); // NOI18N
        btnIniciarPeriodo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPeriodoActionPerformed(evt);
            }
        });

        btnFinalizarPeriodo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnFinalizarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finper2.png"))); // NOI18N
        btnFinalizarPeriodo.setText("Finalizar Periodo Contable");
        btnFinalizarPeriodo.setBorderPainted(false);
        btnFinalizarPeriodo.setContentAreaFilled(false);
        btnFinalizarPeriodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizarPeriodo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finper1.png"))); // NOI18N
        btnFinalizarPeriodo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finper1.png"))); // NOI18N
        btnFinalizarPeriodo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPeriodoActionPerformed(evt);
            }
        });

        btnAjustes.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ajustes2.png"))); // NOI18N
        btnAjustes.setText("Ajustar Transaccion");
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAjustes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ajustes1.png"))); // NOI18N
        btnAjustes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ajustes1.png"))); // NOI18N
        btnAjustes.setVerifyInputWhenFocusTarget(false);
        btnAjustes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar2.png"))); // NOI18N
        jButton1.setText("Agregar Cuenta al Catalogo");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar1.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar1.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionarTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnIniciarPeriodo)))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEstadosFinancieros, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarPeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAjustes)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(jButton2)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGestionarTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAjustes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnEstadosFinancieros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarPeriodo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFinalizarPeriodo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BANNER13.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MenuCont_1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)))
                        .addGap(525, 525, 525))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarTransaccionActionPerformed
        GestionarTransaccion gesTran = new GestionarTransaccion();
        gesTran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionarTransaccionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuPrincipalConta obj = new MenuPrincipalConta();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnIniciarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPeriodoActionPerformed
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog // Sigue en la siguiente linea
                (rootPane, "¿Iniciar nuevo periodo?", "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            conectar();
            try {
                CallableStatement cstmt = conect.prepareCall("{call sic.sp_iniciarperiodo}");
                cstmt.execute();

            } catch (Exception e) {
                e.printStackTrace();

            }
            btnGestionarTransaccion.setEnabled(true);
            btnFinalizarPeriodo.setEnabled(true);
            btnIniciarPeriodo.setEnabled(false);
            btnAjustes.setEnabled(false);
            btnEstadosFinancieros.setEnabled(false);
           
            
            
        }//end if
    }//GEN-LAST:event_btnIniciarPeriodoActionPerformed

    private void btnFinalizarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPeriodoActionPerformed
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog // Sigue en la siguiente linea
                (rootPane, "¿En realidad desea finalizar el periodo:?", "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            btnGestionarTransaccion.setEnabled(false);
            btnFinalizarPeriodo.setEnabled(false);
            btnEstadosFinancieros.setEnabled(true);
            btnAjustes.setEnabled(true);
            btnIniciarPeriodo.setEnabled(true);

            conectar();
            try {
                CallableStatement cstmt = conect.prepareCall("{call sic.sp_saldarCuentas(?,?)}");
                cstmt.setInt(1, 0);
                cstmt.setInt(2, 0);
                cstmt.execute();
                ResultSet rs = cstmt.getResultSet();
                subCuentas.clear();
                while (rs.next()) {
                    Cuenta objCuenta = new Cuenta();
                    objCuenta.setCodigo(String.valueOf(rs.getInt("CODIGO")));
                    objCuenta.setNombre(null);
                    objCuenta.setSaldoAcreedor(null);
                    objCuenta.setSaldoDeudor(null);
                    objCuenta.setTipo(null);
                    subCuentas.add(objCuenta);
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

            for (int i = 0; i < subCuentas.size(); i++) {
                try {
                    CallableStatement cstmt = conect.prepareCall("{call sic.sp_saldarCuentas(?,?)}");
                    cstmt.setInt(1, 1);
                    cstmt.setInt(2, Integer.valueOf(subCuentas.get(i).getCodigo()));
                    cstmt.execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
        }//end if

    }//GEN-LAST:event_btnFinalizarPeriodoActionPerformed

    private void btnEstadosFinancierosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadosFinancierosActionPerformed
        EstadosFinancieros obj = new EstadosFinancieros();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadosFinancierosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarCuentaCatalogo obj = new AgregarCuentaCatalogo();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
        AjustarTransaccion obj = new AjustarTransaccion();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAjustesActionPerformed

    public void cerrar() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog // Sigue en la siguiente linea
                (rootPane, "¿En realidad desea cerrar la aplicacion?", "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
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
            java.util.logging.Logger.getLogger(MenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuContador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnEstadosFinancieros;
    private javax.swing.JButton btnFinalizarPeriodo;
    private javax.swing.JButton btnGestionarTransaccion;
    private javax.swing.JButton btnIniciarPeriodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}