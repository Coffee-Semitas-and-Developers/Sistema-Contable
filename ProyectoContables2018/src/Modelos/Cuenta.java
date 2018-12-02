/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Conexion.Conexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalton
 */
public class Cuenta {

    private int codigo;
    private String nombreCuenta;
    private String descripcion;
    private char[] estadoFinanciero = new char[2];
    private String grupoCuenta;
    private double saldoFinal;
    private int codigoMayor;
    private String nombreMayor;

    public Cuenta(String nombreCuenta, String descripcion, char[] estadoFinanciero, String grupoCuenta) {
        this.nombreCuenta = nombreCuenta;
        this.descripcion = descripcion;
        this.estadoFinanciero = estadoFinanciero;
        this.grupoCuenta = grupoCuenta;
    }

    public Cuenta() {
    }

    public Cuenta(int codigo, String nombreCuenta) {
        this.codigo = codigo;
        this.nombreCuenta = nombreCuenta;
    }

    public int getCodigoMayor() {
        return codigoMayor;
    }

    public void setCodigoMayor(int codigoMayor) {
        this.codigoMayor = codigoMayor;
    }

    public String getNombreMayor() {
        return nombreMayor;
    }

    public void setNombreMayor(String nombreMayor) {
        this.nombreMayor = nombreMayor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstadoFinanciero(int i) {
        return estadoFinanciero[i];
    }

    public void setEstadoFinanciero(char estadoFinanciero, int i) {
        this.estadoFinanciero[i] = estadoFinanciero;
    }

    public String getGrupoCuenta() {
        return grupoCuenta;
    }

    public void setGrupoCuenta(String grupoCuenta) {
        this.grupoCuenta = grupoCuenta;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    @Override
    public String toString() {
        String s = null;
        if (codigo == 0) {
            s = nombreCuenta;
        } else {
            s = codigo + " " + nombreCuenta;
        }
        return s;
    }

    private double obtenerdebe() {
        double debe = 0;

        try {
            String setencia = "select * from detalletransaccion where codigocuenta=" + String.valueOf(codigo);
            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            while (tabla.next()) {
                debe+= tabla.getDouble("debe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }

        return debe;
    }

    private double obtenerhaber() {
        double haber = 0;
        try {
            String setencia = "select * from detalletransaccion where codigocuenta=" + String.valueOf(codigo);
            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            while (tabla.next()) {                
                    haber += tabla.getDouble("haber");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
        return haber;
    }

    private void obtenersaldo() {
        double debe = 0;
        double haber = 0;
        try {
            String setencia = "select * from detalletransaccion where codigocuenta="+ String.valueOf(codigo);
            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            while (tabla.next()) {
                    debe += tabla.getDouble("debe");
                    haber += tabla.getDouble("haber");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
        saldoFinal = debe - haber;
    }

    private double obtenersaldoconfecha(int idcuenta, Date fechainicio, Date fechafinal) {
        double debe = 0;
        double haber = 0;
        double saldo = 0;
        int cuenta = idcuenta;

        try {
            /*Sentencia SQL para las fecha registradas y las cuentas*/
            String setencia = "select * from detalletransaccion where codigocuenta="+String.valueOf(codigo);
            String setenciafechainicio = "select * from (SELECT * FROM "
                    + "detalletransaccion d inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion asc limit 1";
            //esta sentencia me recoge la fecha utima registrada 
            String setenciafechafinal = "select * from (SELECT * FROM detalletransaccion d "
                    + "inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion desc limit 1";

            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            ResultSet fecinicio = conexion.executeQuery(setenciafechainicio);
            ResultSet fecfinal = conexion.executeQuery(setenciafechafinal);
            Date fechainibase = fecinicio.getDate("fechatransaccion");/*incluyo la fecha a un atribuyo de tipo Date esta sera la primera del los registro */
            Date fechafinalbase = fecfinal.getDate("fechatransaccion");//esta fecha sera la final de los registros 

            while (tabla.next()) {
                int identificador = tabla.getInt("idcuenta");
                /*if compara las fecha de tipo date si las fechas son iguales
                da como resultado 0 si las fecha 1 es mayor que la que esta en el parametro 
                el resultado es un valor mayor a cero si es la fecha 1 es menor que lafecha en el 
                parametro da un valor menor que cero*/
                //establece el rango de fechas
                if (fechainicio.compareTo(fechainibase) > 0 && fechafinal.compareTo(fechafinalbase) < 0) {
                    if (cuenta == identificador) {
                        debe += tabla.getDouble("debe");
                        haber += tabla.getDouble("haber");
                    }//if cuenta        
                } //if fecha
                else {
                    JOptionPane.showInternalMessageDialog(null, "la fecha no se encuentra en los registro contables");
                }
            }//while
        }//try
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
        saldo = debe + haber;
        return saldo;
    }

    private double obtenerdebeconfecha(int idcuenta, Date fechainicio, Date fechafinal) {
        double debe = 0;
        int cuenta = idcuenta;

        try {
            /*Sentencia SQL para las fecha registradas y las cuentas*/
            String setencia = "select * from detalletransaccion";
            String setenciafechainicio = "select * from (SELECT * FROM "
                    + "detalletransaccion d inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion asc limit 1";
            //esta sentencia me recoge la fecha utima registrada 
            String setenciafechafinal = "select * from (SELECT * FROM detalletransaccion d "
                    + "inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion desc limit 1";

            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            ResultSet fecinicio = conexion.executeQuery(setenciafechainicio);
            ResultSet fecfinal = conexion.executeQuery(setenciafechafinal);
            Date fechainibase = fecinicio.getDate("fechatransaccion");/*incluyo la fecha a un atribuyo de tipo Date esta sera la primera del los registro */
            Date fechafinalbase = fecfinal.getDate("fechatransaccion");//esta fecha sera la final de los registros 

            while (tabla.next()) {
                int identificador = tabla.getInt("idcuenta");
                /*if compara las fecha de tipo date si las fechas son iguales
                da como resultado 0 si las fecha 1 es mayor que la que esta en el parametro 
                el resultado es un valor mayor a cero si es la fecha 1 es menor que lafecha en el 
                parametro da un valor menor que cero*/
                //establece el rango de fechas
                if (fechainicio.compareTo(fechainibase) > 0 && fechafinal.compareTo(fechafinalbase) < 0) {
                    if (cuenta == identificador) {
                        debe += tabla.getDouble("debe");
                    }//if cuenta        
                } //if fecha
                else {
                    JOptionPane.showInternalMessageDialog(null, "la fecha  no se encuentra en los registro contables");
                }
            }//while
        }//try
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
            e.printStackTrace();
        }
        return debe;
    }

    private double obtenerhaberconfecha(int idcuenta, Date fechainicio, Date fechafinal) {
        double haber = 0;
        int cuenta = idcuenta;

        try {
            /*Sentencia SQL para las fecha registradas y las cuentas*/
            String setencia = "select * from detalletransaccion";
            String setenciafechainicio = "select * from (SELECT * FROM "
                    + "detalletransaccion d inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion asc limit 1";
            //esta sentencia me recoge la fecha utima registrada 
            String setenciafechafinal = "select * from (SELECT * FROM detalletransaccion d "
                    + "inner join transaccion t on d.idtransaccion = t.idtransaccion) p "
                    + "order by fechatransaccion desc limit 1";

            Statement conexion = Conexion.getConexion().createStatement();
            ResultSet tabla = conexion.executeQuery(setencia);
            ResultSet fecinicio = conexion.executeQuery(setenciafechainicio);
            ResultSet fecfinal = conexion.executeQuery(setenciafechafinal);
            Date fechainibase = fecinicio.getDate("fechatransaccion");/*incluyo la fecha a un atribuyo de tipo Date esta sera la primera del los registro */
            Date fechafinalbase = fecfinal.getDate("fechatransaccion");//esta fecha sera la final de los registros 

            while (tabla.next()) {
                int identificador = tabla.getInt("idcuenta");
                /*if compara las fecha de tipo date si las fechas son iguales
                da como resultado 0 si las fecha 1 es mayor que la que esta en el parametro 
                el resultado es un valor mayor a cero si es la fecha 1 es menor que lafecha en el 
                parametro da un valor menor que cero*/
                //establece el rango de fechas
                if (fechainicio.compareTo(fechainibase) > 0 && fechafinal.compareTo(fechafinalbase) < 0) {
                    if (cuenta == identificador) {
                        haber += tabla.getDouble("haber");
                    }//if cuenta        
                } //if fecha
                else {
                    JOptionPane.showInternalMessageDialog(null, "la fecha  no se encuentra en los registro contables");
                }
            }//while
        }//try
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
            e.printStackTrace();
        }
        return haber;
    }
}
