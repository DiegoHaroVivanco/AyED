package parcial_AB_primerParYNivel;

import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public Resultado resolver(ArbolBinario<Integer> arbol) {
		Resultado resul = new Resultado();
		if(!arbol.esVacio()) {
			resolver(arbol, 0,resul);
		}
		return resul;
	}

	private void resolver(ArbolBinario<Integer> arbol, int nivel, Resultado resul) {
		if(resul.getNivel() == -1 ) {
			if(arbol.tieneHijoIzquierdo()) {
				resolver(arbol.getHijoIzquierdo(), nivel + 1, resul);
			}
			if(arbol.tieneHijoDerecho() && resul.getNivel() == -1) {
				resolver(arbol.getHijoDerecho(), nivel + 1, resul);
			}		
			if((arbol.getDato() % 2 == 0) && resul.getNivel() == -1) {
				resul.setNivel(nivel);
				resul.setNodo(arbol.getDato());
			}
		}
	}
	
    public static void main(String[] args) {
        ArbolBinario<Integer> aHoja7 = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> aHoja9 = new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> aHoja2 = new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> aRaiz3 = new ArbolBinario<Integer>(3);
        ArbolBinario<Integer> aRaiz5 = new ArbolBinario<Integer>(4);

        aRaiz3.agregarHijoIzquierdo(aHoja7);
        aRaiz3.agregarHijoDerecho(aHoja9);
        aRaiz5.agregarHijoIzquierdo(aRaiz3);
        aRaiz5.agregarHijoDerecho(aHoja2);
        

        Parcial p = new Parcial();
        Resultado resul =  p.resolver(aRaiz5);
        System.out.println("Nodo: "+ resul.getNodo());
        System.out.println("Nivel: "+resul.getNivel());
        
    }   
	
	
}
