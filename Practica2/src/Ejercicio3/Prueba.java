package Ejercicio3;

public class Prueba {

    public static void main(String[] args) {
        PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
        ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
         
        if(pila.esVacia()){
            pila.apilar(10);
            pila.apilar(20);
            pila.apilar(18);
        }
        
        if(cola.esVacia()){
            cola.encolar(5);
            cola.encolar(1);
            cola.encolar(10);

        }
          System.out.println(cola.toString()); 
          System.out.println("pila: "+pila.toString());
        System.out.println(pila.desapilar()+" Elemento desapilado del tope");
        System.out.println(cola.desencolar()+ " Elemento desencolado");        
        System.out.println("Tope pila: "+pila.tope());
        System.out.println("Tope cola(primero): "+cola.tope());
        
    }

}
