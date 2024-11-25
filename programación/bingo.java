//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//Se valorará el uso de métodos (functions)

// DONE: Utilizar un arrays para guardad los 10 números del carton
// DONE: Utilizar Math.random() para generar los aleatorios
//Utilizarlas estructuras de control DONE: if, DONE: do while, switch para poder decidir la partes del programa
    //que se deben ejecutar

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("                        ¡Bienvenidos a la sala de BINGO!");
        System.out.println(" ");
        Scanner teclado = new Scanner(System.in);
        String continua;
        int juegoID = 1;
        int[] carton;
        int numSalidos;
        int apuestaEuros;
        int apuestaVeces;
        do {
            System.out.println("Introduce la cantidad que quieres apostar en euros (€): ");
            apuestaEuros = teclado.nextInt();
            System.out.println("Introduce la cantidad de números en la que te acertaras el bingo: ");
            apuestaVeces = teclado.nextInt();
            carton = generarArray(10);
            System.out.println("Número de juego: "+juegoID+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            juegoID++;
            numSalidos = jugar(carton);
            System.out.println("    - para cantar bingo (10 números): "+numSalidos);
            System.out.println(" ");
//            apuestaVeces = numSalidos; //para hacer trampa
            System.out.println("Has apuestado:          "+apuestaVeces+ " veces               por: "+apuestaEuros+" €");
            if(apuestaVeces == numSalidos) {
                System.out.println("                                                     | ");
                System.out.println("     Has acertado la cantidad de números correcto!   |");
                System.out.println("                                                     v ");
                System.out.println("        ¡Enhorabuena! Has ganado un premio de:      "+apuestaEuros*10+" €");
            }
            else{
                System.out.println(" ");
                System.out.println("     ¡No has acertado la cantidad de números correcto!   ");
            }
            System.out.println(" ");
            System.out.println("¿Quieres jugar otra vez?        Escribe ´s´ para continua o ´n´ para salir  ");
            continua = teclado.next();
        }
        while (Objects.equals(continua, "s"));
    }

    static int[] generarArray(int x){
        int[] carton = new int[x];
        int i = 0;
        int numero;
        do{
            numero = generarNumero();
//            System.out.println(" Numero aleatorio = "+numero);
            if(!(coincidencia(numero,carton,carton.length))) {
                carton[i] = numero;
                i++;
            }
        }
        while (i < carton.length);
        return carton;
    }

    static int generarNumero(){
        return ((int) Math.round(Math.random()*100));
    }

    static boolean coincidencia(int numero, int[] carton, int cartonLength){
        int x = 0;
        while(x < cartonLength) {
            if (numero != carton[x]) {
                x++;
            }
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
//                    System.out.println("                             vvvvvv");
//                    System.out.println("                  ! Correcto:| " + acierto + " |");
//                    System.out.println(" ^ x = " + x + "                     ^^^^^^");
                    if (x == 4) {
                        primeros5 = s + 1;
                    }
                    x++;
                }
//                else {
////                    System.out.println("            Incorrecto:" + acierto);
//                }
                if (salidosPrint[s] == null) {
                    salidosPrint[s] = String.valueOf(acierto);
                }
                salidos[s] = acierto;
                s++;
            }
        }
        while(x < carton.length);
//                contador++;
//                System.out.println("< "+contador+" >            Acierto incorrecto:" + acierto);

        System.out.println("                             ~       ¡BINGO!     ~   ");
//        Arrays.sort(acertados);
//        Arrays.sort(salidos);
//        Arrays.sort(carton);
        System.out.println("Cartón:          "+Arrays.toString(carton));
        System.out.println("Coincidencias:   "+"\033[0;32m"+Arrays.toString(acertados)+"\033[0m");
        System.out.println("Números cantados:         ");
        for (int i = 10; i < s+10; i+=10) {
//            System.out.println("            ");
            for (int j = i-10; j < i; j+=1) {
                if(salidosPrint[j] != null){
//                    if(Integer.parseInt(salidosPrint[j]) < 10) System.out.print(" ");
//                    System.out.println("length of "+salidosPrint[j]+" is "+salidosPrint[j].length());
                    System.out.print("  "+salidosPrint[j]+"  ");
                }
            }
            System.out.println("        ");
        }
//        for(String numeros: salidosPrint) {
//            System.out.print(" "+numeros+", ");
//        }
//        System.out.println("Números:         "+ Arrays.toString(salidosPrint));
        System.out.println(" ");
        System.out.println("Cantidad de números que han tenido que salir (no repetidos):");
        System.out.println("    - para cantar línea (5 números) : "+primeros5);
        return s;
    }
}
