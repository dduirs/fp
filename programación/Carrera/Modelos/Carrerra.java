package Modelos;

public class Carrera {

    private int kmTotales, vueltas;

    public void setKmTotales(int kmTotales) {
        this.kmTotales = kmTotales;
    }

    public int getKmTotales() {
        return kmTotales;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public int getVueltas() {
        return vueltas;
    }

    public Coche iniciarCarrera(Coche participante1, Coche participante2){
        System.out.println("Los concursantes son: ");
        System.out.printf(" Participante 1 = %s %s   ", participante1.getMarca(),participante1.getModelo());
        System.out.printf(" Participante 2 = %s %s%n", participante2.getMarca(),participante2.getModelo());
        System.out.println("3...");
        System.out.println("    2...");
        System.out.println("        1...");
        System.out.println("            ¡Empezar!");
        return laCarrera(participante1, participante2);
    }

    public Coche laCarrera(Coche participante1, Coche participante2){
        for (int i = 0; i < this.vueltas; i++) {
            int random = (int)(Math.random()*100);
            System.out.println(" ##### random en la Carrera = " + random);
            System.out.printf("Vuelta %d of %d: %n",i,vueltas);
            participante1.acelerar(random);
            System.out.printf("\033[0;33m        velocidad participante1 = %d km/h  \033[0m (de %d)  %n", participante1.getVelocidad(), participante1.getVelocidadMaxima());
            participante1.acelerar(-random);
            System.out.printf("\033[0;33m        velocidad participante1 = %d km/h  \033[0m %n", participante1.getVelocidad());
            participante2.acelerar(random);
            System.out.printf("\033[0;34m        velocidad participante2 = %d km/h  \033[0m (de %d) %n", participante2.getVelocidad(), participante2.getVelocidadMaxima());
            participante2.acelerar(-random);
            System.out.printf("\033[0;34m        velocidad participante2 = %d km/h  \033[0m %n", participante2.getVelocidad());
            carreraVisual(participante1, participante2, kmTotales);
        }
//        carreraVisual(participante1, participante2);
        if (participante1.getKms() > participante2.getKms()) return participante1;
        else return participante2;
    }

    public void carreraVisual(Coche participante1, Coche participante2, int kmTotales){
        int denominador;
        denominador = 10;
        for (int i = 0; i < 100; i+= 5) {
            System.out.print("-- ");
        }
        System.out.println();
        System.out.print(" P1 >> ");
        for (int i = 10; i < participante1.getKms(); i+=(kmTotales/10)) {
            System.out.print("  ");
        }
        System.out.print("\uD83D\uDE98");
        System.out.println();
        System.out.print(" P2 >> ");
        for (int i = 10; i < participante2.getKms(); i+=(kmTotales/10)) {
            System.out.print("  ");
        }
        System.out.print("\uD83D\uDE93");
        System.out.println();
        for (int i = 0; i < 100; i+= 5) {
            System.out.print("-- ");
        }
        System.out.println();
    }
}
