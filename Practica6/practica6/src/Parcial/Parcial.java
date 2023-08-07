package Parcial;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import tp06.Grafo;
import tp06.Vertice;

public class Parcial {

	public ListaGenerica<String> resolver (Grafo<String> digrafo, String origen, String destino){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoMax = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean[digrafo.listaDeVertices().tamanio()+1];
		Vertice<String> vOrigen = null; Vertice<String> vDestino = null;
		
		ListaGenerica<Vertice<String>> vertices = digrafo.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()) {
			Vertice<String> act = vertices.proximo();
			if(act.dato().equals(origen)) {
				vOrigen = act;
			}
			if(act.dato().equals(destino)) {
				vDestino = act;
			}
		}
		SumaCamino suma = new SumaCamino();	
		if((vOrigen !=null) && (vDestino != null)) {
			suma.setCostoAct(0);
			suma.setCostoMax(-99999);
			dfs(digrafo, vOrigen, vDestino, marcas,caminoMax, suma);
		}
		return suma.getcaminoMax();
	
	}

	private void dfs(Grafo<String> digrafo, Vertice<String> vOrigen, Vertice<String> vDestino, boolean[] marcas,
			L, ListaGenerica<String> caminoMax, SumaCamino suma) {
		marcas[vOrigen.getPosicion()] = true;
		caminoMax.agregarFinal(vOrigen.dato());
		if(vOrigen == vDestino) {
			if(suma.getCostoAct() > suma.getCostoMax()) {
				suma.actualizarValor(suma.getCostoAct(), caminoMax);
			}else {
				ListaGenerica<Arista> ady = digrafo.listaDeAdyacentes(vOrigen);
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!marca[arista.getvOrigen().getPosicion()])
						dfs(digrafo, , 
								camino, res, peso + arista.peso(), marca);
				}
			}
				
		}
		
		marcas[vOrigen.getPosicion()] = false;
		caminoMax.eliminarEn(caminoMax.tamanio());

	}
	
	
}
