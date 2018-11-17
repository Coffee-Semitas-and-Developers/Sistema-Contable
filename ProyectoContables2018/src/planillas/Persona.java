/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planillas;

/**
 *
 * @author jorge
 */
public class Persona {
    public Persona(){
        
    }

    public Persona(String dui, String nombres, String apellidos, String tel, int edad) {
        this.dui = dui;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tel = tel;
        this.edad = edad;
    }
    
    private String dui,nombres,apellidos,tel;
    private int edad;

    

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
