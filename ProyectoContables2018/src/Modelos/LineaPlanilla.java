/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
        
/**
 *
 * @author jorge
 */
public class LineaPlanilla {
 

    private Boolean selected = false;

    public Boolean isSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    private Empleado emp;
    private double salarioReal;
    public List<Extra> extras = new ArrayList<Extra>();

    public LineaPlanilla() {
    }

    public LineaPlanilla(Empleado emp) {
        this.emp = emp;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public double getSalarioReal() {
        return salarioReal;
    }

    public void setSalarioReal(double salarioReal) {
        this.salarioReal = salarioReal;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public void addExtra(Extra e) {
        this.extras.add(e);
    }

    public double totalDescuento() {
        Iterator<Extra> i = extras.iterator();
        double desc = 0;

        while (i.hasNext()) {
            Extra e = i.next();
            if (!(e.isEstado()) || !(e.getDescrip() == "AFP") || !(e.getDescrip() == "ISSS") || !(e.getDescrip() == "Renta")) {
                desc += e.getMonto();
            }
        }
        return desc;
    }

    public double totalBonificacion() {
        Iterator<Extra> i = extras.iterator();
        double boni = 0;

        while (i.hasNext()) {
            Extra e = i.next();
            if (e.isEstado()) {
                boni += e.getMonto();
            }
        }
        return boni;
    }

    public double calcSalarioReal() {
        double salReal;
        salReal = emp.calcularSalario() + totalBonificacion() - totalDescuento();
        return salReal;
    }

    public double calcISSS(int tipo) {
        double isss = 0;
        
        if(tipo==0){
            if(emp.calcularSalario()<=1000){
                isss=emp.calcularSalario()*0.03;
            }else if(emp.calcularSalario()>1000){
            isss=30.0;
            }        
         Extra e = new Extra(false,"ISSS",3.0,isss);   
            extras.add(e);
        }else{
            if(emp.calcularSalario()<=1000){
                isss=emp.calcularSalario()*0.075;
            }else if(emp.calcularSalario()>1000){
            isss=75.0;
            }        
         Extra e = new Extra(false,"ISSS Patrono",7.5,isss);   
            extras.add(e);
        }
        
        return isss;
    }

    public double calcAFP(int tipo) {
        double afp = 0;

        if (tipo == 0) {
            if (emp.calcularSalario() <= 6500) {
                afp = emp.calcularSalario() * 0.0725;
            } else if (emp.calcularSalario() > 6500) {
                afp = 500 * 0.0725;
            }
            Extra e = new Extra(false, "AFP", 7.25, afp);
            extras.add(e);
        } else {
            if (emp.calcularSalario() <= 6500) {
                afp = emp.calcularSalario() * 0.0775;
            } else if (emp.calcularSalario() > 6500) {
                afp = 6500 * 0.0775;
            }
            Extra e = new Extra(false, "AFP Patrono", 7.5, afp);
            extras.add(e);
        }

        return afp;
    }
   final double isssEmpleado=0.03,isssPatrono=0.075,afpEmpleado=0.0725,afpPatrono=0.0775,tramoII=472.00,cuotaTramoII=17.67,pTramoII=0.10,tramoIII=895.24,cuotaTramoIII=60,pTramoIII=0.2,tramoIV=2038.10,pTramoIV=0.3,cuotaTramoIV=288.57;


    
    public double calcRenta() {
        double  base = 0.0;
        double renta=0.0;
        base = emp.calcularSalario() - (calcISSS(0) + calcAFP(0));

        if(base<tramoII){
            renta=0;
        }
        if(base>tramoII && base<tramoIII){
            renta= (base-tramoII)*pTramoII+cuotaTramoII;
        }
        if(base>tramoIII&&base<tramoIV){
            renta= (base-tramoIII)*pTramoIII+cuotaTramoIII;
        }    
       if(base>tramoIV){
            renta= (base-tramoIV)*pTramoIV+cuotaTramoIV;
        }  
        return renta;
    }

}
    
            
