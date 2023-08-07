package Ejercicio5;
import ejercicio1.ArbolGeneral;
import tp02.ejercicio2.*;
import tp03.ColaGenerica;
/**
 *
 * @author diiego
 */
public class AreaEmpresa {
    private String ID;
    private Integer tardanza;

    public AreaEmpresa(){
        
    }
    
    public AreaEmpresa(String ID, Integer tardanza){
        this.ID = ID;
        this.tardanza = tardanza;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getTardanza() {
        return tardanza;
    }

    public void setTardanza(Integer tardanza) {
        this.tardanza = tardanza;
    }

    public Integer devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol){
        ColaGenerica <ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        ArbolGeneral<AreaEmpresa> arbolAux;
        Integer sumaNodos = 0, cantNodos = 0,max = -1;
        Integer promedio = 0;
        if(arbol != null){
            cola.encolar(arbol);
            cola.encolar(null);
            while(!cola.esVacia()){
                arbolAux = cola.desencolar();
                if(arbolAux != null){
                    cantNodos++;
                    sumaNodos += arbolAux.getDato().getTardanza();
                    if(arbolAux.tieneHijos()){
                        ListaGenerica<ArbolGeneral<AreaEmpresa>> lHijos = arbolAux.getHijos();
                        lHijos.comenzar();
                        while(!lHijos.fin()){
                            cola.encolar(arbolAux.getHijos().proximo());
                        }
                    }
                }else{
                    // saco antes el promedio y el máximo por las dudas el árbol venga con un sólo nodo
                    promedio = sumaNodos / cantNodos;
                    cantNodos = 0; // reseteo contadores para el siguiente nivel
                    sumaNodos = 0;  
                    if(promedio > max){
                        max = promedio;
                    }
                    if(!cola.esVacia()){
                    cola.encolar(null);
                    }
                }
            }
                return promedio;
        }
        return -1;
    } 
}
