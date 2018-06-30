/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaEntidades;
import logicaEstados.EstadoAparato;
import logica.Tiempo;
 

public class Aparato {
    private EstadoAparato estado;
    private Tiempo tiempo ;
    
    public Aparato(){
    this.estado = EstadoAparato.ESPERANDO_REPARACION;
    
}
    public void atender(){
    this.estado = EstadoAparato.SIENDO_REPARADO;
    }

public EstadoAparato getEstado(){
    return estado;
}

public double tLlegada(){
   this.tiempo = 0;
   return tiempo;

}

}
