/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author user
 */
public class Rendimiento {
    private String Resistencia="";
    private String Potencia="";
    private String CapacidadPulmonar="";
    private String velocidad="";
    private String Salto="";

    public Rendimiento(String Resistencia, String Potencia, String CapacidadPulmonar, String velocidad, String Salto) {
        this.Resistencia = Resistencia;
        this.Potencia = Potencia;
        this.CapacidadPulmonar = CapacidadPulmonar;
        this.velocidad = velocidad;
        this.Salto = Salto;
    }

    public Rendimiento() {

    }
    

    public String getPotencia() {
        return Potencia;
    }

    public void setPotencia(String Potencia) {
        this.Potencia = Potencia;
    }

    public String getCapacidadPulmonar() {
        return CapacidadPulmonar;
    }

    public void setCapacidadPulmonar(String CapacidadPulmonar) {
        this.CapacidadPulmonar = CapacidadPulmonar;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getSalto() {
        return Salto;
    }

    public void setSalto(String Salto) {
        this.Salto = Salto;
    }

    
    public String getResistencia() {
        return Resistencia;
    }

    public void setResistencia(String Resistencia) {
        this.Resistencia = Resistencia;
    }

  
   }
