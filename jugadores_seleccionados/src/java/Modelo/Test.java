/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.RedBayesiana.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
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


public class Test {
    private Configuration conf;
    private FitnessFunctionJugador ffa;
    public Jugador jugadoor= new Jugador();
    public List jugador= new ArrayList();
    public List posicion = new ArrayList();
    public static final int MAX_ALLOWED_EVOLUTIONS =1500;
    private Chromosome jugadorChromosome=null;
    String presentacion="";
      public Test() {
    }
    
         public String d1="",d2="",d3="",d4="",d5="",d6="",d7="",d8="",d9="",d10="",d11="",d12="";

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public String getD4() {
        return d4;
    }

    public void setD4(String d4) {
        this.d4 = d4;
    }

    public String getD5() {
        return d5;
    }

    public void setD5(String d5) {
        this.d5 = d5;
    }

    public String getD6() {
        return d6;
    }

    public void setD6(String d6) {
        this.d6 = d6;
    }

    public String getD7() {
        return d7;
    }

    public void setD7(String d7) {
        this.d7 = d7;
    }

    public String getD8() {
        return d8;
    }

    public void setD8(String d8) {
        this.d8 = d8;
    }

    public String getD9() {
        return d9;
    }

    public void setD9(String d9) {
        this.d9 = d9;
    }

    public String getD10() {
        return d10;
    }

    public void setD10(String d10) {
        this.d10 = d10;
    }

    public String getD11() {
        return d11;
    }

    public void setD11(String d11) {
        this.d11 = d11;
    }

    public String getD12() {
        return d12;
    }

    public void setD12(String d12) {
        this.d12 = d12;
    }

    public Jugador getJu() {
        return ju;
    }

    public void setJu(Jugador ju) {
        this.ju = ju;
    }
  
    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
      public   boolean ver=false;

    public boolean isVer() {
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }
  
    public void iniciar(String tipoPosicion)throws Exception{
        StringTokenizer st= new StringTokenizer(tipoPosicion);
        while (st.hasMoreElements()) {
            String desp = st.nextToken();
            posicion.add(desp);
        }
        
        jugador=jugadoor.cargarJugadores();
        conf= new DefaultConfiguration();
        conf.setPreservFittestIndividual(true);
        conf.setPopulationSize(1000);
        conf.setKeepPopulationSizeConstant(false);
        
       ffa=new FitnessFunctionJugador(jugador, posicion);
       conf.setFitnessFunction(ffa);
       
       Gene[] aniGene=new Gene[1];
       aniGene[0]=new IntegerGene(conf, 0, jugador.size()-1);
//       aniGene[1]=new IntegerGene(conf, 0, jugador.size()-1);
       jugadorChromosome = new Chromosome(conf, aniGene);
       aniGene[0].setAllele(new Integer(0));
//       aniGene[1].setAllele(new Integer(1));
       
       conf.setSampleChromosome(jugadorChromosome);
       
    }    

        public void seleccionar() throws InvalidConfigurationException{
        jugador=jugadoor.cargarJugadores();
        Genotype poblacion=Genotype.randomInitialGenotype(conf);
       IChromosome mejorSolucion=jugadorChromosome;
        
        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            poblacion.evolve();
            IChromosome mejorCandidato=poblacion.getFittestChromosome();
            
            if (mejorCandidato.getFitnessValue()>mejorSolucion.getFitnessValue()) {
                mejorSolucion=mejorCandidato;
            }
        }
        
         presentar(mejorSolucion, jugador);
            ver=true;
        }
   

        
        Jugador ju = new Jugador();
    public void presentar(IChromosome solucion, List an){
       setPresentacion("");
        System.out.println("---**--**RESPUESTA**--**--");
        System.out.println("Valor de Fitness: "+solucion.getFitnessValue());
        
        for (int i = 0; i < solucion.size(); i++) {
            int index= (Integer)solucion.getGene(i).getAllele();
            ju=(Jugador)an.get(index);
            System.out.println(ju.toString());
            setPresentacion(getPresentacion()+"//"+ju.toString());
        }
        
        setD1(ju.getRendimiento().getSalto());
      //  System.out.println("pilaS: "+getD1());
        setD2(ju.getRendimiento().getVelocidad());
        System.out.println("d22:  "+getD1());
        
      d3=ju.getRendimiento().getCapacidadPulmonar();
      d4=ju.getRendimiento().getPotencia();
      d5=ju.getRendimiento().getResistencia();
      
      d6=ju.getDisciplina().getAlimentacion();
      d7=ju.getDisciplina().getEntrenamiento();
      
      d9=ju.getHabilidades().getRegate();
      d10=ju.getHabilidades().getPaseCorto();
      d11=ju.getHabilidades().getCapacidadReaccion();
      d12=ju.getHabilidades().getPaseLargo();
        conf.reset();
    }
    //Jugador jugador = new Jugador();
//    String aa="";
//    public String getAa() {
//        return aa;
//    }
//    public void setAa(String aa) {
//        this.aa = aa;
//    }
//    public void leer() throws FileNotFoundException, ParserException, NodeNotFoundException, ProbNodeNotFoundException, NotEvaluableNetworkException, UnexpectedInferenceException {
//        try {
//            //abrir archivo
//            InputStream file = new FileInputStream(new File("D:\\BORYS\\9MODULO\\Sistemas inteligentes\\Redes B grupal\\final\\Jugadores.pgmx"));
//            //cargar la red bayesania
//            PGMXReader leer = new PGMXReader();
//            //Obtener las probabilidades de la red bayesiana
//            ProbNet lpro = leer.loadProbNet(file, bayesNetWorkName).getProbNet();
//            List<ProbNode> lista = lpro.getProbNodes();
//            for (int i = 0; i < lista.size(); i++) {
//                ProbNode pn = lista.get(i);
//                System.out.println(pn.getName());
//            }
//               System.out.println(lpro.getChanceAndDecisionVariables());
//               System.out.println("--*---*---*");
//            EvidenceCase evidence = new EvidenceCase();
//            //se introduce la presencia del estado y si pasa o no
//            evidence.addFinding(lpro, "Salto", d1);
//            evidence.addFinding(lpro, "Velocidad", getD2());
//            evidence.addFinding(lpro, "capacidad_pulmonar",getD3());
//            evidence.addFinding(lpro, "potencia", getD4());
//            evidence.addFinding(lpro, "resistencia", getD5());
//            
//            evidence.addFinding(lpro, "Alimentacion", getD6());
//            evidence.addFinding(lpro, "Entrenamiento", getD7());
//            evidence.addFinding(lpro, "partidos", "si");
//            
//            evidence.addFinding(lpro, "regate", getD9());
//            evidence.addFinding(lpro, "paseCorto", getD10());
//            evidence.addFinding(lpro, "capacidadReaccion", getD11());
//            evidence.addFinding(lpro, "paseLargo", getD12());
//            InferenceAlgorithm variableElimination = new VariableElimination(lpro);
//            variableElimination.setPreResolutionEvidence(evidence);
//           Variable estado = lpro.getVariable("Habilidades");
//           Variable estado2 = lpro.getVariable("Seleccionado");
//            ArrayList<Variable> variablesOfInterest = new ArrayList<Variable>();
//            //variablesOfInterest.add(disease1);
//            variablesOfInterest.add(estado);
//            variablesOfInterest.add(estado2);
//          //  variablesOfInterest.add(estado3);
//            // Calcular las probabilidades posteriores
//            HashMap<Variable, TablePotential> posteriorProbabilities = variableElimination.getProbsAndUtilities();
//            printResults(evidence, variablesOfInterest, posteriorProbabilities);
//
//        } catch (InvalidStateException ex) {
//            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IncompatibleEvidenceException ex) {
//            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public void printResults(EvidenceCase evidence, ArrayList<Variable> variablesOfInterest,HashMap<Variable, TablePotential> posteriorProbabilities) {
//        System.out.println("Evidencia:");
//        for (Finding finding : evidence.getFindings()) {
//            System.out.print("1:  " + finding.getVariable() + ": ");
//            s.add(String.valueOf(finding.getVariable()));
//            s.add(finding.getState());
//            setAa(getAa()+"Evidencia. "+finding.getState()+"\n");
//            System.out.println(finding.getState());
//        }
//        System.out.println("Probabilidade posteriores: ");
//        for (Variable variable : variablesOfInterest) {
//            double value;
//            TablePotential posteriorProbabilitiesPotential = posteriorProbabilities.get(variable);
//            System.out.print(" 2:  " + variable + ": ");
//            setAa(getAa()+ variable + ": ");
//            int stateIndex = -1;
//            try {
//                stateIndex = variable.getStateIndex("si");
//                value = posteriorProbabilitiesPotential.values[stateIndex];
//                s.add(String.valueOf(Util.roundedString(value, "0.0001")));
//                System.out.println(Util.roundedString(value, "0.00001"));
//                setAa(getAa()+Util.roundedString(value, "0.00001"));
//            } catch (InvalidStateException e) {
//                System.err.println("State \"......\" not found for variable \""
//                        + variable.getName() + "\".");
//                e.printStackTrace();
//            }
//        }
//        
//    }
    
}
