package Ejercicio1.punto6;

import ListasDeEnteros.*;

/**
 *
 * @author diiego-pc
 */
public class ejer1_6 {
    
    public ListaDeEnterosEnlazada calcular(int n){
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        calcularSucesion(n, lista);
        return lista;
        
    }
    
    private void calcularSucesion(int n, ListaDeEnteros l){
        l.agregarFinal(n);
        if(n > 1){
           if(n %2==0){
               calcularSucesion(n/2,l);
           }else{
               calcularSucesion(3*n+1,l);
           }
           
        } 
    }
    
    public static void main(String[] args) {
        ejer1_6 f = new ejer1_6();
        
        ListaDeEnterosEnlazada l = f.calcular(6);
        
        l.comenzar();
        while(!l.fin()){
            System.out.println("-> "+l.proximo());
        }
    }
    
}
