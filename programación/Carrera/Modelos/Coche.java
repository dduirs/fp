package Modelos;

public class Coche {

    private String marca, modelo, matricula;
    private int cv, cc, velocidadMaxima, velocidad, kms; // Centímetros cúbicos, km recorridos
    private double zeroCien;

    public Coche() {
        this(null, null, null, 0, 0, 0, 0, 0, 0);
    }

    public Coche(String marca, String modelo, String matricula, int cv, int cc, int velocidadMaxima, double zeroCien, int velocidad, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.cc = cc;
        this.velocidadMaxima = velocidadMaxima;
        this.zeroCien = zeroCien;
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

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
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

    public void print(String color){ //mostrar datos
        if(color == "yellow") {
            System.out.print("\033[0;33m Marca = \033[0m" + marca);
            System.out.print("\033[0;33m   Modelo = \033[0m" + modelo);
            System.out.print("\033[0;33m   CV = \033[0m" + cv);
            System.out.print("\033[0;33m    Velocidad máxima = \033[0m" + velocidadMaxima);
            System.out.printf("%n\033[0;33m   Matrícula = \033[0m" + matricula);
            System.out.print("\033[0;33m                     CC = \033[0m" + cc);
            System.out.printf("\033[0;33m    Aceleración de 0-100 en %.1f s\033[0m", zeroCien);
        }
        else {
            System.out.print("\033[0;34m Marca = \033[0m" + marca);
            System.out.print("\033[0;34m   Modelo = \033[0m" + modelo);
            System.out.print("\033[0;34m   CV = \033[0m" + cv);
            System.out.print("\033[0;34m    Velocidad máxima = \033[0m" + velocidadMaxima);
            System.out.printf("%n\033[0;34m Matrícula = \033[0m" + matricula);
            System.out.print("\033[0;34m                     CC = \033[0m" + cc);
            System.out.printf("\033[0;34m    Aceleración de 0-100 en %.1f s\033[0m", zeroCien);
        }
    }

    public void acelerar(int aceleracion){
            int velocidadAcelerado = 0;
            velocidadAcelerado = (int) (Math.random() * aceleracion);
            if (aceleracion > 0) {
                if((this.velocidad + velocidadAcelerado) <= this.velocidadMaxima) {
                    if(velocidadAcelerado>10){
                        this.velocidad += velocidadAcelerado;
                    } else if (this.getCv() >= 100) {
                        this.velocidad += velocidadAcelerado + 10;
                    }
                }
                if(this.velocidad >= this.velocidadMaxima-20){
                    System.out.println("    \033[0;33m   !!!!!!!!!! Velocidad Maxima casi alcanzado \033[0m");
                }
                System.out.println("        **** ** ** velocidadAcelerado = " + velocidadAcelerado);
                this.kms += velocidad / 2;
                System.out.printf("     car %s        kms recorridos %d %n", this.matricula, this.kms);
            }
            //para decelerar un velocidad con valor negativo
            else if ((this.velocidad + velocidadAcelerado) > 100) {
                this.velocidad += velocidadAcelerado;
            }
    }
}
