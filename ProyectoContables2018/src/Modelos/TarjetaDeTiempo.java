/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jorge
 */
public class TarjetaDeTiempo {
    private Date fechaTarjeta;
    private int idOrden, totalHorasTrabajadas, totalHorasExtras, id;
    private String dui;
    private Double salHora, salHoraExtra=0.00;
    public List<DetalleTarjetaDeTiempo> detalle = new ArrayList<DetalleTarjetaDeTiempo>();
    private Empleado emp;

    public TarjetaDeTiempo(Date fechaTarjeta, int idOrden, int id, String dui, Double salHora, Double salHoraExtra) {
        this.fechaTarjeta = fechaTarjeta;
        this.idOrden = idOrden;
        this.id = id;
        this.dui=dui;
        this.salHora = salHora;
        this.salHoraExtra = salHoraExtra;
    }

    public TarjetaDeTiempo() {
    }
     public TarjetaDeTiempo(Double salHora) {
        this.salHora = salHora;
    }

    public Double getSalHoraExtra() {
        return salHoraExtra;
    }

    public void setSalHoraExtra(Double salHoraExtra) {
        this.salHoraExtra = salHoraExtra;
    }

    public Double getSalHora() {
        return salHora;
    }

    public void setSalHora(Double salHora) {
        this.salHora = salHora;
    }

    public List<DetalleTarjetaDeTiempo> getDetalle() {
        return detalle;
    }

    public void ae(List<DetalleTarjetaDeTiempo> detalle) {
        this.detalle = detalle;
    }

    public Date getFechaTarjeta() {
        return fechaTarjeta;
    }

    public void setFechaTarjeta(Date fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getTotalHorasTrabajadas() {
        return totalHorasTrabajadas;
    }

    public void setTotalHorasTrabajadas(int totalHorasTrabajadas) {
        this.totalHorasTrabajadas = totalHorasTrabajadas;
    }

    public int getTotalHorasExtras() {
        return totalHorasExtras;
    }

    public void setTotalHorasExtras(int totalHorasExtras) {
        this.totalHorasExtras = totalHorasExtras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int calcularHoras() {
        Iterator<DetalleTarjetaDeTiempo> i = detalle.iterator();
        int horas = 0;

        while (i.hasNext()) {
            DetalleTarjetaDeTiempo d = i.next();
            horas += d.getHorasTrabajadas();
        }
        return horas;
    }

    public int calcularHorasExtras() {
        Iterator<DetalleTarjetaDeTiempo> i = detalle.iterator();
        int horas = 0;

        while (i.hasNext()) {
            DetalleTarjetaDeTiempo d = i.next();
            horas += d.getHorasExtras();
        }
        return horas;
    }

    public Double SalHorasExtras() {
        Double salExtra = calcularHorasExtras() * salHoraExtra;
        return salExtra;
    }

    public Double SalHoras() {
        Double salHoras = calcularHoras() * salHora;
        return salHoras;
    }

    public Double salHoja() {
        return SalHoras() + SalHorasExtras();
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setDetalle(List<DetalleTarjetaDeTiempo> detalle) {
        this.detalle = detalle;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
    
}    