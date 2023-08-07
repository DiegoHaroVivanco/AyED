package simulacroParcial;

import ejercicio1.ArbolGeneral;
import tp02.ejercicio2.*;

/**
 *
 * @author diiego
 */

    //           2
    //        /  |  \
    //       11   2  3 
    //     /  \
    //   11   12
public class Test {
    public static void main(String[] args) {
         ArbolBinario<Integer> aHoja10 = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> aHoja12 = new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> aHoja5 = new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> aRaiz8 = new ArbolBinario<Integer>(8);
        ArbolBinario<Integer> aRaiz4 = new ArbolBinario<Integer>(10);

        aRaiz8.agregarHijoIzquierdo(aHoja10);
        aRaiz8.agregarHijoDerecho(aHoja12);
        aRaiz4.agregarHijoIzquierdo(aRaiz8);
        aRaiz4.agregarHijoDerecho(aHoja5);
        Parcial p = new Parcial();
        ListaGenerica <ArbolBinario<Integer>> l = new ListaEnlazadaGenerica<>();
        l = p.resolver(aRaiz4);
        l.comenzar();
        while(!l.fin()){
            System.out.println("-> "+l.proximo());
        }
    }

    
}
