import Modelos.Coche;
import Modelos.Carrera;
import java.util.Scanner;

public class Entrada {

    static Scanner in = new Scanner(System.in);
//    static String[] infoCoches = new String[]{"Escribe la marca del coche: ","modelo: ","matricula: ","cv: ","cc: "};

    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        String a;
        Coche coche1 = new Coche("Seat", "Arona", "YOU123",95,999,182, 11.5, 0,0);
//        https://www.autobild.es/coches/seat/arona/arona-5-2021/10-tsi-95-cv/ficha-tecnica
        Coche coche2 = new Coche("Maserati", "Quattroporte", "WINNER1",580, 3799, 326, 4.5,
                0,0);
//        https://www.autobild.es/coches/maserati/quattroporte/quattroporte-trofeo-4-2020/v8-47247/ficha-tecnica
        coche1.print("yellow");
        System.out.println();
        coche2.print("blue");
        System.out.printf("%n¿Quieres usar estes coche?   (S o N): ");
        a = in.next();
        if(a.equalsIgnoreCase("s")) {
            System.out.println("Entra la longitud de la carrera: ");
            carrera.setKmTotales(in.nextInt());
            System.out.println("Entra el numero de vueltas: ");
            carrera.setVueltas(in.nextInt());
            Coche ganador = carrera.iniciarCarrera(coche1,coche2);
            if(ganador.getKms()<carrera.getKmTotales()){
                System.out.println("\n .........La carrera ha sido extendida........");
                ganador = carrera.laCarrera(coche1, coche2);
            }
            System.out.printf(" El ganado ha sido el coche con matrícula %s, ¡Enhorabuena!", ganador.getMatricula());
        }
        else{
            System.out.println("Pone en contacto con los organizadores para entrar otros coches");
        }
    }
}
