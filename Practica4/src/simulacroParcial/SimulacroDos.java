package simulacroParcial;
import tp02.ejercicio2.*;
/**
 *
 * @author diiego
 */
public class SimulacroDos {
    
    
    public ListaEnlazadaGenerica resolver(ArbolBinario<Integer> arbol){
        ListaEnlazadaGenerica<Integer> li = new ListaEnlazadaGenerica<>();
        if(!arbol.esVacio())
            this.resolver(arbol, li);
        return li;
    }
    
    private int resolver(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> lista){
        int contIzq = 0, contDer = 0;
        if(a.tieneHijoIzquierdo())
            contIzq = resolver(a.getHijoIzquierdo(), lista);
        if(a.tieneHijoDerecho())
            contDer = resolver(a.getHijoDerecho(), lista);
        if(contIzq == contDer)
            lista.agregarFinal(a.getDato());
        
        return contIzq + contDer + 1 ;
                
    }


}
