package Ejercicio1.punto2;

/**
 *
 * @author diiego-pc
 */
import java.util.Scanner;
import ListasDeEnteros.ListaDeEnterosConArreglos;
import ListasDeEnteros.ListaDeEnteros;

public class TestListaDeEnterosConArreglos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
        System.out.println("Ingrese números para agregar a la lista, finalize con -10");
        
        int num = scanner.nextInt();        
        while(num != -10){
            lista.agregarFinal(num);
            num = scanner.nextInt();
            scanner.nextLine(); //siguiente línea
        }
        
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }
    }


}
