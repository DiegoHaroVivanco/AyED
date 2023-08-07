package tp03.ejercicio1;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T>{
    private ListaGenerica<T> dato = new ListaEnlazadaGenerica<T>();
   
    /*public ColaGenerica(){
        dato = new ListaEnlazadaGenerica<T>();
    }*/
    
    // Agrega elem a la cola
    public void encolar(T elem){
        dato.agregarFinal(elem);
    }
  
    // Elimina y devuelve el primer elemento de la cola
    public T desencolar(){
        T elem = tope();       
        // preguntar si es vacia ??
       if(!esVacia()){ //no else
        dato.eliminarEn(1);
       }
       return elem;

    }
    
    // Devuelve el elemento en el tope de la cola sin eliminarlo
    public T tope(){
        return dato.elemento(1);
    }

    // Retorna true si la cola está vacía, false en caso contrario
    public boolean esVacia(){
        return dato.esVacia();
    }
    
    public String toString(){
        return dato.toString();
    }
}
