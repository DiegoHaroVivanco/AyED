package Ejer5;

/**
 *
 * @author diiego-pc
 */
public class Ejercicio5 {
    
    private static int max;
    private static int min;
    private static double promedio;
    
    public static void main(String[] args) {
        int [] arrayNum = {1, 4, 10, -5, 25, 20, 8, 2};
        System.out.println(funcion1(arrayNum)); // punto 1

        Datos datos = new Datos();
        funcion2(arrayNum, datos); //punto 2
        System.out.println(datos);
        
        funcion3(arrayNum); //punto 3
        System.out.println(max+"\n"+min+"\n"+promedio);
    }
    
    public static Datos funcion1(int[] numeros){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double prom = 0;
        
        for(int n : numeros){
            prom +=n;
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }
        return new Datos(max, min, prom / numeros.length);
    
    }
    public static void funcion2(int[] numeros, Datos datos){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double prom = 0;        
       
         for(int n : numeros){
            prom +=n;
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }
        datos.setMax((max));
        datos.setMin((min));
        datos.setProm((prom / numeros.length));
    
    }

    public static void funcion3(int [] numeros){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double prom = 0; 

        for(int n : numeros){
            prom +=n;
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }        
        Ejercicio5.max = max;
        Ejercicio5.min = min;
        Ejercicio5.promedio = prom / numeros.length;
        
    }

}
