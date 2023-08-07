package Grafos;

import java.util.Iterator;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class Recorridos<T> {

	public ListaGenerica<T> dfs(Grafo<T> grafo) {
		boolean marca[] = new boolean[grafo.listaDeVertices().tamanio() + 1];// array de marcas
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaGenerica<T> listasalida = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<T>> lisv = grafo.listaDeVertices();
		lisv.comenzar();
		while (!lisv.fin()) {
			Vertice<T> v = lisv.proximo();

			if (!marca[lisv.posicion(v)]) {// Recorre todos los no marcados en caso de que no sea conexo (no
				dfs(v, grafo, listasalida, marca);// dirigido) o fuertemente conexo (dirigido)
			}
		}
		return listasalida;
	}

	private void dfs(Vertice<T> v, Grafo<T> grafo, ListaGenerica<T> listasalida, boolean[] marca) {
		marca[v.getPosicion()] = true;
		listasalida.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			Arista<T> nextari=ady.proximo();
			Vertice<T> nextver=nextari.verticeDestino();
			if (!marca[nextver.getPosicion()]) {
				this.dfs(nextver, grafo, listasalida, marca);
			}
		}	
	}// El orden de ejecucion es O(|V|)

	public ListaGenerica<T> bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaGenerica<T> listasalida = new ListaEnlazadaGenerica<>();
		for (int i = 1; i < marca.length; i++) {
			if (!marca[i])
				bfs(i, grafo, listasalida, marca); // las listas empiezan en la pos 1
		}
		return listasalida;
	}

	private void bfs(int i, Grafo<T> grafo, ListaGenerica<T> listasalida, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> g = new ColaGenerica<>();
		g.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while (!g.esVacia()) {
			Vertice<T> ver = g.desencolar();
			listasalida.agregarFinal(ver.dato());
			ady = grafo.listaDeAdyacentes(ver);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> ari = ady.proximo();
				if (!marca[ari.verticeDestino().getPosicion()]) {
					marca[ari.verticeDestino().getPosicion()] = true;
					g.encolar(ari.verticeDestino());
				}
			}
		}
	}

}
