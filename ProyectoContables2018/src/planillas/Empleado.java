/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planillas;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class Empleado extends Persona{
    private String cargo,departamento;
    private Date fechaContrato,fechaDespido;
    private boolean estado;
    private double salario;
    public Empleado(){
        
    }
    
    public Empleado(String cargo, String departamento, Date fechaContrato, Date fechaDespido, boolean estado, double salario,  String dui, String nombres, String apellidos, String tel, int edad) {
        super(dui, nombres, apellidos, tel, edad);
        this.cargo = cargo;
        this.departamento = departamento;
        this.fechaContrato = fechaContrato;
        this.fechaDespido = fechaDespido;
        this.estado = estado;
        this.salario = salario;
    }
  
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }  
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Date getFechaDespido() {
        return fechaDespido;
    }

    public void setFechaDespido(Date fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
