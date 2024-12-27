import java.util.Objects;
import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exit = String.valueOf('y');
        do {
            System.out.println("Escribe la temperatura en K, ºC o ºF que quieres convertir (k, c o f): ");
            String inicial = in.next();
            double input = Double.parseDouble(inicial.split("[kcf]")[0]);
            if ((inicial.contains("c")) || (inicial.contains("C"))) {
                System.out.println(input + " Celsius ");
                System.out.printf("equals %.2f F", convert(input, 'c', 'f'));
                System.out.printf("equals %.2f K", convert(input, 'c', 'k'));
                System.out.println();
            }
            if ((inicial.contains("k")) || (inicial.contains("K"))) {
                System.out.println(input + " Kelvin ");
                System.out.printf("equals %.2f F", convert(input, 'k', 'f'));
                System.out.printf("equals %.2f C", convert(input, 'k', 'c'));
                System.out.println();
            }
            if ((inicial.contains("f")) || (inicial.contains("F"))) {
                System.out.println("Fahrenheit to..");
            }
            System.out.println("¿Qúieres continuar? (´y´ o ´n´): ");
            exit = in.next();
        }while(!Objects.equals(exit, String.valueOf('n')));
    }

    private static double convert(double valor, char in, char out){
//        double result;
        if(in == 'c' && out == 'k'){
            if ((valor + 273.15) == -0.00) {
                return Math.abs(valor + 273.15);
            }else return (valor + 273.15);
        }
        else if(in == 'k' && out == 'c'){
            if ((valor - 273.15) == -0.00) {
                return Math.abs(valor - 273.15);
            }else return (valor - 273.15);
        }
        else if(in == 'c' && out == 'f'){
            return (((valor*9)/5)+32);
        }
        else return 999;
    }
}
//*ENTRADA/SALIDA*
//Grados centigrados: **15,70**
//Farenheit: 60,26 Kelvin: 288,85

//Grados Farenheit: **45,32**
//Centigrados: 7,4 Kelvin: 280,55

//Grados Kelvin: **345,23**
//Centigrados: 72,08 Farenheit: 161,74
