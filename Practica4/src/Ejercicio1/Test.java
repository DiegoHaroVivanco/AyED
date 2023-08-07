package Ejercicio1;
import tp02.ejercicio2.*;
/**
 *
 * @author diiego
 */
public class Test {

    public static void main(String[] args) {
        ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
        ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
        ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
        ListaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        
        hijos.agregarFinal(a1); hijos.agregarFinal(a2); hijos.agregarFinal(a3);
        ArbolGeneral<String> a = new ArbolGeneral<String>("0", hijos);
        ListaGenerica<ArbolGeneral<String>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        
        ArbolGeneral<String> a11 = new ArbolGeneral<String>("11");
        ArbolGeneral<String> a12 = new ArbolGeneral<String>("12");
        hijos_a1.agregarFinal(a11); hijos_a1.agregarFinal(a12);
        
        a1.setHijos(hijos_a1);
        System.out.println("Datos en preorden: "+a.preOrden());

    }
    
}
