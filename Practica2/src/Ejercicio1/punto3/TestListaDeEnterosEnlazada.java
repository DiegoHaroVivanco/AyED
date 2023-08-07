package Ejercicio1.punto3;

/**
 *
 * @author diiego-pc
 */
import java.util.Scanner;
import ListasDeEnteros.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        
        System.out.println("Ingrese números para agregar a la lista, finalize con -10");
        int num = scanner.nextInt();
        while(num != -10){
            lista.agregarFinal(num);
            num = scanner.nextInt();
            scanner.nextLine();
        }
    
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }
    
    }
    
}
