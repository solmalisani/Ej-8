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
public class LlegadaAp extends Evento  {
    
     private static final double MEDIA = 7.5;
     private Aparato aparato;
     private final  Gestor g;
     private double proxLleg;
     private static double randomLleg;
     private boolean reparado;
     private Evento proxEvento;
    
     
     public LlegadaAp(Gestor g, double tiempoAct) {
        randomLleg = 0;
        this.g = g;
        tiempoEjec = randomProxLleg(tiempoAct);
        reparado = false;
    }
     
     public double randomProxLleg(double tiempoActual) {
        randomLleg = redondear(Math.random(), DECIMALES);
        return redondear(tiempoActual + (-MEDIA) * Math.log(1 - randomLleg), DECIMALES);
    }
     
    public void ejecutar() {
        Evento evProxLleg = new LlegadaAp(g, tiempoEjec);
        g.agregarEvento(evProxLleg);
        proxLleg = evProxLleg.getTiempoEjec();

        aparato = new Aparato();
        if (g.getReparador().estaAtendiendo())
                {
            g.getCola().agregar(aparato);
            reparado = false;
        } else {
            reparado = true;
            g.getReparador().atender();
            aparato.atender();
       
            //como manejo el prox evento?
            
//            proxEvento = GenerarTipoCompra(aparato, tiempoEjec, g);
//            if(g.getProxPurg().getTiempoEjec() < proxEvento.getTiempoEjec()){
//                proxEvento.retrasarEjecucion(FinPurgado.getTiempoPurgado());
//            }
//            g.agregarEvento(proxEvento);
        
 }}

public String toString() {
        return "Llegada ";
    }

    public double getProxLleg() {
        return proxLleg;
    }

    public double getRandomLleg() {
        return randomLleg;
    }
    
    public boolean fueReparado() {
        return reparado;
    }

    public Evento getProxEvento() {
        return proxEvento;
    }
       
    
}