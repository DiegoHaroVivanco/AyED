package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
	private ListaGenerica<T> datos;

	public PilaGenerica() {
		super();
		this.datos = new ListaEnlazadaGenerica<>();
	}

	private ListaGenerica<T> getDatos() {
		return datos;
	}

	public void encolar(T datoin) {
		this.getDatos().agregarInicio(datoin);
	}

	public T desencolar() {
		T aux = this.getDatos().elemento(1);
		this.getDatos().eliminarEn(1);
		return aux;
	}

	public T tope() {
		return this.getDatos().elemento(1);
	}

	public boolean isEmpty() {
		return this.getDatos().esVacia();
	}
}
