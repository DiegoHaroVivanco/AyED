package Grafos;

import tp06.ejercicio3.*;

public class GrafoDirigidoPesado {

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		Vertice<String> [] ArVer= new Vertice [20];
		for (int i = 0; i < 20; i++) {
			ArVer[i]= new VerticeImplListAdy<>("V"+i);	
			grafo.agregarVertice(ArVer[i]);
		}
		//--------------------V0--------------------//
		grafo.conectar(ArVer[0], ArVer[1], 10);//V0 -> V1
		//--------------------V1--------------------//
		grafo.conectar(ArVer[1], ArVer[2], 20);//V1 -> V2
		grafo.conectar(ArVer[1], ArVer[4], 30);//V1 -> V4
		//--------------------V2--------------------//
		grafo.conectar(ArVer[2], ArVer[3], 100);//V2 -> V3
		//--------------------V3--------------------//
		grafo.conectar(ArVer[3], ArVer[4], 40);//V3 -> V4
		//--------------------V4--------------------//
		grafo.conectar(ArVer[4], ArVer[5], 60);//V4 -> V5
		grafo.conectar(ArVer[4], ArVer[9], 50);//V4 -> V9
		//--------------------V5--------------------//
		grafo.conectar(ArVer[5], ArVer[2], 70);//V5 -> V2
		grafo.conectar(ArVer[5], ArVer[4], 60);//V5 -> V4
		grafo.conectar(ArVer[5], ArVer[6], 30);//V5 -> V6
		//--------------------V6--------------------//
		grafo.conectar(ArVer[6], ArVer[0], 10);//V6 -> V0
		grafo.conectar(ArVer[6], ArVer[8], 10);//V6 -> V8
		grafo.conectar(ArVer[6], ArVer[13], 10);//V6 -> V13
		grafo.conectar(ArVer[6], ArVer[14], 10);//V6 -> V14
		//--------------------V7--------------------//
		grafo.conectar(ArVer[7], ArVer[17], 100);//V7 -> V17
		//--------------------V8--------------------//
		//--------------------V9--------------------//
		grafo.conectar(ArVer[9], ArVer[10], 60);//V9 -> V10
		//--------------------V10--------------------//
		grafo.conectar(ArVer[10], ArVer[12], 50);//V10 -> V12
		//--------------------V11--------------------//
		grafo.conectar(ArVer[11], ArVer[10], 40);//V11 -> V10
		//--------------------V12--------------------//
		grafo.conectar(ArVer[12], ArVer[12], 20);//V12 -> V12
		//--------------------V13--------------------//
		grafo.conectar(ArVer[13], ArVer[8], 70);//V13 -> V8
		//--------------------V14--------------------//
		grafo.conectar(ArVer[14], ArVer[13], 60);//V14 -> V13
		//--------------------V15--------------------//
		grafo.conectar(ArVer[15], ArVer[7], 80);//V15 -> V7
		//--------------------V16--------------------//
		grafo.conectar(ArVer[16], ArVer[18], 50);//V16 -> V18
		//--------------------V17--------------------//
		grafo.conectar(ArVer[17], ArVer[16], 40);//V17 -> V16
		grafo.conectar(ArVer[17], ArVer[18], 50);//V17 -> V18
		//--------------------V18--------------------//
		grafo.conectar(ArVer[18], ArVer[17], 50);//V18 -> V17
		//--------------------V19--------------------//
		//--------------------Fin--------------------//
		Recorridos<String> r = new Recorridos<>();
		System.out.println(r.dfs(grafo));
		System.out.println(r.bfs(grafo));
		
		
	}

}

/*
Origen Destino Peso
0   1   10
1   2   20
1   4   30
2   3   100
3   4   40
4   5   20
4   9   50
5   6   70
5   2   80
5   4   30

6   0   10
6   14  10
6   13  10
6   8   10
7   17  100
8
9   10  60
10  12  50
11  10  40
12  12  20
13  8   70
14  13  60
15  7   80
16  18  50
17  16  40
17  18  90
18  17  20
19 
Para dibujar el grafo, copiar los numeros de arriba en:
https://csacademy.com/app/graph_editor/
*/
