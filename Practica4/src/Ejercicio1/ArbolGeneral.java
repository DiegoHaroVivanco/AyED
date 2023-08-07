package ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ColaGenerica;
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
            if (hijos==null) //está demas, la lista hijos no va a ser null, porque el constructor crea la list y por ende aloco espacio y con el new ya se pierde el null
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
	
	@Override
        public String toString(){
            return this.getDato().toString();
        }
        
        // EJERCICIO 3----------------------------------------------------------
        
        //Método que retorna una lista con los elementos del Árbol receptor, en pre orden
        public ListaEnlazadaGenerica<T> preOrden() {
            ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
            this.preOrden(l); // llamo al método privado, preguntar si pasar this
            return l;
        }
	
        private void preOrden(ListaGenerica<T> lista){ 
            if(!this.esVacio()){
                lista.agregarFinal(this.getDato());
                ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
                lHijos.comenzar();
                while(!lHijos.fin()){ // si no tiene hijos devuelve false y no entra
                    lHijos.proximo().preOrden(lista);
                }
            }
        }
        
        // Método que retorna una lista con los elementos del Árbol receptor, en in order
        public ListaEnlazadaGenerica<T> inOrden(){
            ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
            this.inOrden(l); // llamo al método privado
            return l;
        }    
        
        private void inOrden(ListaGenerica<T> lista){
            ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos(); // agrego todo un arbol ??
            if(!lHijos.esVacia()){
                lHijos.comenzar();
                lHijos.proximo().inOrden(lista);
            }
            lista.agregarFinal(this.getDato()); // agrego el nodo raíz
       
            while(!lHijos.fin()){
               lHijos.proximo().inOrden(lista);
            }
        }
        
     // Método que retorna una lista con los elementos del Árbol receptor, en post orden   
        public ListaEnlazadaGenerica<T> postOrden (){
            ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica();
            this.postOrden(l);
            return l;
        }
        
        private void postOrden(ListaGenerica<T> lista){
            if(!this.esVacio()){
                ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
                lHijos.comenzar();
                while(!lHijos.fin()){
                    lHijos.proximo().postOrden(lista);
                }
                lista.agregarFinal(this.getDato());
            }
        }
        
        // Método que retorna una lista con los elementos del Árbol receptor, en orden de recorrido por
        // niveles de arriba hacia abajo y de izquierda a derecha, incluyendo algún elemento que indique
        // el fin de cada nivel 
        public ListaEnlazadaGenerica<T> recorridoPorNiveles(){ // metodo públic porque es iterativo y no se necesita uno privado
            ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
            ArbolGeneral <T> arbol; // arbol que va a ir guardando lo que voy desencolando
            ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica(); // lista donde voy a retornar los datos
            cola.encolar(this);
            cola.encolar(null);
            while(!cola.esVacia()){
                arbol = cola.desencolar();
                if(arbol != null){
                    lista.agregarFinal(arbol.getDato());
                    ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos(); // se crea y cuando sale del if se destruye
                    lHijos.comenzar();
                    while(!lHijos.fin()){
                        ArbolGeneral<T> auxHijo = lHijos.proximo();
                        if(!auxHijo.esVacio()){
                            cola.encolar(auxHijo);
                        }
                    }
                }else if (!cola.esVacia()){
                    cola.encolar(null);
                }
            } 
            return lista;
        }
        
    // Fin ejercicio 3 ---------------------------------------------------------------     
    
    // Ejercicio 4 ---------------------------------------------------------    
       
        public Integer altura() {
            Integer alt=0;
            if (!this.esHoja()) {
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
		lHijos.comenzar();
		while(!lHijos.fin()) {
                    alt = 1 + lHijos.proximo().altura();
		}
            }else 
                 return 1;
            return alt;
	}     
        
        public Integer nivel(T dato){
            if(!this.esVacio()){
                ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
                ArbolGeneral<T> arbol;
                int nivel = 0;
                
                cola.encolar(this);
                cola.encolar(null);
                while(!cola.esVacia()){
                    arbol = cola.desencolar();
                    if(arbol != null){
                        if(arbol.getDato().equals(dato)){
                            System.out.println("dato"+ arbol.getDato());
                            return nivel;
                        }
                        ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
                        lHijos.comenzar();
                        while(!lHijos.fin()){
                            ArbolGeneral<T> auxHijo = lHijos.proximo();
                            if(!auxHijo.esVacio()){
                                cola.encolar(auxHijo);
                            }
                        }
                    }else if(!cola.esVacia()){
                            cola.encolar(null);
                            nivel++;
                        }
                }
            }
            return -1; // no se encontró el dato
	}

	public Integer ancho() {
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
            ArbolGeneral<T> arbol;
            cola.encolar(this);
            cola.encolar(null);
            int cantNodos = 0, max = Integer.MIN_VALUE;
            if(!this.esVacio()){
                while(!cola.esVacia()){
                    arbol = cola.desencolar();
                    if(arbol != null){ 
                        cantNodos++;                        
                        ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
                        lHijos.comenzar();
                        while(!lHijos.fin()){
                            ArbolGeneral<T> auxHijo = lHijos.proximo();
                            if(!auxHijo.esVacio())
                                cola.encolar(auxHijo); 
                        }
                        max = Math.max(cantNodos, max);
                    }else if(!cola.esVacia()){
                        cola.encolar(null);
                    }
                }
                return max;
            }
            return 0;
        }

    // Fin ejercicio 4 ---------------------------------------------------------     

       
    // Test, despues borrar
    //           0
    //        /  |  \
    //       1   2  3 
    //     /  \
    //   11   12
   /* public static void main(String[] args) {
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
        System.out.println("Datos en preorden: "+a.preOrden());
        
       a1.setHijos(hijos_a1);
       System.out.println("Datos en inOrden: "+a.inOrden());    

       a1.setHijos(hijos_a1);
       System.out.println("Datos en postOrden: "+a.postOrden());         
    
        a1.setHijos(hijos_a1);
        System.out.println("Datos en recorrido por niveles: "+a.recorridoPorNiveles());         
        System.out.println("----------------------");
        System.out.println("Altura: " + a1.altura());
        
        String dato = "0";
        System.out.println("El dato está en el nivel: " + a1.nivel(dato));
        
        
       System.out.println("Ancho del arbol: "+a1.ancho());
    }             
    */
}