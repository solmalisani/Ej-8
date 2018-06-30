/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaEventos;
import logicaEntidades.*;
import logica.*;

/**
 *
 * @author Sol
 */
public class FinRep extends Evento{
    
    private Gestor g;
    private final double min = 3;
    private final double max = 7;
    private Aparato aparato;
    private double rndFinRep;
    private double tiempRep;
    
    public FinRep(Gestor g, Aparato a, double tiempoFin) {
        this.g = g;
        this.aparato = a;
        this.tiempoEjec = randomTiempoAt(tiempoFin);
    }
    
    
    public void ejecutar() {
        if (g.getCola().estaVacia()) {
            g.getReparador().liberar();
        }
        else   {
            Aparato a = g.getCola().avanzar();
            a.atender();
//            Evento e = LlegadaAp.;
//            g.agregarEvento(e);        
        }
        
    }
    
    public double randomTiempoAt(double tiempoActual) {
        rndFinRep = redondear(Math.random(), DECIMALES);
        tiempRep = redondear(rndFinRep * (max - min) + min, DECIMALES);
        return tiempoActual + tiempRep;
    }
    
     public String toString() {
        return "FinRepl";
    }

    public double getRndFinRep() {
        return rndFinRep;
    }

    public double getTiempAt() {
        return tiempRep;
    }

}
