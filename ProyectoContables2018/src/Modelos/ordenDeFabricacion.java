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
/**
 *
 * @author AxlHrndz
 */
public class ordenDeFabricacion {
    private int idOrden;
    private String especificaciones;
    private Date fechaExpedicion;
    private Date fechaRequerida;
    private boolean terminada;
    private Date iniciado;
    private Date terminado;
    private double costoTotal;
    private int unidadesProducidas;
    private TarjetaDeTiempo tarjeta = new TarjetaDeTiempo();
    private Kardex kardex = new Kardex();

    public ordenDeFabricacion() {
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaRequerida() {
        return fechaRequerida;
    }

    public void setFechaRequerida(Date fechaRequerida) {
        this.fechaRequerida = fechaRequerida;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public Date getIniciado() {
        return iniciado;
    }

    public void setIniciado(Date iniciado) {
        this.iniciado = iniciado;
    }

    public Date getTerminado() {
        return terminado;
    }

    public void setTerminado(Date terminado) {
        this.terminado = terminado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getUnidadesProducidas() {
        return unidadesProducidas;
    }

    public void setUnidadesProducidas(int unidadesProducidas) {
        this.unidadesProducidas = unidadesProducidas;
    }

    public TarjetaDeTiempo getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDeTiempo tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }
    
    
}
