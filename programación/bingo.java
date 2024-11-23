import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] carton = generarArray(10);
        printCards(carton);
//        Arrays.sort(carton);
//        printCards(carton);
        jugar(carton);
        printCards(carton);
    }

    static int[] generarArray(int x){
        int[] carton = new int[x];
        int i = 0;
        int numero;
        do{
            numero = generarNumero();
//            System.out.println(" Numero = "+numero);
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
                System.out.println("   ~    !!! Coincidencia = "+numero);
                return true;
            }
        }
        return false;
    }

    static void printCards(int[] cards){
        System.out.println("Cartón:                        "+Arrays.toString(cards));
    }

    static void jugar(int[] carton){
//        int[] aciertos = generarArray(100);
        int x = 0;
        int s = 0;
//        int contador = 0;
        int acierto;
        int[] acertados = new int[carton.length];
        int[] salidos = new int[100];
//        Arrays.fill(salidos, -1);
//        do{
        do {
            acierto = generarNumero();
            if (!(coincidencia(acierto, salidos, s + 1))) {
                if (coincidencia(acierto, carton, carton.length)) {
                    acertados[x] = acierto;
                    salidos[s] = acierto;
                    System.out.println("                             vvvvvv");
                    System.out.println("                  ! Correcto:| " + acierto + " |");
                    System.out.println(" ^ x = " + x + "                     ^^^^^^");
                    x++;
                } else{
                    System.out.println("            Incorrecto:" + acierto);
                }
                salidos[s] = acierto;
                s++;

            }
//                contador++;
//                System.out.println("< "+contador+" >            Acierto incorrecto:" + acierto);
        }
        while(x < carton.length);
//        }
//        while(!(Arrays.compare(carton, acertados)==0));

        System.out.println("    ~        ¡Has ganado!      ~   ");
        Arrays.sort(acertados);
        System.out.println("Aciertos correctos (acertados=):"+Arrays.toString(acertados));
        Arrays.sort(salidos);
        System.out.println(" Aciertos salidos:"+Arrays.toString(salidos));
        printCards(carton);
        Arrays.sort(carton);
    }

//    static int int guardarYincrementar(){
//
//    }

//    static void jugar(int[] carton){
//        int x = 0;
//        int acierto;
//        int[] acertados = new int[10];
//        do{
//            acierto = generarNumero();
//            if(coincidencia(acierto, carton)){
//                acertados[x] = acierto;
//                System.out.println("                             vvvvvv");
//                System.out.println("          ! Acierto correcto:| "+acierto+" |");
//                System.out.println(" ^ x = "+x+"                     ^^^^^^");
//                x++;
//            }
//            System.out.println("            Acierto incorrecto:"+acierto);
//        }
//        while(x < 10);
//        System.out.println("    ~        ¡Has ganado!      ~   ");
//        System.out.println("Aciertos correctos (acertados=):"+Arrays.toString(acertados));
//    }
}
