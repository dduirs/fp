package Metodos;

public class Carrera {
//    private Object participante1 = new Object();
//    private Object participante2 = new Object();
    private Coche ganador;
    private int kmTotales, vueltas;

    public void iniciarCarrera(Coche participante1, Coche participante2){
        System.out.println("Los concursantes son: ");
        System.out.printf(" Participante 1 = %s %s   ", participante1.getMarca(),participante1.getModelo());
        System.out.printf(" Participante 2 = %s %s%n", participante2.getMarca(),participante2.getModelo());
        System.out.println("3...");
        System.out.println("    2...");
        System.out.println("        1...");
        System.out.println("            ¡Empezar!");
        ganador = laCarrera(participante1, participante2);
        System.out.printf(" El ganado ha sido el coche con matrícula %s, ¡Enhorabuena!",ganador.getMatricula());
    }

    public Coche laCarrera(Coche participante1, Coche participante2){
        if (participante1.getKms() > participante2.getKms()) return participante1;
        else return participante2;
    }
}
