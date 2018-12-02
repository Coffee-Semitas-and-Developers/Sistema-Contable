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
public class materiaPrima {

    private int codigoMateria;
    private String nombreMateria;
    private boolean directa;
    private String descripcionMateria;
    private int cantidadmateria;
    private String unidadesMateria;
    private double precioAdquisicion;
        
    public materiaPrima() {
    }

    public int getCantidadmateria() {
        return cantidadmateria;
    }

    public void setCantidadmateria(int cantidadmateria) {
        this.cantidadmateria = cantidadmateria;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public boolean isDirecta() {
        return directa;
    }

    public void setDirecta(boolean directa) {
        this.directa = directa;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public String getUnidadesMateria() {
        return unidadesMateria;
    }

    public void setUnidadesMateria(String unidadesMateria) {
        this.unidadesMateria = unidadesMateria;
    }

    public double getPrecioAdquisicion() {
        return precioAdquisicion;
    }

    public void setPrecioAdquisicion(double precioAdquisicion) {
        this.precioAdquisicion = precioAdquisicion;
    }

}
