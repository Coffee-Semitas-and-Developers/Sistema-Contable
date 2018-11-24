/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Gonzalo
 */
public class Cuenta {
    private int idcuenta;
   private String nomcuenta;
   private String grupocuenta;
   private double saldoDeudor;
   private double salfoAcreedor;
   private double saldofinal;

    public Cuenta(int idcuenta, String nomcuenta, String grupocuenta, double saldoDeudor, double salfoAcreedor, double saldofinal) {
        this.idcuenta = idcuenta;
        this.nomcuenta = nomcuenta;
        this.grupocuenta = grupocuenta;
        this.saldoDeudor = saldoDeudor;
        this.salfoAcreedor = salfoAcreedor;
        this.saldofinal = saldofinal;
    }

    public Cuenta() {
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public String getNomcuenta() {
        return nomcuenta;
    }

    public String getGrupocuenta() {
        return grupocuenta;
    }

    public double getSaldoDeudor() {
        return saldoDeudor;
    }

    public double getSalfoAcreedor() {
        return salfoAcreedor;
    }

    public double getSaldofinal() {
        return saldofinal;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public void setNomcuenta(String nomcuenta) {
        this.nomcuenta = nomcuenta;
    }

    public void setGrupocuenta(String grupocuenta) {
        this.grupocuenta = grupocuenta;
    }

    public void setSaldoDeudor(double saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }

    public void setSalfoAcreedor(double salfoAcreedor) {
        this.salfoAcreedor = salfoAcreedor;
    }

    public void setSaldofinal(double saldofinal) {
        this.saldofinal = saldofinal;
    }
   
   
}
