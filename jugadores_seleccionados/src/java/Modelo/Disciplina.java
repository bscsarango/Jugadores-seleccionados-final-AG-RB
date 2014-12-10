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
public class Disciplina {
    private String alimentacion;
    private String entrenamiento;

    public Disciplina() {
    }
    

    public Disciplina(String alimentacion, String entrenamiento) {
        this.alimentacion = alimentacion;
        this.entrenamiento = entrenamiento;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(String entrenamiento) {
        this.entrenamiento = entrenamiento;
    }
    
    
}
