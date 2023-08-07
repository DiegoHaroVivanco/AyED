package Ejercicio4;
import Ejercicio3.PilaGenerica;

public class TestBalanceo {
    
    public static boolean iguales(char c1, char c2){
        if((c1 == '(') && (c2 ==')')){
            return true;
        }
        if((c1 == '[') &&(c2 == ']')){
            return true;
        }
        if((c1 == '{') && (c2 =='}')){
            return true;
        }
        return false;
    }
    public static boolean esApertura(char c){
        return (c == '(') || (c == '[') || (c == '{');
    }
    
    public static boolean valido(char c){
        return (c == '(') || (c == '[') || (c == '{') ||(c == ')') || (c == ']') || (c == '}') ;
    }
    
    public static boolean verificar(String cadena){
        PilaGenerica<Character> pila = new PilaGenerica<Character>();
    
        if(cadena.equals("")){ // .equals? si la cadena está vacia, está balanceado
            return true;
        }
        for (int i = 0; i < cadena.length(); i++) {
            Character c = cadena.charAt(i);

            if(valido(c.charValue())){ //si es un caracter valido apilo o desapilo según corresponda
                if(esApertura(c)){
                    pila.apilar(c);
                }else{
                    Character topPila = pila.desapilar(); // desapilo lo que está en el tope para comparar
                    if(!iguales(topPila, c)){ // si no es de cierre el str no está balanceado
                        return false;
                    }
                }
            }
        }
        // si la pila está vacía, el str está balanceado, de lo contrario devolvería false arriba    
        return pila.esVacia();
    }
    
    public static void main(String[] args) {
        if(verificar("{ ( ) [ ( ) ] }")){
            System.out.println("La cadena está balanceada");
        }else{
            System.out.println("La cadena no está balanceada");
        }

        if(verificar("( [ ) ] ")){
            System.out.println("La cadena está balanceada");
        }else{
            System.out.println("La cadena no está balanceada");
        }
        
    }
    
}
