/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class DetalleTarjetaDeTiempo {

    private int horasTrabajadas,horasExtras, idTarjeta, diaDeTrabajo;
    private Date fechaTarjeta;
    private String diaSeleccionado;
    private Empleado empleado;
    public DetalleTarjetaDeTiempo() {        
    }
    public DetalleTarjetaDeTiempo(int horasTrabajadas) {    
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
    public DetalleTarjetaDeTiempo(int diaDeTrabajo, int idTrabajo, int horasTrabajadas, int horasExtras, Date fehcaTarjeta) {
        this.diaDeTrabajo = diaDeTrabajo;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.fechaTarjeta = fechaTarjeta;
        this.empleado = empleado;
    }   

    public int getDiaDeTrabajo() {
        return diaDeTrabajo;
    }

    public void setDiaDeTrabajo(int diaDeTrabajo) {
        this.diaDeTrabajo = diaDeTrabajo;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public Date getFechaTarjeta() {
        return fechaTarjeta;
    }

    public void setFechaTarjeta(Date fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setDiaSeleccionado(String diaSeleccionado) {
        this.diaSeleccionado = diaSeleccionado;
    }

    public String getDiaSeleccionado() {
        return diaSeleccionado;
    }
    
    
}
