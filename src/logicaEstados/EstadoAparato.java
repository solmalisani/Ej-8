/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaEstados;

/**
 *
 * @author Sol
 */
public enum EstadoAparato {
    ESPERANDO_REPARACION("Esperando Reparacion"),
    SIENDO_REPARADO("Siendo reparado");
    
    private final String nombre;
    
private EstadoAparato( String nombre){
    this.nombre = nombre;
}

public String getNombre(){
    return this.nombre;
        }


}
