package Metodos;

public class Coche {

    private String marca, modelo, matricula;
    private int cv, cc, velocidad, kms; // Centímetros cúbicos, km recorridos

    public Coche() {
        this(null, null, null, 0, 0, 0,0);
    }

    public Coche(String marca, String modelo, String matricula, int cv, int cc, int velocidad, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.cc = cc;
        this.velocidad = velocidad;
        this.kms = kms;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getCv() {
        return cv;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getCc() {
        return cc;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getKms() {
        return kms;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }

    public void print(){
        System.out.print("Marca = " + marca);
        System.out.print("   Modelo = " + modelo);
        System.out.print("   Matrícula = " + matricula);
        System.out.print("   CV = " + cv);
        System.out.print("   CC = " + cc);
    }
    
    public int acelerar(int aceleracion){
        int random = (int)(Math.random()*101);
//        if (menos de 100 cv){
//            aceleracion += random* 0 - 100  aleatoria entre 0 y la velocidad indicada
//        }
//        else if(más de 100 cv){
//            aceleracion += random()* 10 - 100  entre 10 y la velocidad indicada
//        }
//        kms += velocidad*(1/2);
        System.out.println("random = " + random);
        return random*aceleracion;
    }
}
