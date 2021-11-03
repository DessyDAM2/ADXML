package XML;

import java.io.Serializable;

public class Perro implements Serializable {

    private static final long serialVersionUID = 1L;
    private  String raza;
    private  String pelaje;
    private  String sexo;
    private  int edad;
    private  double peso;

    public Perro(){

    }

    public Perro(String raza, String color, String sexo, int edad, int peso) {
        this.raza = raza;
        this.pelaje = color;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
    }

    public String getRaza(String s) {
        return raza;
    }
    public void setRaza(String raza){this.raza = raza;  }

    public String getPelaje(String s){
        return pelaje;
    }
    public void setPelaje(String pelaje){ this.pelaje = pelaje; }

    public String getSexo(String s) {
        return sexo;
    }
    public void setSexo(String sexo){ this.sexo = sexo; }

    public String getEdad(int i){
        return edad + "años";
    }
    public void setEdad(int edad){ this.edad = edad;   }

    public String getPeso(int i){
        return peso + "Kg";
    }
    public void setPeso(int peso){this.peso = peso;}


    public void ladra(){
        System.out.println("Guau guau");
    }
    public void aulla(){
        System.out.println("Auuuuuuuu");
    }



}
