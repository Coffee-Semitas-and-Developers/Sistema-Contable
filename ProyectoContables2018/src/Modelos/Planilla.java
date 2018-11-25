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
 * @author jorge
 */
public class Planilla {
    private Date fechaPago;
    /*Tipo Empleado,Patrono
    ocasion: mesual,vacaciones, aguinaldo
      */ 
    private String tipo,ocasion;
    private List <LineaPlanilla> listPlanilla = new ArrayList<LineaPlanilla>();

    public Planilla(Date fechaPago, String tipo, String ocasion) {
        this.fechaPago = fechaPago;
        this.tipo = tipo;
        this.ocasion = ocasion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public List<LineaPlanilla> getListPlanilla() {
        return listPlanilla;
    }

    public void setListPlanilla(List<LineaPlanilla> listPlanilla) {
        this.listPlanilla = listPlanilla;
    }
    
    
}
