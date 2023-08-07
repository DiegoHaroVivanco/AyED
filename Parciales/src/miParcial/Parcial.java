package miParcial;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import arbolGeneral.ArbolGeneral;

public class Parcial {

	
	public Boolean resolver( ArbolGeneral<Integer> arbol1, ArbolGeneral<Integer> arbol2) {
		Boolean ok = true;
		if(!arbol1.esVacio() && !arbol2.esVacio()) {
			if(arbol1.getHijos().tamanio() != arbol2.getHijos().tamanio()) {
				ok = false;
			}else {
				ok = true;
				ListaGenerica<ArbolGeneral<Integer>> lHijos1 = arbol1.getHijos();
				ListaGenerica<ArbolGeneral<Integer>> lHijos2 = arbol2.getHijos();
				lHijos1.comenzar();
				while(!lHijos1.fin() && !lHijos2.fin() && ok) {
					ok = resolver(lHijos1.proximo(), lHijos2.proximo());
				}
			}
			return ok;
			
		}
		return ok;
	} 
	

	
	 //           0
    //        /  |  \
    //       1   2  3 
    //     /  \
    //   11   12
    public static void main(String[] args) {
        ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
        ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
        ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        hijos.agregarFinal(a1); hijos.agregarFinal(a2); hijos.agregarFinal(a3);
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(0, hijos);
        
        ListaGenerica<ArbolGeneral<Integer>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(11);
        ArbolGeneral<Integer> a12 = new ArbolGeneral<Integer>(12);
        //ArbolGeneral<String> a14 = new ArbolGeneral<String>("14");

        hijos_a1.agregarFinal(a11); hijos_a1.agregarFinal(a12);// hijos_a1.agregarFinal(a14);   
        a1.setHijos(hijos_a1);
        
        //-------------------
        ArbolGeneral<Integer> ag1 = new ArbolGeneral<Integer>(-1);
        ArbolGeneral<Integer> ag2 = new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> ag3 = new ArbolGeneral<Integer>(-3);
        ListaGenerica<ArbolGeneral<Integer>> hijos2 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        hijos2.agregarFinal(ag1); hijos2.agregarFinal(ag2); hijos2.agregarFinal(ag3);
        ArbolGeneral<Integer> raiz2 = new ArbolGeneral<Integer>(-5, hijos2);
        ListaGenerica<ArbolGeneral<Integer>> hijos_ag1 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        
        ArbolGeneral<Integer> ag11 = new ArbolGeneral<Integer>(11);
        ArbolGeneral<Integer> ag12 = new ArbolGeneral<Integer>(-12);
        ArbolGeneral<String> a14 = new ArbolGeneral<String>("14");

        hijos_ag1.agregarFinal(ag11); hijos_ag1.agregarFinal(ag12);// hijos_a1.agregarFinal(a14);   
        a1.setHijos(hijos_ag1);
        
        Parcial p = new Parcial();
        System.out.println("Son iguales: "+ p.resolver(a, raiz2));
        
    } 
	
}
