/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import logicaEntidades.Aparato;
import java.util.LinkedList;

/**
 *
 * @author Sol
 */
public class Cola {
    private final LinkedList<Aparato> cola;

    public Cola() {
        cola = new LinkedList<>();
    }
    
    public boolean estaVacia(){
        return this.cola.isEmpty();
    }
    
    public void agregar(Aparato a){
        cola.addLast(a);
    }
    
    public Aparato avanzar(){
        return cola.removeFirst();
    }
    
    public int genteEnCola(){
        return cola.size();
    }
    
    public Aparato get(int index)
    {
        return cola.get(index);
    }
}
