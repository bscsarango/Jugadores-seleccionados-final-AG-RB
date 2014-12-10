/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author katica
 */
public class FitnessFunctionJugador extends FitnessFunction{
    List ani= new ArrayList();
    List posici= new ArrayList();

    public FitnessFunctionJugador(List jugador, List des) {
        this.ani= jugador;
        this.posici=des;
    }
    
    @Override
    protected double evaluate(IChromosome ic) {
        double score=0;
        double imdbScore=0;
        
        List a= new ArrayList();
        int mala=1;
        
        for (int i = 0; i < ic.size(); i++) {
            IntegerGene agene = (IntegerGene)ic.getGene(i);
            int index = (Integer)ic.getGene(i).getAllele();
            
            if (a.contains(index)) {
                mala=0;
            }else{
                a.add(index);
            }
            
            Jugador juga= (Jugador)ani.get(index);
            double desScore = getDesScore(juga);
            if (desScore==0) {
                mala=0;
            }
            score =(score+juga.getPartidos()+(desScore));
        }
        return  (score*mala);
    }
    
    private double getDesScore(Jugador an){
        double desScore=0;
        Iterator it= this.posici.iterator();
        
        
        while (it.hasNext()) {
            String des = (String)it.next();
            if (an.getPosicion().contains(des)) {
                desScore=desScore+1;
            }
        }
        return desScore;
    }
}
