package Ejercicio2.punto3;

/**
 *
 * @author diiego-pc
 */
public class Estudiante {
    private String nom;
    private String ape;
    private int comision;
    private String mail;
    private String direccion;

    public Estudiante(){
        
    }
    
    public Estudiante(String nombre, String apellido, String email, String direccion, int comision) {
        setNom(nombre);
        setApe(apellido);
        setMail(email);
        setDireccion(direccion);
        setComision(comision);
    }
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String tusDatos(){
        return "Estudiante: "+getNom()+" "+getApe()+" "+getMail()+" "+getDireccion()+" "+getComision();
    }
    


}