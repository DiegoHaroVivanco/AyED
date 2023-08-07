package Grafos;

import tp06.ejercicio3.*;

public class GrafoNoDirigidoNoPesado {

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		Vertice<String> [] ArVer= new Vertice [20];
		for (int i = 0; i < 20; i++) {
			ArVer[i]= new VerticeImplListAdy<>("V"+i);	
			grafo.agregarVertice(ArVer[i]);
		}
		//--------------------V0--------------------//
		grafo.conectarBidireccional(ArVer[0], ArVer[1]);//V0 - V1
		//--------------------V1--------------------//
		grafo.conectarBidireccional(ArVer[1], ArVer[2]);//V1 - V2
		grafo.conectarBidireccional(ArVer[1], ArVer[4]);//V1 - V4
		//--------------------V2--------------------//
		grafo.conectarBidireccional(ArVer[2], ArVer[3]);//V2 - V3
		//--------------------V3--------------------//
		grafo.conectarBidireccional(ArVer[3], ArVer[4]);//V3 - V4
		//--------------------V4--------------------//
		grafo.conectarBidireccional(ArVer[4], ArVer[5]);//V4 - V5
		grafo.conectarBidireccional(ArVer[4], ArVer[9]);//V4 - V9
		//--------------------V5--------------------//
		grafo.conectarBidireccional(ArVer[5], ArVer[2]);//V5 - V2
		grafo.conectarBidireccional(ArVer[5], ArVer[6]);//V5 - V6
		//--------------------V6--------------------//
		grafo.conectarBidireccional(ArVer[6], ArVer[0]);//V6 - V0
		grafo.conectarBidireccional(ArVer[6], ArVer[8]);//V6 - V8
		grafo.conectarBidireccional(ArVer[6], ArVer[13]);//V6 - V13
		grafo.conectarBidireccional(ArVer[6], ArVer[14]);//V6 - V14
		//--------------------V7--------------------//
		grafo.conectarBidireccional(ArVer[7], ArVer[17]);//V7 - V17
		//--------------------V8--------------------//
		//--------------------V9--------------------//
		grafo.conectarBidireccional(ArVer[9], ArVer[10]);//V9 - V10
		//--------------------V10--------------------//
		grafo.conectarBidireccional(ArVer[10], ArVer[12]);//V10 - V12
		//--------------------V11--------------------//
		grafo.conectarBidireccional(ArVer[11], ArVer[10]);//V11 - V10
		//--------------------V12--------------------//
		grafo.conectarBidireccional(ArVer[12], ArVer[12]);//V12 - V12
		//--------------------V13--------------------//
		grafo.conectarBidireccional(ArVer[13], ArVer[8]);//V13 - V8
		//--------------------V14--------------------//
		grafo.conectarBidireccional(ArVer[14], ArVer[13]);//V14 - V13
		//--------------------V15--------------------//
		grafo.conectarBidireccional(ArVer[15], ArVer[7]);//V15 - V7
		//--------------------V16--------------------//
		grafo.conectarBidireccional(ArVer[16], ArVer[18]);//V16 - V18
		//--------------------V17--------------------//
		grafo.conectarBidireccional(ArVer[17], ArVer[16]);//V17 - V16
		//--------------------V18--------------------//
		grafo.conectarBidireccional(ArVer[18], ArVer[17]);//V18 - V17
		//--------------------V19--------------------//
		//--------------------Fin--------------------//
		Recorridos<String> r = new Recorridos<>();
		System.out.println(r.dfs(grafo));
		System.out.println(r.bfs(grafo));
		
		
	}

}

/*
Origen Destino Peso
0   1   1
1   2   1
1   4   1
2   3   1
3   4   1
4   5   1
4   9   1
5   6   1
5   2   1
5   4   1
6   0   1
6   14  1
6   13  1
6   8   1
7   17  1
8
9   10  1
10  12  1
11  10  1
12  12  1
13  8   1
14  13  1
15  7   1
16  18  1
17  16  1
17  18  1
18  17  1
19 
Para dibujar el grafo, copiar los numeros de arriba en:
https://csacademy.com/app/graph_editor/
*/
