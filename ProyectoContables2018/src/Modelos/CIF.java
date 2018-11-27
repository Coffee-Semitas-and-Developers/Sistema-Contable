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
public class CIF {
    private int idCosto;
    private String nombreCosto;
    private float tasaEstimada;
    private double monto; 

    public CIF(int idCosto, String nombreCosto, float tasaEstimada, double monto) {
        this.idCosto = idCosto;
        this.nombreCosto = nombreCosto;
        this.tasaEstimada = tasaEstimada;
        this.monto = monto;
    }

    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    public String getNombreCosto() {
        return nombreCosto;
    }

    public void setNombreCosto(String nombreCosto) {
        this.nombreCosto = nombreCosto;
    }

    public float getTasaEstimada() {
        return tasaEstimada;
    }

    public void setTasaEstimada(float tasaEstimada) {
        this.tasaEstimada = tasaEstimada;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
