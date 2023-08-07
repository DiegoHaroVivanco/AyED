package parcial_AG_negativos;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import arbolGeneral.ArbolGeneral;

public class Parcial {

	
	public ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> arbol){
		ListaGenerica<ListaGenerica<Integer>> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
		if(!arbol.esVacio()) {
			this.resolver(arbol, lista, camino);
		}
		return lista;
	}

    
	/*
	private void resolver(ArbolGeneral<Integer> arbol, ListaGenerica<ListaGenerica<Integer>> lista, ListaGenerica<Integer> camino) {
		if(arbol.getDato() < 0) {
			camino.agregarFinal(arbol.getDato());
			if(arbol.esHoja()) {
				lista.agregarFinal(camino.clonar());
			}else {
				ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin()) {
					this.resolver(lHijos.proximo(), lista, camino);
	
				}
			}
			camino.eliminarEn(camino.tamanio());
		}

	} */
	
	
	private void resolver(ArbolGeneral<Integer> arbol, ListaGenerica<ListaGenerica<Integer>> lista, ListaGenerica<Integer> camino) {
		if(arbol.getDato() < 0) {
			camino.agregarFinal(arbol.getDato());
			if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin()) {
					this.resolver(lHijos.proximo(), lista, camino);
				}
			}else {
				lista.agregarFinal(camino.clonar());
			}
			camino.eliminarEn(camino.tamanio());	
		}


		
	} 
	
	// Test, despues borrar
    //           -5
    //        /  |  \
    //       -1   2  -3 
    //     /  \
    //   11   -12
    public static void main(String[] args) {
        ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(-1);
        ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(-3);
        ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        hijos.agregarFinal(a1); hijos.agregarFinal(a2); hijos.agregarFinal(a3);
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(-5, hijos);
        ListaGenerica<ArbolGeneral<Integer>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(11);
        ArbolGeneral<Integer> a12 = new ArbolGeneral<Integer>(-12);
        //ArbolGeneral<String> a14 = new ArbolGeneral<String>("14");

        hijos_a1.agregarFinal(a11); hijos_a1.agregarFinal(a12);// hijos_a1.agregarFinal(a14);   
        a1.setHijos(hijos_a1);
       
       //ListaEnlazadaGenerica<String> arbol = a.inOrden();
       //ListaEnlazadaGenerica<String> arbol = a.preOrden();
       //ListaEnlazadaGenerica<String> arbol = a.postOrden();
      /* ListaEnlazadaGenerica<Integer> arbol = a.recorridoPorNiveles();      
       arbol.comenzar();
       while(!arbol.fin()) {
    	   System.out.println("-> "+ arbol.proximo());
       }
       */
       System.out.println("Caminos de la lista");
       Parcial p = new Parcial();
       ListaGenerica<ListaGenerica<Integer>> l = p.resolver(a);
       l.comenzar();
       while(!l.fin()) {
    		   System.out.println(l.proximo()+",");

       }
       

    }
	
	
}
