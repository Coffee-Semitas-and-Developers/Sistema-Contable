/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author AxlHrndz
 */
public class DetalleKardex {

    private int idDetalle;
    private boolean entrada;
    private int cantidad;
    private double costoUnitario;
    private double montoDetalleKardex;
    private OrdenDeFabricacion orden;

    public DetalleKardex() {
    }

    public DetalleKardex(int idDetalle, boolean entrada, int cantidad, double costoUnitario, double montoDetalleKardex) {
        this.idDetalle = idDetalle;
        this.entrada = entrada;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.montoDetalleKardex = montoDetalleKardex;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getMontoDetalleKardex() {
        return montoDetalleKardex;
    }

    public double calcularMontoDetalleKardex() {
        montoDetalleKardex = this.costoUnitario * this.cantidad;
        return montoDetalleKardex;
    }
}
