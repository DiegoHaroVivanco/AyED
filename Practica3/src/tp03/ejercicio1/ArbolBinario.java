package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	// LLENO -> tiene 2^(h+1)-1 hijos
        public boolean esLleno() {
            ArbolBinario<T> arbol = null;
            ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
            boolean lleno = true;
            cola.encolar(this);
            int cant_nodos = 0;
            cola.encolar(null);
            int nivel = 0;
		while(!cola.esVacia() && lleno) {
                    arbol = cola.desencolar();
                    if(arbol != null) {
                        System.out.print(arbol.getDato());
			if(arbol.tieneHijoIzquierdo()) {
                            cola.encolar(arbol.getHijoIzquierdo());
                            cant_nodos++;
			}
			if(arbol.tieneHijoDerecho()) {
                            cola.encolar(arbol.getHijoDerecho());
                            cant_nodos++;
			}
                    } else if(!cola.esVacia()) {
			if(cant_nodos == Math.pow(2, ++nivel)) {
                            cola.encolar(null);
                            cant_nodos = 0;
                            System.out.println();
			}else {
                            lleno = false;	
			}
                    }
		}
            return lleno;
	}

	boolean esCompleto() {
            if(this.esLleno()) {
		return true;
            }else {
                ColaGenerica <ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		boolean flag = false;
		while (!cola.esVacia()) {
                    ArbolBinario<T> curr = cola.desencolar();
				
                    if (curr.tieneHijoIzquierdo()) {
			if (flag) {
                            return false;
			}
					
			cola.encolar(curr.getHijoIzquierdo());
                    } else {
			flag = true;
                    }

                    if (curr.tieneHijoDerecho()) {
                        if (flag) {
                            return false;
			}

			cola.encolar(curr.getHijoDerecho());
                    } else {
                        flag = true;
                    }
		}
                    return true;
            }
         
        }

	//no hace falta verificar si esHoja, ya que si llega a serlo yo tengo inicializado
        //las variables en -1, y al sumarle 1 al return, me devuelve 0, lo que debe devolver
        //si llega a ser hoja
        public int altura(){ 
            if (this.esVacio())
                return -1; //arbol vacio
            else{
                int altIzq=-1,altDer=-1;
                if(this.tieneHijoIzquierdo()){
                    altIzq=this.getHijoIzquierdo().altura();
                }
                if(this.tieneHijoDerecho()){
                    altDer=this.getHijoDerecho().altura();
                }
                return Math.max(altIzq, altDer)+1;
            }
        }
         
         
	// imprime el árbol en preorden  
	public void printPreorden() {
            System.out.println(this.toString());
            if(tieneHijoIzquierdo()) {
		this.getHijoIzquierdo().printPreorden();;
            }
            if(tieneHijoDerecho()) {
                this.getHijoDerecho().printPreorden();
            }
	}

	// imprime el �rbol en postorden

        public void printPostorden() {
            if(this.tieneHijoIzquierdo())
                this.getHijoIzquierdo().printPreorden();
            if(this.tieneHijoDerecho())
                this.getHijoDerecho().printPreorden();
            System.out.println(this.getDato());
        }
        
        // imprime el árbol en inorden
        public void printInorden(){
            if(this.tieneHijoIzquierdo())
                this.getHijoIzquierdo().printInorden();
            System.out.println(this.getDato());       
            if(this.tieneHijoDerecho())
                this.getHijoDerecho().printInorden(); 
        }

	public void recorridoPorNiveles() {
            ColaGenerica <ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
            ArbolBinario <T> arbol;
            cola.encolar(this);
            cola.encolar(null);
            while(!cola.esVacia()){
                arbol=cola.desencolar();
                if(arbol != null){
                    System.out.println(arbol.getDato());
                    if(arbol.tieneHijoIzquierdo())
                        cola.encolar(arbol.getHijoIzquierdo());
                    if(arbol.tieneHijoDerecho())
                        cola.encolar(arbol.getHijoDerecho());
                }else if (!cola.esVacia()){
                    System.out.println();
                    cola.encolar(null);
                }
            } 		
	}

	
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}
	
	
	public int contarHojas() {
            if(this.esVacio()){
                return 0;
            }
            
            int suma = 0;
            if(this.esHoja()){
                return 1;
            }else{
                if(this.tieneHijoIzquierdo()){
                    suma +=  getHijoIzquierdo().contarHojas();
                }
                if(this.tieneHijoDerecho()){
                    suma +=  getHijoDerecho().contarHojas();
                }            
                return suma;
            }
        }

//
	public ArbolBinario<T> espejo() {

            if (this.esVacio()) {
		return new ArbolBinario<>();
            }

            ArbolBinario<T> a =  new ArbolBinario<>(this.getDato());
            if(this.tieneHijoIzquierdo()){
                a.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
            }
            if(this.tieneHijoDerecho()){
                a.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
            }
            return a;
	}
//
	public void entreNiveles(int n, int m){
            ArbolBinario<T> a = null;
            ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
            cola.encolar(this);// this = clase de la instancia donde estoy parado, en este caso el arbol entero
            cola.encolar(null);
            int nivel = 0;
            // podria chequear que m no sea mayor a n, por si pasaron mal los parámetros
            while((!cola.esVacia()) && (nivel <= m)){
                a = cola.desencolar();
                if(a != null){
                    if(nivel >= n){
                        System.out.println(a.getDato());
                    }    
                        if (a.tieneHijoIzquierdo()){                            
                            cola.encolar(a.getHijoIzquierdo());
                        }
                        if (a.tieneHijoIzquierdo()){                           
                            cola.encolar(a.getHijoDerecho());
                        }
                }else if(!cola.esVacia()){
                    System.out.println();
                    cola.encolar(null);
                    nivel++; 
                }
                   
            }
            
        }
        
        public int contarDosHijos(){
            int suma = 0;
            if(!this.esVacio()){
                if(this.tieneHijoIzquierdo() && this.tieneHijoDerecho()){ // es un nodo con 2 hijos
                    suma = 1;
                }
                if(this.tieneHijoIzquierdo()){
                    suma = suma +this.getHijoIzquierdo().contarDosHijos();
                }
                if(this.tieneHijoDerecho()){
                    suma = suma + this.getHijoDerecho().contarDosHijos();
                }
            }
            return suma;
        }
        
  /*      
        
        
        public void entreNiveles(int n, int m) {

                 ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);

		int nivel = 0;
		while (!cola.esVacia()) {
			ArbolBinario<T> actual = cola.desencolar();

			if (nivel > m) {
				break;
			}

			if (nivel >= n) {
				System.out.println(actual.getDato());
			}

			if (actual.tieneHijoIzquierdo()) {
				cola.encolar(actual.getHijoIzquierdo());
			}
			if (actual.tieneHijoDerecho()) {
				cola.encolar(actual.getHijoDerecho());
			}

			nivel++;
		}

	}        
*/
 
}
