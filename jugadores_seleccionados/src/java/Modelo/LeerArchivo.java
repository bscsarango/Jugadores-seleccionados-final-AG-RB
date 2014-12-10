/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author user
 */
public class LeerArchivo {

    final private String bayesNetWorkName = "Jugadores.pgmx";
    final public static List<String> s = new ArrayList<String>();

    public void leer() throws FileNotFoundException, ParserException, NodeNotFoundException, ProbNodeNotFoundException, NotEvaluableNetworkException, UnexpectedInferenceException {
        try {
            //abrir archivo
            InputStream file = new FileInputStream(new File("C:\\Users\\user\\Documents\\katy\\Noveno\\Sist_Inteligentes\\redes_bayesianas\\Jugadores.pgmx"));
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
            evidence.addFinding(lpro, "Rendimiento_Fisico", "bajo");
            InferenceAlgorithm variableElimination = new VariableElimination(lpro);
            variableElimination.setPreResolutionEvidence(evidence);
            Variable estado = lpro.getVariable("Seleccionado");
            ArrayList<Variable> variablesOfInterest = new ArrayList<Variable>();
            //variablesOfInterest.add(disease1);
            variablesOfInterest.add(estado);

            // Calcular las probabilidades posteriores
            HashMap<Variable, TablePotential> posteriorProbabilities = variableElimination.getProbsAndUtilities();

            printResults(evidence, variablesOfInterest, posteriorProbabilities);

        } catch (InvalidStateException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IncompatibleEvidenceException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void printResults(EvidenceCase evidence, ArrayList<Variable> variablesOfInterest,
            HashMap<Variable, TablePotential> posteriorProbabilities) {
        System.out.println("Evidencia:");
        for (Finding finding : evidence.getFindings()) {
            System.out.print("1:  " + finding.getVariable() + ": ");
            s.add(String.valueOf(finding.getVariable()));
            s.add(finding.getState());
            System.out.println(finding.getState());
        }
        System.out.println("Probabilidade posteriores: ");
        for (Variable variable : variablesOfInterest) {
            double value;
            TablePotential posteriorProbabilitiesPotential = posteriorProbabilities.get(variable);
            System.out.print(" 2:  " + variable + ": ");
            int stateIndex = -1;
            try {
                stateIndex = variable.getStateIndex("no");
                value = posteriorProbabilitiesPotential.values[stateIndex];
                s.add(String.valueOf(Util.roundedString(value, "0.0001")));
                System.out.println(Util.roundedString(value, "0.00001"));
            } catch (InvalidStateException e) {
                System.err.println("State \"present\" not found for variable \""
                        + variable.getName() + "\".");
                e.printStackTrace();
            }
        }
    }

}
