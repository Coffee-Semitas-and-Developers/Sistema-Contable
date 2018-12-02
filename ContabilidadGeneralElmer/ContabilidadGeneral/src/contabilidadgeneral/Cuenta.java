/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidadgeneral;

/**
 *
 * @author Elmer
 */
public class Cuenta {
    int codigo;
    String nombreCuenta;
    String descripcion;
    String grupoCuenta;
    double saldoDeudor;
    double saldoAcreedor;
    double saldoFinal;
    Cuenta subcuenta;

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

    public Cuenta getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(Cuenta subcuenta) {
        this.subcuenta = subcuenta;
    }
    
    public String toString() {
      return nombreCuenta;
   }
    
}
