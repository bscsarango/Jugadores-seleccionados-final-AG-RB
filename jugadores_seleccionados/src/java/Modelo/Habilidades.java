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
public class Habilidades {
    private String regate;
    private String paseLargo;
    private String paseCorto;
    private String capacidadReaccion;
    

    public Habilidades() {
    }

    public Habilidades(String regate, String paseLargo, String paseCorto, String capacidadReaccion) {
        this.regate = regate;
        this.paseLargo = paseLargo;
        this.paseCorto = paseCorto;
        this.capacidadReaccion = capacidadReaccion;
    }

    public String getRegate() {
        return regate;
    }

    public void setRegate(String regate) {
        this.regate = regate;
    }

    public String getPaseLargo() {
        return paseLargo;
    }

    public void setPaseLargo(String paseLargo) {
        this.paseLargo = paseLargo;
    }

    public String getPaseCorto() {
        return paseCorto;
    }

    public void setPaseCorto(String paseCorto) {
        this.paseCorto = paseCorto;
    }

    public String getCapacidadReaccion() {
        return capacidadReaccion;
    }

    public void setCapacidadReaccion(String capacidadReaccion) {
        this.capacidadReaccion = capacidadReaccion;
    }
    
    
}
