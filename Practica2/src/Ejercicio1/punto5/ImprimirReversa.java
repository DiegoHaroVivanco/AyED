package Ejercicio1.punto5;

/**
 *
 * @author diiego-pc
 */
import ListasDeEnteros.ListaDeEnteros;

public class ImprimirReversa {
    
    public  void imprimirReversa(ListaDeEnteros l){
        if(!l.fin()){
            int num = l.proximo();
            imprimirReversa(l);
            System.out.println(num);
        }

        
    }
    
    
}
