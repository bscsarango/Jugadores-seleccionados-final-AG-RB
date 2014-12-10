/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author user
 */
public class Jugador {

    private String nombre;
    private String Edad;
    private String Posicion;
    private Rendimiento rendimiento = new Rendimiento();
    private Disciplina disciplina = new Disciplina();
    private Habilidades habilidades = new Habilidades();
    private double partidos;


   
    
    public Jugador() {
rendimiento = new Rendimiento();
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Jugador(String nombre, String Edad, String Posicion, Rendimiento rendimiento, Disciplina disciplina, Habilidades habilidades, double partidos) {
        this.nombre = nombre;
        this.Edad = Edad;
        this.Posicion = Posicion;
        this.rendimiento = rendimiento;
        this.disciplina = disciplina;
        this.habilidades = habilidades;
        this.partidos = partidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public Rendimiento getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Rendimiento rendimiento) {
        this.rendimiento = rendimiento;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Habilidades getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidades habilidades) {
        this.habilidades = habilidades;
    }

    public double getPartidos() {
        return partidos;
    }

    public void setPartidos(double partidos) {
        this.partidos = partidos;
    }

   ////       public String presentar(String s) {
////        comparar(s);
////        return s;
////    }
public List cargarJugadores(){
        List list= new ArrayList();
        Habilidades h1= new Habilidades("bueno", "si","si", "positivo");
        Habilidades h2= new Habilidades("mala", "si","no", "positiva");
        Habilidades h3= new Habilidades("malo", "no","si", "negativo");
        Habilidades h4= new Habilidades("malo", "no","no", "posiivo");
       
                                    //regate paseL paseC Reaccion
        Habilidades h5= new Habilidades("bueno", "si","si", "positivo");
        Habilidades h6= new Habilidades("malo", "no","si", "positivo");
        Habilidades h7= new Habilidades("malo", "si","si", "negativo");
        Habilidades h8= new Habilidades("bueno", "si","si", "positivo");
        
        Habilidades h9= new Habilidades("bueno", "si","si", "positivo");
        Habilidades h10= new Habilidades("malo", "si","si", "negativo");
        Habilidades h11= new Habilidades("bueno", "no","si", "positivo");
        Habilidades h12= new Habilidades("malo", "no","si", "positivo");
        
        Habilidades h13= new Habilidades("bueno", "no","si", "positivo");
        Habilidades h14= new Habilidades("malo", "no","si",  "positivo");
        Habilidades h15= new Habilidades("bueno", "no","si", "positivo");
        Habilidades h16= new Habilidades("bueno", "si","si", "positivo");
        
                                        //alimentacion entrena
        Disciplina d1= new Disciplina("buena", "leve");
        Disciplina d2= new Disciplina("bueno", "bueno");
        Disciplina d3= new Disciplina("mala", "leve");
        Disciplina d4= new Disciplina("regular", "ausente");
        Disciplina d5= new Disciplina("mala", "leve");
        Disciplina d6= new Disciplina("regular", "ausente");
        Disciplina d7= new Disciplina("buena", "leve");
        Disciplina d8= new Disciplina("mala", "leve");
        Disciplina d9= new Disciplina("regular", "leve");
        Disciplina d10= new Disciplina("buena", "ausente");
        Disciplina d11= new Disciplina("regular", "leve");
        Disciplina d12= new Disciplina("buena", "leve");
        Disciplina d13= new Disciplina("buena", "leve");
        Disciplina d14= new Disciplina("mala", "leve");
        Disciplina d15= new Disciplina("regular", "leve");
        Disciplina d16= new Disciplina("buena", "leve");
        
        Rendimiento r1= new Rendimiento("positiva", "negativa", "buena", "alto", "bajo");
        Rendimiento r2= new Rendimiento("positiva", "positiva", "mala", "bajo", "alto");
        Rendimiento r3= new Rendimiento("positiva", "negativa", "buena", "medio", "medio");
        Rendimiento r4= new Rendimiento("positiva", "positiva", "mala", "medio" , "medio" );
        
        Rendimiento r5= new Rendimiento("positiva", "negativa", "buena", "alto", "alto");
        Rendimiento r6= new Rendimiento("negativa", "negativa", "regular", "medio", "medio" );
        Rendimiento r7= new Rendimiento("positiva", "negativa", "buena", "bajo", "medio");
        Rendimiento r8= new Rendimiento("negativa", "positiva", "mala", "alto" , "alto" );
        
        Rendimiento r9= new Rendimiento("positiva", "positiva", "buena" , "media", "alto");
        Rendimiento r10= new Rendimiento("positiva", "positiva","positiva", "bajo","medio" );
        Rendimiento r11= new Rendimiento("positiva", "positiva","positiva", "alto","medio" );
        Rendimiento r12= new Rendimiento("positiva", "positiva","positiva", "bajo","medio" );
        
                                        //(resist,    pot,      pulm     Veldad    Salto)
        Rendimiento r13= new Rendimiento("positiva", "positiva", "positiva", "alto", "alto");
        Rendimiento r14= new Rendimiento("positiva", "positiva","positiva", "bajo","alto" );
        Rendimiento r15= new Rendimiento("positiva", "positiva","positiva", "alto","medio" );
        Rendimiento r16= new Rendimiento("positiva", "positiva","positiva", "medio","medio" );
        
        Jugador j1= new Jugador("Maximo_Manguera", "27", "portero", r1, d1, h1, 25);
        Jugador j2= new Jugador("Alexander_Dominguez", "25","portero",r2,d2,h2, 31);
        Jugador j3= new Jugador("Adrian_Bone", "24",  "portero", r3, d3, h3, 8);
        Jugador j4= new Jugador("Damian_lanza","28","portero",r4,d4,h4,21);
        
        Jugador j5= new Jugador("Friczon_Erazo","26","defensa",r5,d5,h5,26);
        Jugador j6= new Jugador("Gabriel_Achiller","28","defensa",r6,d6,h6,25);
        Jugador j7= new Jugador("Jorge_guagua","32","defensa",r7,d7,h7,20);
        Jugador j8= new Jugador("Luis_Canga","20","defensa",r8,d8,h8,2);
        
        Jugador j9= new Jugador("Cristian Noboa","28","volante",r9,d9,h9,55);
        Jugador j10= new Jugador("Pedro Quiñonez ","27","volante",r10,d10,h10,20);
        Jugador j11= new Jugador("Antonio Valencia","28","volante",r11,d11,h11,61);
        Jugador j12= new Jugador("Carlos_Grueso","20","volante",r12,d12,h12,4);
        
        Jugador j13= new Jugador("Enner Valencia","24","delantero",r13,d13,h13,22);
        Jugador j14= new Jugador("Felipe Caicedo","25","delantero",r14,d14,h14,60);
        Jugador j15= new Jugador("Jeferson_Montero","23","delantero",r15,d15,h15,33);
        Jugador j16= new Jugador("Joao_Rojas","23","delantero",r16,d16,h16,29);
        
        list.add(j1);
        list.add(j2);
        list.add(j3);
        list.add(j4);
        list.add(j5);
        list.add(j6);
        list.add(j7);
        list.add(j8);
        list.add(j9);
        list.add(j10);
        list.add(j11);
        list.add(j12);
        list.add(j13);
        list.add(j14);
        list.add(j15);
        list.add(j16);
        return list;
    }


    @Override
    public String toString() {
        return "\n"+"Jugador:" +"\n"+ "Nombre: " + nombre + " Edad: " + Edad + " Posicion: " + Posicion;
    }
    
    

}
