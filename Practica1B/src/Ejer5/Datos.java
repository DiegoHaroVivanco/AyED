
package Ejer5;

/**
 *
 * @author diiego-pc
 */
public class Datos {
    private int max;
    private int min;
    private double prom;
    
    public Datos(){
        
    }
    
    public Datos(int max, int min, double prom){
        this.max = max;
        this.min = min;
        this.prom = prom;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }

    @Override
    public String toString(){
        return "Valor máximo del arreglo: " + getMax()+ "\n"
                +"Valor mínimo del arreglo: "+ getMin()+ "\n"
                +"Promedio de valor del array: "+ getProm();
    }
    


}
