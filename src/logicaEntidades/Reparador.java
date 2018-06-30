/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaEntidades;
import logicaEstados.EstadoReparador;
/**
 *
 * @author Sol
 */
public class Reparador {
    private EstadoReparador estado;
    
    public Reparador(){
    this.estado= EstadoReparador.LIBRE;    
    }
    
    public void atender(){
        this.estado = EstadoReparador.OCUPADO;
    }
    
    public void liberar(){
        this.estado = EstadoReparador.LIBRE;
    }

    public boolean estaAtendiendo(){
        return estado.equals(EstadoReparador.OCUPADO);
    }
    
public EstadoReparador getEstado(){
    return estado;
}
}
