package Ejercicio5;
import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio1.ColaGenerica;

/**
 *
 * @author diiego
 */
public class ProfundidadDeArbolBinario {
    ArbolBinario<Integer> a; // puede ser public, asi no instancio abajo 

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> a) {
        this.a = a;
    }
    
    public int sumaElementosProfundidad(int p){
        // si el arbol no está vacio
        ArbolBinario<Integer> aux = null;
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
        cola.encolar(this.a); 
        cola.encolar(null);
        int nivel = 0, suma = 0;
        while(!cola.esVacia()){
            aux = cola.desencolar();
            if(aux != null){
                if(nivel != p){
                    if(aux.tieneHijoIzquierdo()){
                        cola.encolar(aux.getHijoIzquierdo());
                    }
                    if(aux.tieneHijoDerecho()){
                        cola.encolar(aux.getHijoDerecho());
                    }
                  //  System.out.println("uno");                   
                }else{ // si encontré el nivel sumo el valor del nodo
                    suma += aux.getDato();
                }
            }else{
                if(!cola.esVacia()){
                    cola.encolar(null);
                    nivel++;
                }
            }         
        } 
        return suma;
    }
    
    // Test, después borrar
    public static void main(String[] args) {
        ArbolBinario<Integer> aHoja10 = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> aHoja12 = new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> aHoja5 = new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> aRaiz8 = new ArbolBinario<Integer>(3);
        ArbolBinario<Integer> aRaiz4 = new ArbolBinario<Integer>(5);

        aRaiz8.agregarHijoIzquierdo(aHoja10);
        aRaiz8.agregarHijoDerecho(aHoja12);
        aRaiz4.agregarHijoIzquierdo(aRaiz8);
        aRaiz4.agregarHijoDerecho(aHoja5);
    
        ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(aRaiz4);
        //aRaiz4.printPreorden();
        System.out.println(p.sumaElementosProfundidad(2));
    }    
    
}
