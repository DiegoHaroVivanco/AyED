package simulacroParcial;

import tp02.ejercicio2.*;

/**
 *
 * @author diiego
 */
public class Parcial {
    
    public ListaGenerica<ArbolBinario<Integer>> resolver(ArbolBinario<Integer> arbol){
        ListaGenerica<ArbolBinario<Integer>> lista = new ListaEnlazadaGenerica<>();
        if(!arbol.esVacio()){
            resolver(lista, arbol);
        }
        return lista;
    }
    private void resolver(ListaGenerica<ArbolBinario<Integer>> l, ArbolBinario<Integer> a){
            if(!a.esHoja()){

                if(a.tieneHijoIzquierdo()){
                    resolver(l, a.getHijoIzquierdo());
                }
                if(a.tieneHijoIzquierdo() && a.tieneHijoDerecho()){ // es un nodo con 2 hijos
                    l.agregarFinal(a);
                }
                if(a.tieneHijoDerecho()){
                    resolver(l,a.getHijoDerecho());
                }
            }
            
        }
}
