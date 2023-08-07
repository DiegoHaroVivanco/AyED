package Ejercicio7;
import ejercicio1.ArbolGeneral;
import tp02.ejercicio2.ListaGenerica;
/**
 *
 * @author diiego
 */
public class RedDeAguaPotable<T> {
    ArbolGeneral<T> red;
    
    
    public RedDeAguaPotable(ArbolGeneral<T> caudal) {
        this.red = caudal;
    }

    public double minimoCaudal(double caudal){
        if(!red.esVacio()){
            return minimoCaudal(red,caudal);
        }else{
            return -1;
        }
    }
    
    private double minimoCaudal(ArbolGeneral<T> arbol,double caudal){
        
        if(arbol.esHoja() || arbol.esVacio()){
            return caudal;
        }else{
            ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
            double div = caudal / lHijos.tamanio();
            double min = div;
            lHijos.comenzar();
            while(!lHijos.fin()){
                ArbolGeneral<T> auxArbol = lHijos.proximo();     
                min = Math.min(min, minimoCaudal(auxArbol, div));
            }
            return min;
        }
        
    } 
    
}
