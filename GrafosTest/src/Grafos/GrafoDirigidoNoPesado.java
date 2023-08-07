package Grafos;

import tp06.ejercicio3.*;

public class GrafoDirigidoNoPesado {

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		Vertice<String> [] ArVer= new Vertice [20];
		for (int i = 0; i < 20; i++) {
			ArVer[i]= new VerticeImplMatrizAdy<>("V"+i);	
			grafo.agregarVertice(ArVer[i]);
		}
		//--------------------V0--------------------//
		grafo.conectar(ArVer[0], ArVer[1], 1);//V0 -> V1
		//--------------------V1--------------------//
		grafo.conectar(ArVer[1], ArVer[2], 1);//V1 -> V2
		grafo.conectar(ArVer[1], ArVer[4], 1);//V1 -> V4
		//--------------------V2--------------------//
		grafo.conectar(ArVer[2], ArVer[3], 1);//V2 -> V3
		//--------------------V3--------------------//
		grafo.conectar(ArVer[3], ArVer[4], 1);//V3 -> V4
		//--------------------V4--------------------//
		grafo.conectar(ArVer[4], ArVer[5], 1);//V4 -> V5
		grafo.conectar(ArVer[4], ArVer[9], 1);//V4 -> V9
		//--------------------V5--------------------//
		grafo.conectar(ArVer[5], ArVer[2], 1);//V5 -> V2
		grafo.conectar(ArVer[5], ArVer[4], 1);//V5 -> V4
		grafo.conectar(ArVer[5], ArVer[6], 1);//V5 -> V6
		//--------------------V6--------------------//
		grafo.conectar(ArVer[6], ArVer[0], 1);//V6 -> V0
		grafo.conectar(ArVer[6], ArVer[8], 1);//V6 -> V8
		grafo.conectar(ArVer[6], ArVer[13], 1);//V6 -> V13
		grafo.conectar(ArVer[6], ArVer[14], 1);//V6 -> V14
		//--------------------V7--------------------//
		grafo.conectar(ArVer[7], ArVer[17], 1);//V7 -> V17
		//--------------------V8--------------------//
		//--------------------V9--------------------//
		grafo.conectar(ArVer[9], ArVer[10], 1);//V9 -> V10
		//--------------------V10--------------------//
		grafo.conectar(ArVer[10], ArVer[12], 1);//V10 -> V12
		//--------------------V11--------------------//
		grafo.conectar(ArVer[11], ArVer[10], 1);//V11 -> V10
		//--------------------V12--------------------//
		grafo.conectar(ArVer[12], ArVer[12], 1);//V12 -> V12
		//--------------------V13--------------------//
		grafo.conectar(ArVer[13], ArVer[8], 1);//V13 -> V8
		//--------------------V14--------------------//
		grafo.conectar(ArVer[14], ArVer[13], 1);//V14 -> V13
		//--------------------V15--------------------//
		grafo.conectar(ArVer[15], ArVer[7], 1);//V15 -> V7
		//--------------------V16--------------------//
		grafo.conectar(ArVer[16], ArVer[18], 1);//V16 -> V18
		//--------------------V17--------------------//
		grafo.conectar(ArVer[17], ArVer[16], 1);//V17 -> V16
		grafo.conectar(ArVer[17], ArVer[18], 1);//V17 -> V18
		//--------------------V18--------------------//
		grafo.conectar(ArVer[18], ArVer[17], 1);//V18 -> V17
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
