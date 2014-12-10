/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Bean.BeanJugador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.InvalidConfigurationException;
import org.openmarkov.core.exception.IncompatibleEvidenceException;
import org.openmarkov.core.exception.InvalidStateException;
import org.openmarkov.core.exception.NodeNotFoundException;
import org.openmarkov.core.exception.NotEvaluableNetworkException;
import org.openmarkov.core.exception.ParserException;
import org.openmarkov.core.exception.ProbNodeNotFoundException;
import org.openmarkov.core.exception.UnexpectedInferenceException;
import org.openmarkov.core.inference.InferenceAlgorithm;
import org.openmarkov.core.model.network.EvidenceCase;
import org.openmarkov.core.model.network.Finding;
import org.openmarkov.core.model.network.ProbNet;
import org.openmarkov.core.model.network.ProbNode;
import org.openmarkov.core.model.network.Util;
import org.openmarkov.core.model.network.Variable;
import org.openmarkov.core.model.network.potential.TablePotential;
import org.openmarkov.inference.variableElimination.VariableElimination;
import org.openmarkov.io.probmodel.PGMXReader;

/**
 *
 * @author barcelona
 */
public class RedBayesiana {
    final private String bayesNetWorkName = "Jugadores.pgmx";
    final public static List<String> s = new ArrayList<String>();
   Test test = new Test();
   BeanJugador bj = new BeanJugador();
    public RedBayesiana()  {
        try {
            test.iniciar(bj.getOpcion());test.seleccionar();
        } catch (Exception ex) {
            Logger.getLogger(RedBayesiana.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
   String aa="";
    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }


    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    //Jugador jugador = new Jugador();
    public String leer() throws FileNotFoundException, ParserException, NodeNotFoundException, ProbNodeNotFoundException, NotEvaluableNetworkException, UnexpectedInferenceException {
        try {
            //abrir archivo
                      InputStream file = new FileInputStream(new File("D:\\BORYS\\9MODULO\\Sistemas inteligentes\\Redes B grupal\\final\\Jugadores.pgmx"));
            //cargar la red bayesania
            PGMXReader leer = new PGMXReader();
            //Obtener las probabilidades de la red bayesiana
            ProbNet lpro = leer.loadProbNet(file, bayesNetWorkName).getProbNet();
            List<ProbNode> lista = lpro.getProbNodes();
            for (int i = 0; i < lista.size(); i++) {
                ProbNode pn = lista.get(i);
                System.out.println(pn.getName());
            }
               System.out.println(lpro.getChanceAndDecisionVariables());
               System.out.println("--*---*---*");
               

            EvidenceCase evidence = new EvidenceCase();

            //se introduce la presencia del estado y si pasa o no
            
            System.out.println("getid: "+getTest().getD1());
            evidence.addFinding(lpro, "Salto", getTest().getD1());
            evidence.addFinding(lpro, "Velocidad", test.getD2());
            evidence.addFinding(lpro, "capacidad_pulmonar", test.getD3());
            evidence.addFinding(lpro, "potencia", test.getD4());
            evidence.addFinding(lpro, "resistencia", test.getD5());
            
            evidence.addFinding(lpro, "Alimentacion", test.getD6());
            evidence.addFinding(lpro, "Entrenamiento", test.getD7());
            evidence.addFinding(lpro, "partidos", "si");
            
            evidence.addFinding(lpro, "regate", test.getD9());
            evidence.addFinding(lpro, "paseCorto", test.getD10());
            evidence.addFinding(lpro, "capacidadReaccion", test.getD11());
            evidence.addFinding(lpro, "paseLargo", test.getD12());
//            
            
            
           InferenceAlgorithm variableElimination = new VariableElimination(lpro);
            variableElimination.setPreResolutionEvidence(evidence);
           //Variable estado2 = lpro.getVariable("Habilidades");
           Variable estado = lpro.getVariable("Seleccionado");
            ArrayList<Variable> variablesOfInterest = new ArrayList<Variable>();
            //variablesOfInterest.add(disease1);
            variablesOfInterest.add(estado);
            //variablesOfInterest.add(estado2);
          //  variablesOfInterest.add(estado3);

            // Calcular las probabilidades posteriores
            HashMap<Variable, TablePotential> posteriorProbabilities = variableElimination.getProbsAndUtilities();

            printResults(evidence, variablesOfInterest, posteriorProbabilities);

        } catch (InvalidStateException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IncompatibleEvidenceException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redesB.xhtml";

    }

    public void printResults(EvidenceCase evidence, ArrayList<Variable> variablesOfInterest,HashMap<Variable, TablePotential> posteriorProbabilities) {
        System.out.println("Evidencia:");
        for (Finding finding : evidence.getFindings()) {
            System.out.print("1:  " + finding.getVariable() + ": ");
            s.add(String.valueOf(finding.getVariable()));
            s.add(finding.getState());
            setAa(getAa()+"Evidencia. "+finding.getState()+"\n");
            System.out.println(finding.getState());
        }
        System.out.println("Probabilidade posteriores: ");
        for (Variable variable : variablesOfInterest) {
            double value;
            TablePotential posteriorProbabilitiesPotential = posteriorProbabilities.get(variable);
            System.out.print(" 2:  " + variable + ": ");
            setAa(getAa()+ variable + ": ");
            int stateIndex = -1;
            try {
                stateIndex = variable.getStateIndex("si");
                value = posteriorProbabilitiesPotential.values[stateIndex];
                s.add(String.valueOf(Util.roundedString(value, "0.0001")));
                System.out.println(Util.roundedString(value, "0.00001"));
                setAa(getAa()+Util.roundedString(value, "0.00001"));
            } catch (InvalidStateException e) {
                System.err.println("State \"......\" not found for variable \""
                        + variable.getName() + "\".");
                e.printStackTrace();
            }
        }
    }
}
