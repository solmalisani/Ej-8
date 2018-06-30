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
public enum EstadoReparador {
    LIBRE("Libre"),
    OCUPADO("Ocupado");

    private final String nombre;

    private EstadoReparador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

 
    public String toString() {
        return nombre;
    }
    
}
