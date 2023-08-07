package tp03.ejercicio1;

/**
 *
 * @author diiego-pc
 */
public class main {

    public static void test(String[] args) {
        
        ArbolBinario<Integer> aHoja10 = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> aHoja12 = new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> aHoja5 = new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> aRaiz8 = new ArbolBinario<Integer>(3);
        ArbolBinario<Integer> aRaiz4 = new ArbolBinario<Integer>(5);

        aRaiz8.agregarHijoIzquierdo(aHoja10);
        aRaiz8.agregarHijoDerecho(aHoja12);
        aRaiz4.agregarHijoIzquierdo(aRaiz8);
        aRaiz4.agregarHijoDerecho(aHoja5);
        
        aRaiz4.printPreorden();
        System.out.println("-");
        aRaiz4.entreNiveles(0, 1);
    
        System.out.println("nodos "+ aRaiz4.contarDosHijos());
        System.out.println();
        System.out.println(aRaiz4.esCompleto());
    }
    
    
}
