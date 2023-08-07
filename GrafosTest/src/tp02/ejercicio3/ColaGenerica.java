package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	private ListaGenerica<T> datos;

	public ColaGenerica() {
		super();
		this.datos = new ListaEnlazadaGenerica<>();
	}

	public ListaGenerica<T> getDatos() {
		return datos;
	}

	public void encolar(T datoin) {
		this.getDatos().agregarFinal(datoin);
	}
	
	public T desencolar() {
		T aux= this.getDatos().elemento(1);
		this.getDatos().eliminarEn(1);
		return aux;
	}
	
	public T tope() {
		return this.getDatos().elemento(1);
	}
	
	public boolean esVacia() {
		return this.getDatos().esVacia();
	}

}
