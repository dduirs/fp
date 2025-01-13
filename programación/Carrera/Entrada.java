import Metodos.Coche;
import Metodos.Carrera;
import java.util.Scanner;

public class Entrada {

    static Scanner in = new Scanner(System.in);
//    static String[] infoCoches = new String[]{"Escribe la marca del coche: ","modelo: ","matricula: ","cv: ","cc: "};
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        String a;
        Coche coche1 = new Coche("Seat", "Arona", "YOU123",95,999,0,0);
//        https://www.autobild.es/coches/seat/arona/arona-5-2021/10-tsi-95-cv/ficha-tecnica
        Coche coche2 = new Coche("Maserati", "Quattroporte", "WINNER1",580, 3799,
                0,10);
//        https://www.autobild.es/coches/maserati/quattroporte/quattroporte-trofeo-4-2020/v8-47247/ficha-tecnica
//        coche1 = (
////            System.out.println(" = " + coche.acelerar(18));
        coche1.print();
        System.out.println();
        coche2.print();
        System.out.printf("%n¿Quieres usar estes coche?   (S o N): ");
        a = in.next();
        if(a.equalsIgnoreCase("s")) {
            carrera.iniciarCarrera(coche1,coche2);
        }
        else{
            System.out.println("Ponte en contacto con los organizadores");
        }
    }
}

//En esta clase existirá un método main con la siguiente funcionalidad
//- Crea dos coches con los datos que tú quieras
//- Crea una carrera con los datos que tú quieras
//- Asocia los coches en la carrera
//- Inicia la carrera y comprueba que los datos sean correcto
