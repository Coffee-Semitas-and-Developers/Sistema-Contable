/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planillas;
import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
        
/**
 *
 * @author jorge
 */
public class LineaPlanilla {
    private Empleado emp;
    private double salarioReal;
    private List<Extra> extras= new ArrayList <Extra>();

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
    
    public void addExtra(Extra e){
        this.extras.add(e);
    }
    
    
}
    
            
