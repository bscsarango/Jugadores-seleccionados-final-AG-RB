/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.jgap.InvalidConfigurationException;

/**
 *
 * @author user
 */
public class ejecucion {
    public static void main(String[] args) throws InvalidConfigurationException, Exception {
        Test t= new Test();
        RedBayesiana red = new RedBayesiana();
        Jugador j = new Jugador();
        System.out.println("===============ALGORITMO==================");
        System.out.println("los porteros son");
                //System.out.println("jbc"+j.cargarJugadores());
                t.iniciar("portero");
                t.seleccionar();
                System.out.println("*********************REDES BAYESIANAS***************");
                red.leer();
    }
       
    
}
