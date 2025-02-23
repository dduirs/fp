import Modelos.Coche;
import Modelos.Carrera;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList coches = new ArrayList();
        boolean exit = false;
        int menu;
        Carrera carrera = new Carrera();
        Coche coche100 = new Coche("Seat", "Arona", "YOU123", 95, 999, 182, 11.5, 0, 0);
        coches.add(coche100);
        Coche coche200 = new Coche("Maserati", "Quattroporte", "WIN8881", 580, 3799, 326, 4.5, 0, 0);
        coches.add(coche200);
        do{
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("    1. Empezar una carrera");
            System.out.println("    2. Ver coches en el garaje");
            System.out.println("    3. Comprar (crear) coche nuevo");
            System.out.println("    4. Ver datos de la carrera");
            System.out.println("    5. Editar carrera");
            System.out.println("    6. Salir del juego (no recomendado)");
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            menu = in.nextInt();
            switch (menu) {
                case 1:
                    if(coches.size() > 1){
                        System.out.println("Elige dos concursantes: ");
                        for (int i = 0; i < coches.size(); i++) {
                            Coche cocheElegido;
                            cocheElegido = (Coche) coches.get(i);
                            cocheElegido.print(i+1);
                        }
                        System.out.println();
                        System.out.print("Coche 1 = ");
                        Coche coche1 = (Coche) coches.get(in.nextInt()-1);
                        System.out.print("Coche 2 = ");
                        Coche coche2 = (Coche) coches.get(in.nextInt()-1);
                        System.out.println("Los concursantes son: ");
                        coche1.print("yellow");
                        System.out.println();
                        coche2.print("blue");
                        System.out.printf("%n¿Quieres usar estos coches?   (S o N): ");
                        String a;
                        a = in.next();
                        if (a.equalsIgnoreCase("s")) {
                            System.out.println();
                            System.out.println(" Km = " + carrera.getKmTotales());
                            System.out.println(" Numero de vueltas = " + carrera.getVueltas());
                            System.out.println();
                            Coche ganador = carrera.iniciarCarrera(coche1, coche2);
                            if (ganador.getKms() < carrera.getKmTotales()) {
                                System.out.println("\n .........La carrera ha sido extendida........");
                                ganador = carrera.laCarrera(coche1, coche2);
                            }
                            System.out.println();
                            System.out.printf(" El ganador ha sido el coche con matrícula %s. ¡Enhorabuena!%n", ganador.getMatricula());
                        } else {
                            System.out.println();
                            System.out.println("Ponte en contacto con los organizadores para registrar otros coches.");
                        }
                        break;
                    }else{
                        System.out.println("Solo hay un coche disponible. Debes registrar otros coches antes de empezar una carrera.");
                        break;
                    }
                case 2:
                    System.out.println("        ~~~        GARAJE       ~~~");
                    Coche cocheElegido;
                    for (int i = 0; i < coches.size(); i++) {
                        cocheElegido = (Coche) coches.get(i);
                        if(i%2==0){
                            cocheElegido.print("yellow");
                        }else{
                            cocheElegido.print("blue");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    Coche coche;
                    coche = new Coche(null, null, null, 0, 0, 0, 0, 0, 0);
                    System.out.print("Introduce marca: ");
                    coche.setMarca(in.next());
                    System.out.print("Introduce modelo: ");
                    coche.setModelo(in.next());
                    System.out.print("Introduce matricula: ");
                    coche.setMatricula(in.next());
                    System.out.print("Introduce CV: ");
                    coche.setCv(in.nextInt());
                    System.out.print("Introduce CC: ");
                    coche.setCc(in.nextInt());
                    System.out.print("Introduce velocidad máxima: ");
                    coche.setVelocidadMaxima(in.nextInt());
                    coches.add(coche);
                    System.out.println();
                    break;
                case 4:
                    System.out.println(" Km = " + carrera.getKmTotales());
                    System.out.println(" Numero de vueltas = " + carrera.getVueltas());
                    System.out.println();
                    break;
                case 5:
                    System.out.print(" Introduce la longitud de la carrera:     ");
                    carrera.setKmTotales(in.nextInt());
                    System.out.print(" Introduce el número de vueltas:          ");
                    carrera.setVueltas(in.nextInt());
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    break;
            }
        }while(!exit);


    }

}
