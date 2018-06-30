/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Sol
 */
public class Acu {
    private double cantAparatosReparados;
    private double cantAparatosReparadosGratis;
    private double tLlegada;
    private double difTiempo;
    
    
    public void Acu(){
        cantAparatosReparados = 0;  
        cantAparatosReparadosGratis = 0;
        tLlegada = 0;
        difTiempo = 0;
    }
    
    public void acumular(double tiempoAct, Gestor g)
    {
      difTiempo = tiempoAct - tLlegada;  
      
//Agrego 1 cuando termino de atender un cliente. Me fijo si tardo mas de 20min para ver donde lo acumulo
           if ((difTiempo)<=20) {
               cantAparatosReparados += 1;
               }
           else {
               cantAparatosReparadosGratis += 1;
            
           }}
    
    public double getCantAparatosReparados() {
        return cantAparatosReparados;
    }

    public double getCantAparatosReparadosGratis() {
        return cantAparatosReparadosGratis;
    }

  }
