/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Dalton
 */
public class Cuenta {

    private int codigo;
    private String nombreCuenta;
    private String descripcion;
    private char estadoFinanciero;
    private String grupoCuenta;
    private double saldoDeudor;
    private double saldoAcreedor;
    private double saldoFinal;
    private int codigoMayor;
    private String nombreMayor;

    public Cuenta(String nombreCuenta, String descripcion, char estadoFinanciero, String grupoCuenta) {
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

    public char getEstadoFinanciero() {
        return estadoFinanciero;
    }

    public void setEstadoFinanciero(char estadoFinanciero) {
        this.estadoFinanciero = estadoFinanciero;
    }

    public String getGrupoCuenta() {
        return grupoCuenta;
    }

    public void setGrupoCuenta(String grupoCuenta) {
        this.grupoCuenta = grupoCuenta;
    }

    public double getSaldoDeudor() {
        return saldoDeudor;
    }

    public void setSaldoDeudor(double saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }

    public double getSaldoAcreedor() {
        return saldoAcreedor;
    }

    public void setSaldoAcreedor(double saldoAcreedor) {
        this.saldoAcreedor = saldoAcreedor;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    @Override
    public String toString() {
        String s=null;
        if(codigo==0){
            s= nombreCuenta;
        }else {
            s=codigo + " " + nombreCuenta;
        }
        return s;
    }
    
}
