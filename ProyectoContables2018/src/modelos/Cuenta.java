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
    private Cuenta cuentaPadre;

    public Cuenta(String nombreCuenta, String descripcion, Cuenta cuentaPadre,char estadoFinanciero, String grupoCuenta) {
        this.nombreCuenta = nombreCuenta;
        this.descripcion = descripcion;
        this.cuentaPadre = cuentaPadre;
        this.estadoFinanciero = estadoFinanciero;
        this.grupoCuenta = grupoCuenta;
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

    public Cuenta getCuentaPadre() {
        return cuentaPadre;
    }

    public void setCuentaPadre(Cuenta cuentaPadre) {
        this.cuentaPadre = cuentaPadre;
    }
    
     @Override
    public String toString() {
        return "Cuenta: " + "Código: " + codigo + ", Cuenta: " + nombreCuenta + ", Descripcion: " + descripcion + ", Cuenta Mayor: " + cuentaPadre.nombreCuenta + ", Estado Financiero Perteneciente: " + estadoFinanciero + ", Grupo de la Cuenta: " + grupoCuenta + '}';
    }
    
}
