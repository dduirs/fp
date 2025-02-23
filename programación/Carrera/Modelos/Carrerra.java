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
        System.out.println("            ¡Vamos!");
        return laCarrera(participante1, participante2);
    }

    public Coche laCarrera(Coche participante1, Coche participante2){
        for (int i = 0; i < this.vueltas; i++) {
            int random = (int)(Math.random()*100);
            System.out.printf("Vuelta %d de %d: %n",i,vueltas);
            System.out.println("    Participante 1: " + participante1.getMatricula());
            participante1.acelerar(random);
            System.out.printf("\033[0;33m        Velocidad participante 1 = %d km/h  \033[0m (de %d)  %n", participante1.getVelocidad(), participante1.getVelocidadMaxima());
            System.out.println("\n    Participante 2: " + participante2.getMatricula());
            participante2.acelerar(random);
            System.out.printf("\033[0;34m        Velocidad participante 2 = %d km/h  \033[0m (de %d) %n", participante2.getVelocidad(), participante2.getVelocidadMaxima());

            carreraVisual(participante1, participante2, kmTotales);
        }
        if (participante1.getKms() > participante2.getKms()) return participante1;
        else return participante2;
    }

    public void carreraVisual(Coche participante1, Coche participante2, int kmTotales){

        for (int i = 0; i < 100; i+= 5) {
            System.out.print("-- ");
        }
        System.out.println();
        System.out.print(" P1 >> ");
        for (int i = 10; i < participante1.getKms(); i+=(kmTotales/10)) {
            System.out.print("  ");
        }
        System.out.print("\uD83D\uDE99");
        System.out.println();
        System.out.print(" P2 >> ");
        for (int i = 10; i < participante2.getKms(); i+=(kmTotales/10)) {
            System.out.print("  ");
        }
        System.out.print("\uD83C\uDFCE\uFE0F");
        System.out.println();
        for (int i = 0; i < 100; i+= 5) {
            System.out.print("-- ");
        }
        System.out.println();
    }
}
