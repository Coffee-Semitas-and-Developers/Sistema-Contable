/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author jorge
 */
public class Extra {
   // '0'-Descuento, '1'-Bonificación
   private boolean estado;
   private String descrip;
   private double porcentaje,monto=0;

    //Escribir nulll en porcentaje para establecer un monto definido
    public Extra(boolean estado, String descrip, double porcentaje, double monto) {
        this.estado = estado;
        this.descrip = descrip;
        this.porcentaje = porcentaje;
        this.monto = monto;
    }   
        public Extra(boolean estado, String descrip, double monto) {
        this.estado = estado;
        this.descrip = descrip;
        this.monto = monto;
    }  
   
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
   
    public void calcularMonto(double salario){
        this.monto= salario* this.porcentaje;
    }  
}
