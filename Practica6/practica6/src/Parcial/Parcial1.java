package Parcial;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import ejercicio4.Recorridos;
import tp06.Arista;
import tp06.Grafo;
import tp06.GrafoImplListAdy;
import tp06.Vertice;
import tp06.VerticeImplListAdy;

public class Parcial1{
	public ListaGenerica <ListaGenerica<String>> resolver (Grafo<String> ciudades, String origen, 
		String destino){
		int i=1;
		boolean [] marca = new boolean [ciudades.listaDeVertices().tamanio()+1];
		ListaGenerica<String> recorridoMin = new ListaEnlazadaGenerica<String>();
		ListaGenerica<ListaGenerica<String>> recorrido = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		ListaGenerica<Vertice<String>> lVertices = ciudades.listaDeVertices();
		lVertices.comenzar();
		String dato=lVertices.proximo().dato();
		while((!lVertices.fin()) && (dato!=origen) ) {
			dato=lVertices.proximo().dato();
			i++;
		}
		if(dato.equals(origen)) {
			resolver(destino,i,marca,recorridoMin,ciudades,recorrido);
		}
		return recorrido;
	}
	
	private void resolver(String destino,int i,boolean [] marca,ListaGenerica<String> recorridoMin,
		Grafo<String> ciudades,ListaGenerica <ListaGenerica<String>> recorrido) {
		marca[i]=true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		recorridoMin.agregarEn(v.dato(),recorridoMin.tamanio()+1);
		if(v.dato().equals(destino)) {
				recorrido.agregarEn(recorridoMin.clonar(),recorrido.tamanio()+1);
		}else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> ar=ady.proximo();
				Vertice<String> verticeDestino = ar.verticeDestino();
				if(!marca[verticeDestino.getPosicion()]) {
					resolver(destino,verticeDestino.getPosicion(),marca,recorridoMin,ciudades,recorrido);
					recorridoMin.eliminar(verticeDestino.dato());
					
				}
			}
		}
		marca[v.getPosicion()]=false;
	}
		
	public static void main(String [] args) {
			Vertice<String> v1 = new VerticeImplListAdy<String>("Mar del Plata");
			Vertice<String> v2 = new VerticeImplListAdy<String>("Pila");
			Vertice<String> v3 = new VerticeImplListAdy<String>("Mar Azul");
			Vertice<String> v4 = new VerticeImplListAdy<String>("Las Gaviotas");
			Vertice<String> v5 = new VerticeImplListAdy<String>("Querandi");
			Vertice<String> v6 = new VerticeImplListAdy<String>("Pinamar");
			Vertice<String> v7 = new VerticeImplListAdy<String>("Dolores");
			Vertice<String> v8 = new VerticeImplListAdy<String>("Chascomus");
			Vertice<String> v9 = new VerticeImplListAdy<String>("La Plata");
			Vertice<String> v10 = new VerticeImplListAdy<String>("Hubdson");
			Vertice<String> v11 = new VerticeImplListAdy<String>("Madariaga");
			Grafo<String> ciudades = new GrafoImplListAdy<String>();
			
			ciudades.agregarVertice(v1);
		    ciudades.agregarVertice(v2);
			ciudades.agregarVertice(v3);
			ciudades.agregarVertice(v4);
			ciudades.agregarVertice(v5);
			ciudades.agregarVertice(v6);
			ciudades.agregarVertice(v7);
			ciudades.agregarVertice(v8);
			ciudades.agregarVertice(v9);
			ciudades.agregarVertice(v10);
			ciudades.agregarVertice(v11);
			ciudades.conectarBidireccional(v1, v3);
			ciudades.conectarBidireccional(v1, v2);
			ciudades.conectarBidireccional(v3, v4);
			ciudades.conectarBidireccional(v3, v5);
			ciudades.conectarBidireccional(v3, v6); 
			ciudades.conectarBidireccional(v2, v7); 
			ciudades.conectarBidireccional(v7, v11); 
			ciudades.conectarBidireccional(v6, v11);
			ciudades.conectarBidireccional(v7, v8); 
			ciudades.conectarBidireccional(v11, v9);	
			ciudades.conectarBidireccional(v8, v9); 
			ciudades.conectarBidireccional(v9, v10);
			
			Parcial1 p = new Parcial1();
			
			ListaGenerica <ListaGenerica<String>> lista = p.resolver(ciudades,"La Plata", "Mar del Plata");
			
			lista.comenzar();
			while(!lista.fin()) {
				System.out.println("-> "+lista.proximo());
				
			}
			
			if(lista.esVacia()) {
				System.out.println("La lista est� vac�a");
			}else {System.out.println("ta llena");}
			
		/*	Recorridos<String> reco = new Recorridos<>();
			ListaGenerica<String> l = reco.dfs(ciudades);
			l.comenzar();
			while(!l.fin()) {
				System.out.println("-> "+l.proximo());
			}*/
			
			//System.out.println(p.resolver(ciudades,"La Plata", "Mar del Plata"));
		}
		
		
}