/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import gui.Columna;
import java.util.TreeSet;
import logicaEventos.*;
import logicaEntidades.*;

/**
 *
 * @author Sol
 */
public class Gestor {
     private int cantSim;
    private Cola cola;
    private TreeSet<Evento> colaEventos;
    private Tiempo tiempo;
    private Reparador reparador;
    private Aparato aparato;
    private TreeSet<FinRep> colaEvDeFinRep;
    private Acu acumulador;
    private Columna columnaAnterior;
    
    
    public Gestor(){
     
    }
    
    
    //como hago??? fx
        
//    public ObservableList<Columna> simular(int cantSim, int desde, int hasta) {
//        ObservableList<Columna> lista = FXCollections.observableArrayList();
//        this.cantSim = cantSim;
//        init();
//        Columna primeraCol = armarPrimeraColumna(colaEventos.first().getTiempoEjec());
//        lista.add(primeraCol);
//
//        int i = 0;
//        while (hayEventos() && i < cantSim) {
//            Evento e = proximoEvento();
//            tiempo.setTime(e.getTiempoEjec());
//            e.ejecutar();
//            acumulador.acumular(e.getTiempoEjec(), this);
//
//            Columna col = armarColumna(e);
//            if (i >= desde && i < hasta) {
//                lista.add(col);
//            }
//
//            i++;
//            
//        }
//        return lista;
//    }

      public void init() {
        columnaAnterior = new Columna();
        acumulador = new Acu();
        tiempo = Tiempo.getInstance();
        tiempo.clear();
        cola = new Cola();
        reparador = new Reparador();
        aparato = new Aparato();
        colaEventos = new TreeSet();
        agregarEvento(new LlegadaAp(this, 0));
   
    }
    
      private Evento proximoEvento() {
        if (colaEvDeFinRep.isEmpty()) {
            return colaEventos.pollFirst();
        }
        Evento e1 = colaEventos.first();
        Evento e2 = colaEvDeFinRep.first();
        if (e1.compareTo(e2) < 0) {
            return colaEventos.pollFirst();
        } else {
            return colaEvDeFinRep.pollFirst();
        }
    }
      
       public void agregarEvento(Evento e) {
        colaEventos.add(e);
    }

    public double getTiempo() {
        return tiempo.getTime();
    }

    public void agregarTiempo(double t) {
        tiempo.agregarTiempo(t);
    }

    public Cola getCola() {
        return cola;
    }

    public Reparador getReparador() {
        return reparador;
    }

    public Aparato getAparato() {
        return aparato;
    }

    public void agregarEvDeFinRep(FinRep e) {
        colaEvDeFinRep.add(e);
    }

    public boolean hayReparaciones() {
        return !colaEvDeFinRep.isEmpty();
    }

    

    private boolean hayEventos() {
        return !(colaEventos.isEmpty() && colaEvDeFinRep.isEmpty());
    }

    public double cantAparatosReparados()  {
        return acumulador.getCantAparatosReparados();
    }

    public double cantAparatosReparadosGratis() {
        return acumulador.getCantAparatosReparadosGratis();
    }


    public Columna armarColumna(Evento e) {
        Columna nuevaCol = new Columna();
        nuevaCol.setReloj(Double.toString(tiempo.getTime()));
        nuevaCol.setEvento(e.toString());

        //Puesta en cero
        nuevaCol.setRndLleg("");
        nuevaCol.setTiemEnLleg("");
       

        nuevaCol.setProxLleg(columnaAnterior.getProxLleg());
        if (columnaAnterior.getFinRep().equals(Double.toString(tiempo.getTime()))) {
            nuevaCol.setFinRep("");
        } else {
            nuevaCol.setFinRep(columnaAnterior.getFinRep());
        }

        
        if (!colaEvDeFinRep.isEmpty()) {
            nuevaCol.setFinRep(Double.toString(colaEvDeFinRep.first().getTiempoEjec()));
        } else {
            nuevaCol.setFinRep("");
        }
        

        if (e instanceof LlegadaAp) {
            nuevaCol.setRndLleg(Double.toString(((LlegadaAp) e).getRandomLleg()));
            nuevaCol.setTiemEnLleg(Double.toString(-(tiempo.getTime() - ((LlegadaAp) e).getProxLleg())));
            nuevaCol.setProxLleg(Double.toString(((LlegadaAp) e).getProxLleg()));
            if (((LlegadaAp) e).fueReparado()) {
                if (((LlegadaAp) e).getProxEvento() instanceof FinRep) {
                    nuevaCol.setRndFinRep(Double.toString(((FinRep) ((LlegadaAp) e).getProxEvento()).getRndFinRep()));
                    nuevaCol.setTiemRep(Double.toString(((FinRep) ((LlegadaAp) e).getProxEvento()).getTiempAt()));
                    nuevaCol.setFinRep(Double.toString(((FinRep) ((LlegadaAp) e).getProxEvento()).getTiempoEjec()));
                } 
            }
        }

          
        nuevaCol.setEstReparador(reparador.getEstado().toString());
        nuevaCol.setEstCola(Integer.toString(cola.genteEnCola()));
        nuevaCol.setCantApArreglados(Double.toString(acumulador.getCantAparatosReparados()));
        nuevaCol.setCantApArregladosGratis(Double.toString(acumulador.getCantAparatosReparadosGratis()));
        nuevaCol.setEstado1(aparato.getEstado().toString());
        nuevaCol.setTLlegada1(aparato.tLlegada(Double.toString(tiempo.getTime())));
        nuevaCol.setEstado2("");
        nuevaCol.setTLlegada2("");
        nuevaCol.setEstado3("");
        nuevaCol.setTLlegada3("");

        columnaAnterior = nuevaCol;

        return nuevaCol;
    }

    
    //listo
    
    public Columna armarPrimeraColumna(double proxLleg) {
        Columna nuevaCol = new Columna();

        nuevaCol.setReloj(Integer.toString(0));
        nuevaCol.setEvento("Init");
        nuevaCol.setRndLleg("");
        nuevaCol.setTiemEnLleg("");
        nuevaCol.setProxLleg(Double.toString(proxLleg));
        nuevaCol.setRndFinRep("");
        nuevaCol.setTiemRep("");
        nuevaCol.setFinRep("");
        nuevaCol.setEstReparador(reparador.getEstado().toString());
        nuevaCol.setEstCola(Integer.toString(cola.genteEnCola()));
        nuevaCol.setCantApArreglados(Double.toString(acumulador.getCantAparatosReparados()));
        nuevaCol.setCantApArregladosGratis(Double.toString(acumulador.getCantAparatosReparadosGratis()));
        nuevaCol.setEstado1("");
        nuevaCol.setTLlegada1("");
        nuevaCol.setEstado2("");
        nuevaCol.setTLlegada2("");
         nuevaCol.setEstado3("");
        nuevaCol.setTLlegada3("");
        
        
        columnaAnterior = nuevaCol;
        return nuevaCol;
    }

//    private static double redondear(double numero, int decimales) {
//        int factorRed = (int) Math.pow(10, (double) decimales);
//        int i = (int) (numero * factorRed);
//        double res = ((double) i) / factorRed;
//        return res;
//    }
      
    }
    
    

