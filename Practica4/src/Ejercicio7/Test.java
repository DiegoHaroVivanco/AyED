package Ejercicio7;
import ejercicio1.ArbolGeneral;
import tp02.ejercicio2.ListaEnlazadaGenerica;
/**
 *
 * @author diiego
 */
public class Test {

    public static void main(String[] args) {
        ArbolGeneral<Character> A = new ArbolGeneral<Character>('A');
        ListaEnlazadaGenerica<ArbolGeneral<Character>> hijosA = new ListaEnlazadaGenerica<>();

        ArbolGeneral<Character> B = new ArbolGeneral<Character>('B');

        ArbolGeneral<Character> C = new ArbolGeneral<Character>('C');
        ListaEnlazadaGenerica<ArbolGeneral<Character>> hijosC = new ListaEnlazadaGenerica<>();

        ArbolGeneral<Character> D = new ArbolGeneral<Character>('D');
        ListaEnlazadaGenerica<ArbolGeneral<Character>> hijosD = new ListaEnlazadaGenerica<>();

        ArbolGeneral<Character> E = new ArbolGeneral<Character>('E');

        hijosA.agregarFinal(B);
        hijosA.agregarFinal(C);
        hijosA.agregarFinal(D);
        hijosA.agregarFinal(E);

        ArbolGeneral<Character> F = new ArbolGeneral<Character>('F');
        ArbolGeneral<Character> G = new ArbolGeneral<Character>('G');
        ListaEnlazadaGenerica<ArbolGeneral<Character>> hijosG = new ListaEnlazadaGenerica<>();

        hijosC.agregarFinal(F);
        hijosC.agregarFinal(G);

        ArbolGeneral<Character> H = new ArbolGeneral<Character>('H');
        ArbolGeneral<Character> I = new ArbolGeneral<Character>('I');
        ArbolGeneral<Character> J = new ArbolGeneral<Character>('J');
        ListaEnlazadaGenerica<ArbolGeneral<Character>> hijosJ = new ListaEnlazadaGenerica<>();

        ArbolGeneral<Character> K = new ArbolGeneral<Character>('K');
        ArbolGeneral<Character> Z = new ArbolGeneral<Character>('Z');

        hijosD.agregarFinal(H);
        hijosD.agregarFinal(I);
        hijosD.agregarFinal(J);
        hijosD.agregarFinal(K);
        hijosD.agregarFinal(Z);

        ArbolGeneral<Character> L = new ArbolGeneral<Character>('L');

        hijosG.agregarFinal(L);

        ArbolGeneral<Character> M = new ArbolGeneral<Character>('M');
        ArbolGeneral<Character> N = new ArbolGeneral<Character>('N');

        hijosJ.agregarFinal(M);
        hijosJ.agregarFinal(N);

        // seteo los hijos
        A.setHijos(hijosA);
        C.setHijos(hijosC);
        D.setHijos(hijosD);
        G.setHijos(hijosG);
        J.setHijos(hijosJ);

        RedDeAguaPotable red = new RedDeAguaPotable(A);
        
        System.out.println("Mínimo caudal: "+red.minimoCaudal(1000));
    }
    
}
