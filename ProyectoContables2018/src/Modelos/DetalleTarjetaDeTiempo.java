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
     private int diaDeTrabajo,idTrabajo,horasTrabajadas,horasExtras=0;
    private Date fehcaTarjeta;

       public DetalleTarjetaDeTiempo() {        
    }
    public DetalleTarjetaDeTiempo(int horasTrabajadas) {    
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
    public DetalleTarjetaDeTiempo(int diaDeTrabajo, int idTrabajo, int horasTrabajadas, int horasExtras, Date fehcaTarjeta) {
        this.diaDeTrabajo = diaDeTrabajo;
        this.idTrabajo = idTrabajo;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.fehcaTarjeta = fehcaTarjeta;
    }   

    public int getDiaDeTrabajo() {
        return diaDeTrabajo;
    }

    public void setDiaDeTrabajo(int diaDeTrabajo) {
        this.diaDeTrabajo = diaDeTrabajo;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
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

    public Date getFehcaTarjeta() {
        return fehcaTarjeta;
    }

    public void setFehcaTarjeta(Date fehcaTarjeta) {
        this.fehcaTarjeta = fehcaTarjeta;
    }
}
