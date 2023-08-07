package arbolGeneral;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import colaGenerica.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	// -------------------------------------- Ejercicio 3 --------------------------------------
	
	private void preOrden(ListaEnlazadaGenerica<T> l) {
		if(!this.esVacio()) {
			l.agregarFinal(this.getDato());
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				lHijos.proximo().preOrden(l);
			}
		}
	}
	
	//Método que retorna una lista con los elementos del Árbol receptor, en pre order
	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		this.preOrden(lista);
		return lista;
	}
	
	private void inOrden(ListaEnlazadaGenerica<T>l) {
		if(!this.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			if(!lHijos.esVacia()) {
				lHijos.comenzar();
				lHijos.proximo().inOrden(l);
			}
			l.agregarFinal(this.getDato()); // agrego el nodo raíz a la lista
			while(!lHijos.fin()) {
				lHijos.proximo().inOrden(l);;
			}
		}
	}
	
	// Método que retorna una lista con los elementos del Árbol receptor, en in orde
	public ListaEnlazadaGenerica<T> inOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		this.inOrden(lista);
		return lista;
	}
	
	private void postOrden(ListaEnlazadaGenerica<T> l) {
		if(!this.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				lHijos.proximo().postOrden(l);
			}
			l.agregarFinal(this.getDato());
			
		}
	}
	
	// Método que retorna una lista con los elementos del Árbol receptor, en post order
	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		this.postOrden(lista);
		return lista;
	}
	
	
	// Método que retorna una lista con los elementos del Árbol receptor, en orden de recorrido por
	// niveles de arriba hacia abajo y de izquierda a derecha, incluyendo algún elemento que indique
	// el fin de cada nivel	
	public ListaEnlazadaGenerica<T> recorridoPorNiveles() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbolAux;
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		cola.encolar(this);
		cola.encolar(null);

		while(!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if(arbolAux != null) {
				lista.agregarFinal(arbolAux.getDato());
				ListaGenerica<ArbolGeneral<T>> lHijos = arbolAux.getHijos(); 
				lHijos.comenzar();
				while(!lHijos.fin()) {
					cola.encolar(lHijos.proximo());
				}
			}else if (!cola.esVacia()){
				cola.encolar(null);
			}
		}
		
		return lista;
	}
	
	// -------------------------------------- Fin del ejercicio 3 --------------------------------------
	
	
	// -------------------------------------- Ejercicio 4 --------------------------------------
	
	public Integer altura() {
		int sumaAltura = 0, max = 0;
		if(this.esVacio()) {
			return 0;
		}
		if(this.esHoja()) {
			return sumaAltura;
		}else {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			//sumaAltura++;
			lHijos.comenzar();
			while(!lHijos.fin()) {
				sumaAltura = lHijos.proximo().altura();	
				if(sumaAltura > max) {
					max = sumaAltura;
				}
			}

			return max + 1;
		}
	}

	public Integer nivel(T dato) {
		if(!this.esVacio()) {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> arbolAux;
			int profundidad = 0;
			
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbolAux = cola.desencolar();
				if(arbolAux != null) {
					if(arbolAux.getDato().equals(dato)) {
						return profundidad;
					}
					ListaGenerica<ArbolGeneral<T>> lHijos = arbolAux.getHijos();
					lHijos.comenzar();
					while(!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}else if(!cola.esVacia()) {
					cola.encolar(null);
					profundidad++;
				}
			}
		}
		return -1;
	}

	public Integer ancho() {
		if(!this.esVacio()) {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> arbolAux;
			int cantNodos = 0, maxNodos = -1;
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbolAux = cola.desencolar();
				if(arbolAux != null) {
					cantNodos++;
					ListaGenerica<ArbolGeneral<T>> lHijos = arbolAux.getHijos();
					lHijos.comenzar();
					while(!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}else if(!cola.esVacia()){
					cola.encolar(null);
					if(cantNodos > maxNodos) {
						maxNodos = cantNodos;
					}					
					cantNodos = 0;
				}

			}
			// comparo por el último nivel, ya que al haber procesado los nodos del último nivel no encolo hijos(porque no tiene) y por ende no encolo null
			// entonces no entra al else, ya que la cola estaría vacía.
			if(cantNodos > maxNodos) {
				maxNodos = cantNodos;
			}
			return maxNodos;
		}
		
		return 0;
	}

	
	// -------------------------------------- Ejercicio 6 --------------------------------------

	private Boolean existeA(T origen, T b){
		Boolean encontre = false;
		if(this.getDato().equals(origen)) {
			return this.existeB(b);
		}else {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!(lHijos.fin()) && (encontre)) {
				encontre = lHijos.proximo().existeA(origen, b);
			}
		}
		return encontre;
	}
	
	private Boolean existeB(T b) {
		Boolean existe = false;
		if(this != null) {
			if(this.getDato().equals(b)) {
				return true;
			}else {
				ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
				lHijos.comenzar();
				while(!(lHijos.fin()) && !(existe)) {
					ArbolGeneral<T> abProximo = lHijos.proximo();				
					existe = abProximo.existeB(b);
				}
			}
		}
		return existe;
	}
	
	public Boolean esAncestro(T a, T b) {
		return this.existeA(a, b);
	}
	

	// Test, despues borrar
    //           0
    //        /  |  \
    //       1   2  3 
    //     /  \
    //   11   12
    public static void main(String[] args) {
        ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
        ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
        ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
        ListaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        
        hijos.agregarFinal(a1); hijos.agregarFinal(a2); hijos.agregarFinal(a3);
        ArbolGeneral<String> a = new ArbolGeneral<String>("0", hijos);
        ListaGenerica<ArbolGeneral<String>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        
        ArbolGeneral<String> a11 = new ArbolGeneral<String>("11");
        ArbolGeneral<String> a12 = new ArbolGeneral<String>("12");
        //ArbolGeneral<String> a14 = new ArbolGeneral<String>("14");

        hijos_a1.agregarFinal(a11); hijos_a1.agregarFinal(a12);// hijos_a1.agregarFinal(a14);   
        a1.setHijos(hijos_a1);
       
       //ListaEnlazadaGenerica<String> arbol = a.inOrden();
       //ListaEnlazadaGenerica<String> arbol = a.preOrden();
       //ListaEnlazadaGenerica<String> arbol = a.postOrden();
       ListaEnlazadaGenerica<String> arbol = a.recorridoPorNiveles();      
       arbol.comenzar();
       while(!arbol.fin()) {
    	   System.out.println("-> "+ arbol.proximo());
       }
       
       System.out.println("Altura del árbol: " + a.altura());
       System.out.println("Profundidad del dato: " + a.nivel("12"));
       System.out.println("Ancho del arbol: " + a.ancho());
       System.out.println("Es ancestro: " + a.esAncestro("11", "2"));
    }
}