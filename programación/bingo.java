import java.util.Arrays;
import java.util.Objects;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println();
        System.out.println("                        ¡Bienvenidos a la sala de BINGO!");
        System.out.println();
        Scanner teclado = new Scanner(System.in);
        String continuar;
        int juegoID = 1;
        int[] carton;
        int numSalidos;
        int cartera;
        int apuestaEuros = 0;
        int apuestaVeces = 0;
        boolean repetir = true;
        System.out.print("¿Cúantos euros has traído?: ");
        cartera = teclado.nextInt();
        do {
            while (cartera < 10){
                System.out.println("\033[0;33m         Debes tener más de 10€ para jugar...  \033[0m");
                System.out.print("¿Cúantos euros quieres sacar de tu cuenta bancaria? ");
                cartera += teclado.nextInt();
            }
            do {
                try {
                    System.out.print("Introduce la cantidad que quieres apostar en euros (€): ");
                    apuestaEuros = teclado.nextInt();
                    if (apuestaEuros > cartera) {
                        System.out.println("\033[0;33m         Solo te quedan "+cartera+"€ \033[0m");
                    }
                    else if (apuestaEuros >= 0 && apuestaEuros < 10) System.out.println("\033[0;33m         Eres muy responsable... ¡pero vive un poco! Apuesta al menos 10€\033[0m");
                    else if (apuestaEuros < 0) {
                        System.out.println("\033[0;33m         Debes apostar una cantidad positiva de €...  \033[0m");
                    }
                    else repetir = false;
                } catch (InputMismatchException e) {
                    System.out.println("\033[0;33m          vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\033[0m");
                    System.out.println("\033[1;0m           ¡Debes introducir un número!  \033[0m");
                    System.out.println("\033[4;33m          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^          \033[0m");
                    teclado.next();
                }
            } while (repetir);
            repetir = true;
            do {
                try {
                    System.out.print("Introduce la cantidad de números en la que acertarás el bingo: ");
                    apuestaVeces = teclado.nextInt();
                    if (apuestaVeces > 100 || apuestaVeces < 10) {
                        System.out.println("\033[0;33m         ¡No puede ser menos de 10 o más de 100!  \033[0m");
                    } else repetir = false;
                } catch (InputMismatchException e) {
                    System.out.println("\033[0;33m          vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\033[0m");
                    System.out.println("\033[1;0m           ¡Debes introducir un número!  \033[0m");
                    System.out.println("\033[4;33m          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^          \033[0m");
                    teclado.next();
                }
            }while (repetir);
            carton = generarArray(10);
            System.out.println(" `````````````````````````````````````````````````````````````");
            System.out.println("Juego "+juegoID+"  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            juegoID++;
            numSalidos = jugar(carton);
            System.out.println("    - para cantar bingo (10 números): "+numSalidos);
            System.out.println();
//            apuestaVeces = numSalidos; //para hacer trampa
            System.out.println("Has apostado:          "+apuestaVeces+ " veces               por: "+apuestaEuros+" €");
            System.out.println(" `````````````````````````````````````````````````````````````");
            if(apuestaVeces == numSalidos) {
                System.out.println("                                                     | ");
                System.out.println("     Has acertado la cantidad de números correcta!   |");
                System.out.println("                                                     v ");
                System.out.println("        ¡Enhorabuena! Has ganado un premio de:      "+apuestaEuros*10+" €");
                System.out.println("                                                ````````````");
                cartera += apuestaEuros*10;
            }
            else{
                System.out.println("     ¡No has acertado la cantidad de números correcta!   ");
                cartera -= apuestaEuros;
            }
            System.out.println(" `````````````````````````````````````````````````````````````");
            System.out.println("\033[0;33m        Tienes "+cartera+"€ en la cartera \033[0m");
            System.out.println(" `````````````````````````````````````````````````````````````");
            System.out.println();
            System.out.println("¿Quieres jugar otra vez?        Escribe ´s´ para continuar o ´n´ para salir  ");
            continuar = teclado.next();
            repetir = true;
        }
        while (Objects.equals(continuar, "s"));
    }

    public static int[] generarArray(int x){
        int[] carton = new int[x];
        int i = 0;
        int numero;
        do{
            numero = generarNumero();
            if(!(coincidencia(numero,carton,carton.length))) {
                carton[i] = numero;
                i++;
            }
        }
        while (i < carton.length);
        return carton;
    }

    public static int generarNumero(){
        return ((int) (Math.random()*100)+1);
    }

    public static boolean coincidencia(int numero, int[] carton, int cartonLongitud){
        int x = 0;
        while(x < cartonLongitud) {
            if (numero != carton[x]) x++;
            else return true;
        }
        return false;
    }

    public static int jugar(int[] carton){
        int x = 0;
        int s = 0;
        int acierto;
        String[] acertados = new String[carton.length];
        int[] salidos = new int[100];
        String[] salidosPrint = new String[100];
        int primeros5 = 0;
        do {
            acierto = generarNumero();
            if (!(coincidencia(acierto, salidos, s + 1))) {
                if (coincidencia(acierto, carton, carton.length)) {
                    acertados[x] = "\033[0;32m" + acierto + "\033[0m";
                    salidosPrint[s] = "\033[0;32m" + acierto + "\033[0m";
                    salidos[s] = acierto;
                    System.out.println("                             vvvvvv");
                    System.out.println("                             | " + ((acierto<10) ? " "+salidosPrint[s]:salidosPrint[s]) + " |");
                    System.out.println("                             ^^^^^^");
                    if (x == 4) primeros5 = s + 1;
                    x++;
                }
                if (salidosPrint[s] == null) salidosPrint[s] = String.valueOf(acierto);
                salidos[s] = acierto;
                s++;
            }
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
        System.out.println("Cantidad de números que han tenido que salir (no repetidos): ");
        System.out.println("    - para cantar línea (5 números) : "+primeros5);
        return s;
    }
}
