package Ejercicio4;
import tp03.ejercicio1.ArbolBinario;
/**
 *
 * @author diiego
 */
public class RedBinariaLlena {
    ArbolBinario<Integer> a;
    
    public RedBinariaLlena(ArbolBinario<Integer> a){
        this.a = a;
    }
    
    public int retardoReenvio(){   
        return this.retardoReenvio(a);
    }
    
    private int retardoReenvio(ArbolBinario<Integer> a){
        // No pregunto si está vacio porque por la topología va a estar lleno.
        // funcion que recibe un arbol, y devuelve el mayor retardo
        // me quedo con el mas grande y le sumo el valor de la raiz, asi con todo
            int retardoHI = 0, retardoHD = 0;
            if(a.esHoja()){ // caso base
                return a.getDato(); // Retorno el valor de la raiz
            }else{
                // llamo a funcion retardo(arbol.hi);
                // llamo  a funcion retardo(arbo.hd);
               // return max(reHI, re HD) + arbol.datoRaiz
                if(a.tieneHijoIzquierdo()){
                    retardoHI = retardoReenvio(a.getHijoIzquierdo());
                }
                if(a.tieneHijoDerecho()){
                    retardoHD = retardoReenvio(a.getHijoDerecho());
                }
                return Math.max(retardoHI, retardoHD) + a.getDato();
            } 
   
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
        
        RedBinariaLlena red = new RedBinariaLlena(aRaiz4);
        //aRaiz4.printPreorden();
        System.out.println("-> "+ red.retardoReenvio());
    }
}