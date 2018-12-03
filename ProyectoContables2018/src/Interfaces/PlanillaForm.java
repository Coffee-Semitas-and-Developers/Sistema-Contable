/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.*;
import Modelos.Empleado;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Iterator;

/**
 *
 * @author jorge
 */
public class PlanillaForm extends javax.swing.JFrame {

    String dat;
    private Connection conexion;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = new GregorianCalendar();
    Date d = new Date();
    java.sql.Date sqlDate;
    LineaPlanillaTableModel lineaTM = new LineaPlanillaTableModel();
    LineaPlanillaPatronoTableModel lineaPatronoTM = new LineaPlanillaPatronoTableModel();
    LineaPlanillaVacTableModel1 lineaVTM = new LineaPlanillaVacTableModel1();
    LineaPlanillaPatronoVacTableModel1 lineaPatronoVTM = new LineaPlanillaPatronoVacTableModel1();
    LineaPlanillaAguiTableModel lineaATM = new LineaPlanillaAguiTableModel();
    LineaPlanillaPatronoAguiTableModel lineaPatronoATM = new LineaPlanillaPatronoAguiTableModel();

    List<LineaPlanilla> ln = new ArrayList<LineaPlanilla>();

    public PlanillaForm() {
        initComponents();
        background();
        setFecha();
        llenarCombos();
        conectar();
        inicializarColumnas();
        consultaInicial();
        tablaLinea.setComponentPopupMenu(popmenu);
        tablaLinea.addMouseListener(new TableMouseListener(tablaLinea));
        itemDesc.setEnabled(true);
        itemBoni.setEnabled(true);

    }

    private void background() {
        Fondo f = new Fondo();
        f.setSize(this.getSize());
        this.add(f);
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
            System.out.println(ex);
        }
        lbDate.setText(dat);
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic", "semitas",
                    "semita");

        } catch (SQLException ex) {
            Logger.getLogger(AdminEmpleadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        for (int i = 0; i < 13; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("");
                    break;
                case 1:
                    col.setHeaderValue("Nombres");
                    break;
                case 2:
                    col.setHeaderValue("Apellidos");
                    break;
                case 3:
                    col.setHeaderValue("Cargo");
                    break;
                case 4:
                    col.setHeaderValue("Horas Trabajadas");
                    break;
                case 5:
                    col.setHeaderValue("Horas Extra");
                    break;
                case 6:
                    col.setHeaderValue("Salario");
                    break;
                case 7:
                    col.setHeaderValue("ISSS");
                    break;
                case 8:
                    col.setHeaderValue("AFP");
                    break;
                case 9:
                    col.setHeaderValue("Renta");
                    break;
                case 10:
                    col.setHeaderValue("Bonificaciones");
                    break;
                case 11:
                    col.setHeaderValue("Otros descuentos");
                    break;
                case 12:
                    col.setHeaderValue("Salario");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tablaLinea.setColumnModel(tColumnModel);

        TableColumnModel tColumnModel1 = new DefaultTableColumnModel();
        for (int i = 0; i < 7; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Nombres");
                    break;
                case 1:
                    col.setHeaderValue("Apellidos");
                    break;
                case 2:
                    col.setHeaderValue("Cargo");
                    break;
                case 3:
                    col.setHeaderValue("Salario");
                    break;
                case 4:
                    col.setHeaderValue("ISSS");
                    break;
                case 5:
                    col.setHeaderValue("AFP");
                    break;
                case 6:
                    col.setHeaderValue("Aporte Patronal");
                    break;
            }
            tColumnModel1.addColumn(col);
        }
        patronoTable.setColumnModel(tColumnModel1);

    }

    private void inicializarColumnasAguinaldo() {
        TableColumnModel tColumnModel2 = new DefaultTableColumnModel();
        for (int i = 0; i < 7; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("");
                    break;
                case 1:
                    col.setHeaderValue("Nombres");
                    break;
                case 2:
                    col.setHeaderValue("Apellidos");
                    break;
                case 3:
                    col.setHeaderValue("Cargo");
                    break;
                case 4:
                    col.setHeaderValue("Aguinaldo");
                    break;
                case 5:
                    col.setHeaderValue("Renta");
                    break;
                case 6:
                    col.setHeaderValue("Aguinaldo Pagado");
                    break;
            }
            tColumnModel2.addColumn(col);
        }
        tablaLinea.setColumnModel(tColumnModel2);
    }

    private void inicializarColumnasVacaciones() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        for (int i = 0; i < 9; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("");
                    break;
                case 1:
                    col.setHeaderValue("Nombres");
                    break;
                case 2:
                    col.setHeaderValue("Apellidos");
                    break;
                case 3:
                    col.setHeaderValue("Cargo");
                    break;
                case 4:
                    col.setHeaderValue("Salario");
                    break;
                case 5:
                    col.setHeaderValue("ISSS");
                    break;
                case 6:
                    col.setHeaderValue("AFP");
                    break;
                case 7:
                    col.setHeaderValue("Renta");
                    break;
                case 8:
                    col.setHeaderValue("Salario");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tablaLinea.setColumnModel(tColumnModel);

        TableColumnModel tColumnModel1 = new DefaultTableColumnModel();
        for (int i = 0; i < 7; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Nombres");
                    break;
                case 1:
                    col.setHeaderValue("Apellidos");
                    break;
                case 2:
                    col.setHeaderValue("Cargo");
                    break;
                case 3:
                    col.setHeaderValue("Salario");
                    break;
                case 4:
                    col.setHeaderValue("ISSS");
                    break;
                case 5:
                    col.setHeaderValue("AFP");
                    break;
                case 6:
                    col.setHeaderValue("Aporte Patronal");
                    break;
            }
            tColumnModel1.addColumn(col);
        }
        patronoTable.setColumnModel(tColumnModel1);

    }

    private void consultaInicial() {
        try {
            String sentenciaSql = "SELECT * FROM Empleado";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()) {
                Empleado e = new Empleado();
                e.setFechaContrato(resultado.getDate("fechacontrato"));
                e.setDui(resultado.getString("dui"));
                e.setNombres(resultado.getString("nombre"));
                e.setApellidos(resultado.getString("apellido"));
                e.setCargo(resultado.getString("cargo"));
                e.setNit(resultado.getString("nit"));
                e.setNup(resultado.getString("nup"));
                e.setNumIss(resultado.getString("numIsss"));
                e.setTel(resultado.getString("tel"));
                TarjetaDeTiempo ta = new TarjetaDeTiempo(5.00);
                ta.detalle.add(new DetalleTarjetaDeTiempo(160));
                e.t.add(ta);
                ln.add(new LineaPlanilla(e));
                //Tabla salarios
                this.lineaTM.ln.add(new LineaPlanilla(e));
                this.lineaPatronoTM.ln.add(new LineaPlanilla(e));
                //Table de Vacaciones
                this.lineaVTM.ln.add(new LineaPlanilla(e));
                this.lineaPatronoVTM.ln.add(new LineaPlanilla(e));
                //Table de aguinaldo
                this.lineaATM.ln.add(new LineaPlanilla(e));
                this.lineaPatronoATM.ln.add(new LineaPlanilla(e));

            }
            tablaLinea.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los Empleados de la base de datos");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popmenu = new javax.swing.JPopupMenu();
        itemDesc = new javax.swing.JMenuItem();
        itemBoni = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcTipo = new javax.swing.JComboBox<>();
        jcOcasion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLinea = new javax.swing.JTable();
        jbProcesar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        patronoTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        itemDesc.setText("Agregar descuento");
        itemDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDescActionPerformed(evt);
            }
        });
        popmenu.add(itemDesc);

        itemBoni.setText("Agregar bonificación");
        itemBoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBoniActionPerformed(evt);
            }
        });
        popmenu.add(itemBoni);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        jLabel1.setText("Fecha:");

        lbDate.setText("--/--/--");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Ocasión:");

        jcTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcTipoItemStateChanged(evt);
            }
        });
        jcTipo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcTipoPropertyChange(evt);
            }
        });

        jcOcasion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcOcasionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(jcOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jcOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO PEQUEÑO.jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel10.setText("PLANILLA");

        tablaLinea.setModel(lineaTM);
        tablaLinea.setName("tablaLinea"); // NOI18N
        jScrollPane1.setViewportView(tablaLinea);

        jbProcesar.setText("Procesar ");
        jbProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcesarActionPerformed(evt);
            }
        });

        patronoTable.setModel(lineaPatronoTM);
        jScrollPane2.setViewportView(patronoTable);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TABLA APORTE PATRONAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(536, 536, 536)
                                .addComponent(jLabel10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jbProcesar)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcesarActionPerformed
        // TODO add your handling code here:
        if (jcOcasion.getSelectedIndex() == 0) {
            calcularTotalSalario();
            calcularAFPSalario();
            calcularISSSalario();
            calcularRentaSalario();
            calcularAFPSalarioPatrono();
            calcularISSSalarioPatrono();
            totalAporteSalarioPatrono();
            guardarPlanillaSalario();
        }
         if (jcOcasion.getSelectedIndex() == 1) {
            calcularTotalSalarioVaca();
            calcularAFPSalarioVaca();
            calcularISSSalarioVaca();
            calcularRentaSalarioVaca();
            calcularAFPSalarioPatronoVaca();
            calcularISSSalarioPatronoVaca();
            totalAporteSalarioPatronoVaca();
        }
         if (jcOcasion.getSelectedIndex() == 2) {
            calcularTotalSalarioAgui();
            calcularRentaSalarioAgui();

         }

    }//GEN-LAST:event_jbProcesarActionPerformed

    private void guardarPlanillaSalario() {
        try {
            String sentenciaSql = "INSERT INTO Planilla(fechapago, tipo,ocasion,totalplanilla)  VALUES "
                    + "(?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setBoolean(2, false);
            preparedStatement.setString(3, "Salario");
            preparedStatement.setDouble(4, calcularTotalSalario());
            preparedStatement.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los Empleados de la base de datos");
            ex.printStackTrace();
        }
    }

    private void jcTipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcTipoPropertyChange
        // TODO add your handling code here:
        lineaTM.setTipo(jcTipo.getSelectedIndex());
        tablaLinea.repaint();
    }//GEN-LAST:event_jcTipoPropertyChange

    private void jcTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcTipoItemStateChanged
        // TODO add your handling code here 
        lineaTM.setTipo(jcTipo.getSelectedIndex());
        tablaLinea.repaint();
    }//GEN-LAST:event_jcTipoItemStateChanged

    private void itemDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDescActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int currentRow = tablaLinea.getSelectedRow();
        double monto = 0;
        String descrip = "";

        descrip = JOptionPane.showInputDialog(null, "Ingrese el motivo de descuento", "Descuento");
        try {
            monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad a descontar", "Descuento"));
        } catch (Exception e) {
            monto = Double.parseDouble(JOptionPane.showInputDialog(null, "ngrese denuevo la cantidad a descontar, asegurese de ingresar un número", "Descuento"));
        }

        lineaTM.ln.get(currentRow).extras.add(new Extra(false, descrip, monto));
        lineaTM.fireTableDataChanged();

        tablaLinea.repaint();
    }//GEN-LAST:event_itemDescActionPerformed

    private void itemBoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBoniActionPerformed
        // TODO add your handling code here:
        int currentRow = tablaLinea.getSelectedRow();
        double monto = 0;
        String descrip = "";

        descrip = JOptionPane.showInputDialog(null, "Ingrese el motivo de la bonificación", "Bonificación");
        try {
            monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto de bonifiación", "Bonificación"));
        } catch (Exception e) {
            monto = Double.parseDouble(JOptionPane.showInputDialog(null, "ngrese denuevo la cantidad a bonificar, asegurese de ingresar un número", "Bonificación"));

        }
        lineaTM.ln.get(currentRow).extras.add(new Extra(true, descrip, monto));
        lineaTM.fireTableDataChanged();
        tablaLinea.repaint();
    }//GEN-LAST:event_itemBoniActionPerformed

    private void jcOcasionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcOcasionItemStateChanged
        // TODO add your handling code here:
        if (jcOcasion.getSelectedIndex() == 0) {
            itemDesc.setEnabled(true);
            itemBoni.setEnabled(true);
            patronoTable.setVisible(true);

            tablaLinea.removeAll();
            tablaLinea.setModel(lineaTM);
            patronoTable.setModel(lineaPatronoTM);
            inicializarColumnas();

            /* int c = 0;
            tablaLinea.removeAll();
            lineaTM.ln.clear();
            Iterator<LineaPlanilla> i = ln.iterator();
            while (i.hasNext()) {
                LineaPlanilla e = i.next();
                this.lineaTM.ln.add(e);
                this.lineaTM.fireTableDataChanged();
                c++;
            }
            tablaLinea.setModel(lineaTM);
            
            System.out.print("eMPLEADOS" + c);
            c = 0;
            patronoTable.removeAll();
            Iterator<LineaPlanilla> i1 = ln.iterator();
            i1 = this.ln.iterator();
            while (i1.hasNext()) {
                LineaPlanilla l = i1.next();
                this.lineaPatronoTM.ln.add(l);
                this.lineaPatronoTM.fireTableDataChanged();
                c++;
            }
            patronoTable.setModel(lineaPatronoTM);

            System.out.println("Lista patro" + c);
             */
            tablaLinea.repaint();
            patronoTable.repaint();

        }
        if (jcOcasion.getSelectedItem() == "Vacaciones") {
            itemDesc.setEnabled(false);
            itemBoni.setEnabled(false);
            patronoTable.setVisible(true);

            tablaLinea.setModel(lineaVTM);
            patronoTable.setModel(lineaPatronoVTM);
            inicializarColumnasVacaciones();
            tablaLinea.repaint();
            patronoTable.repaint();

        }
        if (jcOcasion.getSelectedItem() == "Aguinaldo") {
            itemDesc.setEnabled(false);
            itemBoni.setEnabled(false);
            tablaLinea.setModel(lineaATM);
            patronoTable.setVisible(false);
            inicializarColumnasAguinaldo();

    }//GEN-LAST:event_jcOcasionItemStateChanged
    }
//Datos a ingresar en la BD para salarios 

    private double calcularTotalSalario() {
        double tsalario = 0;
        System.out.print("Toral registros " + lineaTM.ln.size());

        int i = 0;
        for (int j = 0; j < lineaTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                tsalario += (lineaTM.ln.get(j).calcSalarioReal() - lineaTM.ln.get(j).getISSS(0) - lineaTM.ln.get(j).getAFP(0) - lineaTM.ln.get(j).getRenta());
                System.out.println("u");
            }
        }
        System.out.println("Salario total " + tsalario);
        System.out.print("Toral registros " + lineaTM.ln.size());

        return tsalario;
    }

    private double calcularAFPSalario() {
        double tafp = 0;
        for (int j = 0; j < lineaTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                tafp += lineaTM.ln.get(j).getAFP(0);
            }
        }
        System.out.println("afp total " + tafp);
        return tafp;
    }

    private double calcularISSSalario() {
        double tisss = 0;
        for (int j = 0; j < lineaTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                tisss += lineaTM.ln.get(j).getISSS(0);
            }
        }
        System.out.println("isss total " + tisss);
        return tisss;
    }

    private double calcularRentaSalario() {
        double trenta = 0;
        for (int j = 0; j < lineaTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                trenta += lineaTM.ln.get(j).getRenta();
            }
        }
        System.out.println("renta total " + trenta);
        return trenta;
    }

    //Patrono
    private double calcularAFPSalarioPatrono() {
        double tafp = 0;
        for (int j = 0; j < lineaPatronoTM.ln.size(); j++) {

            if (lineaTM.ln.get(j).isSelected()) {
                tafp += lineaPatronoTM.ln.get(j).getAFP(1);
            }
        }
        System.out.println("afp patrono total " + tafp);
        return tafp;
    }

    private double calcularISSSalarioPatrono() {
        double tisss = 0;
        for (int j = 0; j < lineaPatronoTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                tisss += lineaPatronoTM.ln.get(j).getISSS(1);
            }
        }
        System.out.println("isss patrono total " + tisss);
        return tisss;
    }

    private double totalAporteSalarioPatrono() {
        double apt = 0;
        for (int j = 0; j < lineaPatronoTM.ln.size(); j++) {
            ;
            if (lineaTM.ln.get(j).isSelected()) {
                apt += lineaPatronoTM.ln.get(j).aportePatronal();
            }
        }
        System.out.println("Aporte Patronal Total " + apt);
        return apt;
    }
    
    //VACACIONES
    //Empleado
    private double calcularTotalSalarioVaca() {
        double tsalario = 0;
        System.out.print("Toral registros " + lineaVTM.ln.size());

        int i = 0;
        for (int j = 0; j < lineaVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                tsalario += (lineaVTM.ln.get(j).salarioVacaciones()- lineaVTM.ln.get(j).getISSSVacaciones(0) - lineaVTM.ln.get(j).getAFPVacaciones(0) - lineaVTM.ln.get(j).getRentaVacaciones());
//                System.out.println("u");
            }
        }
        System.out.println("Salario vacaciones " + tsalario);
//        System.out.print("Toral registros " + lineaTM.ln.size());

        return tsalario;
    }

    private double calcularAFPSalarioVaca() {
        double tafp = 0;
        for (int j = 0; j < lineaVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                tafp += lineaVTM.ln.get(j).getAFPVacaciones(0);
            }
        }
        System.out.println("afp total " + tafp);
        return tafp;
    }

    private double calcularISSSalarioVaca() {
        double tisss = 0;
        for (int j = 0; j < lineaVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                tisss += lineaVTM.ln.get(j).getISSSVacaciones(0);
            }
        }
        System.out.println("isss total " + tisss);
        return tisss;
    }

    private double calcularRentaSalarioVaca() {
        double trenta = 0;
        for (int j = 0; j < lineaVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                trenta += lineaVTM.ln.get(j).getRentaVacaciones();
            }
        }
        System.out.println("renta total " + trenta);
        return trenta;
    }

    //Patrono
    private double calcularAFPSalarioPatronoVaca() {
        double tafp = 0;
        for (int j = 0; j < lineaPatronoVTM.ln.size(); j++) {

            if (lineaVTM.ln.get(j).isSelected()) {
                tafp += lineaPatronoVTM.ln.get(j).getAFPVacaciones(1);
            }
        }
        System.out.println("afp patrono total " + tafp);
        return tafp;
    }

    private double calcularISSSalarioPatronoVaca() {
        double tisss = 0;
        for (int j = 0; j < lineaPatronoVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                tisss += lineaPatronoVTM.ln.get(j).getISSSVacaciones(1);
            }
        }
        System.out.println("isss patrono total " + tisss);
        return tisss;
    }

    private double totalAporteSalarioPatronoVaca() {
        double apt = 0;
        for (int j = 0; j < lineaPatronoVTM.ln.size(); j++) {
            ;
            if (lineaVTM.ln.get(j).isSelected()) {
                apt += lineaPatronoVTM.ln.get(j).aportePatronalVacaciones();
            }
        }
        System.out.println("Aporte Patronal Total " + apt);
        return apt;
    }
    
      //AGUINALDO
    //Empleado
    private double calcularTotalSalarioAgui() {
        double tsalario = 0;
        System.out.print("Toral registros " + lineaATM.ln.size());

        int i = 0;
        for (int j = 0; j < lineaATM.ln.size(); j++) {
            ;
            if (lineaATM.ln.get(j).isSelected()) {
                tsalario += (lineaATM.ln.get(j).salarioAguinaldo() - lineaATM.ln.get(j).getRentaAguinaldo());
//                System.out.println("u");
            }
        }
        System.out.println("Salario Aguinaldo " + tsalario);
//        System.out.print("Toral registros " + lineaTM.ln.size());

        return tsalario;
    }

    private double calcularRentaSalarioAgui() {
        double trenta = 0;
        for (int j = 0; j < lineaATM.ln.size(); j++) {
            ;
            if (lineaATM.ln.get(j).isSelected()) {
                trenta += lineaATM.ln.get(j).getRentaAguinaldo();
            }
        }
        System.out.println("renta total " + trenta);
        return trenta;
    }

    
    
    
    
    
    
    

    private void llenarCombos() {
        //TIPO DE PLANILLA
        jcTipo.addItem("Empleado");
        jcTipo.addItem("Patronal");

        //OCASION DE LA PLANILLA
        jcOcasion.addItem("Salarios");
        jcOcasion.addItem("Vacaciones");
        jcOcasion.addItem("Aguinaldo");
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
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanillaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanillaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemBoni;
    private javax.swing.JMenuItem itemDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbProcesar;
    private javax.swing.JComboBox<String> jcOcasion;
    private javax.swing.JComboBox<String> jcTipo;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTable patronoTable;
    private javax.swing.JPopupMenu popmenu;
    private javax.swing.JTable tablaLinea;
    // End of variables declaration//GEN-END:variables
}
