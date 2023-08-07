package Ejercicio3;
import  ListasGenericas.*;

public class PilaGenerica<T> {
    private ListaGenerica<T> pila = new ListaEnlazadaGenerica<T>();
    
    // Agrega elem a la pila    
    public void apilar(T elem){
       pila.agregarInicio(elem);
    }
    
    // Elimina y devuelve el elemento en el tope de la pila
    public T desapilar(){
        T elem = pila.elemento(1);       
        if(!esVacia()){ // no else, tiene que fallar, asi lo verifica el que 
        pila.eliminarEn(1);
       }
        return elem;           
    }
    
    // Devuelve el elemento en el tope de la pila sin eliminarlo
    public T tope(){
        return pila.elemento(1);
    }
   
    // Retorna true si la pila está vacía, false en caso contrario
    public boolean esVacia(){
        return pila.esVacia();
    }

    public String toString(){
        return pila.toString();
    }
   
}
