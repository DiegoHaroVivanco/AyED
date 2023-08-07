package Ejercicio2.punto3;
import ListasGenericas.*;
/**
 *
 * @author diiego-pc
 */
public class TestListaEnlazadaGenerica {

    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Pablo","Perez","juan.perez@gmail.com","51 y 5",2);
        Estudiante estudiante2 = new Estudiante("Lucia","Diaz","lucia.diaz@gmail.com","5 y 25",2);
        Estudiante estudiante3 = new Estudiante("Lucas","Gomez","lucas.gomez@gmail.com","1 y 45",4);
        Estudiante estudiante4 = new Estudiante("Adrian","Rodriguez","adrian.rodrig@gmail.com","23 y 56",8);
        
        ListaEnlazadaGenerica<Estudiante> lista  = new ListaEnlazadaGenerica();
        
        lista.agregarFinal(estudiante1);
        lista.agregarFinal(estudiante2);
        lista.agregarFinal(estudiante3);
        lista.agregarFinal(estudiante4);
        
        //imprimir elementos de la lista
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo().tusDatos());
        }
    
    }
    
}
