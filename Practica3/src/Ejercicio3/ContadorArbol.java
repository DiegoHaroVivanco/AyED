package Ejercicio3;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
    private ArbolBinario<Integer> a; //= new ArbolBinario<Integer>();

    public ContadorArbol(ArbolBinario<Integer> t) {
        a = t;
    }
    
    private void numerosParesInorden(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> l){
        if(a.tieneHijoIzquierdo()){
            numerosParesInorden(a.getHijoIzquierdo(),l);
        }
        if(a.getDato()%2 == 0){
          l.agregarFinal(a.getDato());
        }
        if(a.tieneHijoDerecho()){
            numerosParesInorden(a.getHijoDerecho(),l);
        }
    }
    
    private void numerosParesPostorden(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> l){
        if(a.tieneHijoIzquierdo()){
            numerosParesPostorden(a.getHijoIzquierdo(), l);
        }
        if(a.tieneHijoDerecho()){
            numerosParesPostorden(a.getHijoDerecho(), l);
        }
        if(a.getDato()%2 ==0){
            l.agregarFinal(a.getDato());
        }
    }
    
    public ListaEnlazadaGenerica numerosPares(){
        ArbolBinario<Integer> arbol = a;
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
    
        this.numerosParesInorden(arbol, lista);
        return lista;
    }

    
    public static void main(String[] args) {
        ArbolBinario<Integer> aHoja10 = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> aHoja12 = new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> aHoja5 = new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> aRaiz8 = new ArbolBinario<Integer>(3);
        ArbolBinario<Integer> aRaiz4 = new ArbolBinario<Integer>(5);

        aRaiz8.agregarHijoIzquierdo(aHoja10);
        aRaiz8.agregarHijoDerecho(aHoja12);
        aRaiz4.agregarHijoIzquierdo(aRaiz8);
        aRaiz4.agregarHijoDerecho(aHoja5);
        
        ContadorArbol a = new ContadorArbol(aRaiz4);
        
        ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>(); 

        l = a.numerosPares();
        
        System.out.println(l.toString());
    }

}


