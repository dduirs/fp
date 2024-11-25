//Se valorará el uso de métodos (functions)
//Utilizarlas estructuras de control: switch para poder decidir la partes del programa
    //que se deben ejecutar

import java.util.Arrays;
import java.util.Objects;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("                        ¡Bienvenidos a la sala de BINGO!");
        System.out.println();
        Scanner teclado = new Scanner(System.in);
        String continua;
        int juegoID = 1;
        int[] carton;
        int numSalidos;
        int apuestaEuros = 0;
        int apuestaVeces = 0;
        boolean repetir = true;
        do {
            do {
                try {
                    System.out.print("Introduce la cantidad que quieres apostar en euros (€): ");
                    apuestaEuros = teclado.nextInt();
                    repetir = false;
                } catch (InputMismatchException e) {
                    System.out.println("\033[0;33m" + "          vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" + "\033[0m");
                    System.out.println("\033[1;0m" + "           ¡Debes introducir un número!  " + "\033[0m");
                    System.out.println("\033[4;33m" + "          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^          " + "\033[0m");
                    teclado.next();
                    }
            } while (repetir);
            repetir = true;
            do {
                try {
                    System.out.print("Introduce la cantidad de números en la que te acertaras el bingo: ");
                    apuestaVeces = teclado.nextInt();
                    if (apuestaVeces > 100) System.out.println("\033[1;37m"+"         ¡No puede ser más de 100 veces!  "+"\033[0m");
                    else repetir = false;
                } catch (InputMismatchException e) {
                    System.out.println("\033[0;33m" + "          vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" + "\033[0m");
                    System.out.println("\033[1;0m" + "           ¡Debes introducir un número!  " + "\033[0m");
                    System.out.println("\033[4;33m" + "          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^          " + "\033[0m");
                    teclado.next();
                }
            }while (repetir);
            carton = generarArray(10);
            System.out.println("Número de juego: "+juegoID+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            juegoID++;
            numSalidos = jugar(carton);
            System.out.println("    - para cantar bingo (10 números): "+numSalidos);
            System.out.println();
//            apuestaVeces = numSalidos; //para hacer trampa
            System.out.println("Has apuestado:          "+apuestaVeces+ " veces               por: "+apuestaEuros+" €");
            System.out.println(" `````````````````````````````````````````````````````````````");
            if(apuestaVeces == numSalidos) {
                System.out.println("                                                     | ");
                System.out.println("     Has acertado la cantidad de números correcto!   |");
                System.out.println("                                                     v ");
                System.out.println("        ¡Enhorabuena! Has ganado un premio de:      "+apuestaEuros*10+" €");
                System.out.println("                                                ````````````");
            }
            else{
                System.out.println("     ¡No has acertado la cantidad de números correcto!   ");
            }
            System.out.println(" `````````````````````````````````````````````````````````````");
            System.out.println();
            System.out.println("¿Quieres jugar otra vez?        Escribe ´s´ para continua o ´n´ para salir  ");
            continua = teclado.next();
            repetir = true;
        }
        while (Objects.equals(continua, "s"));
    }

    static int[] generarArray(int x){
        int[] carton = new int[x];
        int i = 0;
        int numero;
        System.out.println("Números aleatorios (cartón):");
        System.out.print("    ");
        do{
            numero = generarNumero();
            System.out.print("    "+numero);
            if(!(coincidencia(numero,carton,carton.length))) {
                carton[i] = numero;
                i++;
            }
        }
        while (i < carton.length);
        System.out.println();
        System.out.println();
        return carton;
    }

    static int generarNumero(){
        return ((int) (Math.random()*100)+1);
    }

    static boolean coincidencia(int numero, int[] carton, int cartonLength){
        int x = 0;
        while(x < cartonLength) {
            if (numero != carton[x]) x++;
            else{
//                System.out.println("   ~    !!! Coincidencia = "+numero);
                return true;
            }
        }
        return false;
    }

    static int jugar(int[] carton){
        int x = 0;
        int s = 0;
//        int contador = 0;
        int acierto;
        String[] acertados = new String[carton.length];
        int[] salidos = new int[100];
        String[] salidosPrint = new String[100];
        int primeros5 = 0;
        do {
            acierto = generarNumero();
            if (!(coincidencia(acierto, salidos, s + 1))) {
                if (coincidencia(acierto, carton, carton.length)) {
                    acertados[x] = "\033[0;32m" + String.valueOf(acierto) + "\033[0m";
                    salidosPrint[s] = "\033[0;32m" + String.valueOf(acierto) + "\033[0m";
                    salidos[s] = acierto;
                    System.out.println("                             vvvvvv");
                    System.out.println("                             | " + ((acierto<10) ? " "+salidosPrint[s]:salidosPrint[s]) + " |");
                    System.out.println("                             ^^^^^^");
//                    System.out.println(" ^ x = " + x + "                     ^^^^^^");
                    if (x == 4) primeros5 = s + 1;
                    x++;
                }
//                else {
//                    System.out.println("            Incorrecto:" + acierto);
//                }
                if (salidosPrint[s] == null) salidosPrint[s] = String.valueOf(acierto);
                salidos[s] = acierto;
                s++;
            }
//        contador++;
//        System.out.println("< "+contador+" >            Acierto incorrecto:" + acierto);
        }
        while(x < carton.length);
        System.out.println();
        System.out.println(" `````````````````````````````````````````````````````````````");
        System.out.println("                         ~       ¡BINGO!     ~   ");
        System.out.println("Cartón:          "+Arrays.toString(carton));
        System.out.println("Coincidencias:   "+"\033[0;32m"+Arrays.toString(acertados)+"\033[0m");
        System.out.println("Números cantados:         ");
        for (int i = 10; i < s+10; i+=10) {
            for (int j = i-10; j < i; j+=1) {
                if(salidosPrint[j] != null) System.out.print("    " + salidosPrint[j]);
            }
            System.out.println("        ");
        }
        System.out.println();
        System.out.println("Cantidad de números que han tenido que salir (no repetidos):");
        System.out.println("    - para cantar línea (5 números) : "+primeros5);
        return s;
    }
}
