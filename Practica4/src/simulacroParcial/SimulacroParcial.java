package simulacroParcial;
import ejercicio1.ArbolGeneral;
import tp02.ejercicio2.*;

/**
 *
 * @author diiego
 */
public class SimulacroParcial {
    
    public boolean resolver(ArbolGeneral<Integer> arbol){
        if(arbol.esVacio()){
            return false;
        }else{
            int min = 0;    
            ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
            lHijos.comenzar();
            while(!lHijos.fin()){
                ArbolGeneral<Integer> auxArbol = lHijos.proximo();
                min = Math.min(min, auxArbol.getDato());
                resolver(auxArbol);
            }
            if(arbol.getDato() == min){
                return true;
            }else{
                return false;
            }
        }
        
    }
    
}
