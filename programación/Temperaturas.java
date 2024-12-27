import java.util.Objects;
import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exit;
        String inicial = "";
        double input = 0.00;
        do {
        boolean inputValid = false;
            while(!inputValid) {
                try {
                    System.out.println("Escribe la temperatura que quieres convertir en Kelvin (K), C o F: ");
                    inicial = in.nextLine();
                    input = Double.parseDouble(inicial.split("[kcfKCF]")[0]);
                    inputValid = true;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException _) {
                    System.out.println("~ ~ El formato no es correcto. ~ ~ \n");
                }
            }
            if ((inicial.contains("k")) || (inicial.contains("K"))) {
                System.out.printf(" Grados Kelvin: ** %.2f ** %n", input);
                input = convert(input, 'k');
                System.out.printf(" Centigrados: %.2f   ", input);
                input = convert(input, 'c');
                System.out.printf(" Farenheit: %.2f %n", input);
            }
            else if ((inicial.contains("c")) || (inicial.contains("C"))) {
                System.out.printf(" Grados Centigrados: ** %.2f ** %n", input);
                input = convert(input, 'c');
                System.out.printf(" Farenheit: %.2f   ", input);
                input = convert(input, 'f');
                System.out.printf("Kelvin: %.2f %n", input);
            }
            else if ((inicial.contains("f")) || (inicial.contains("F"))) {
                System.out.printf(" Grados Farenheit: ** %.2f ** %n", input);
                input = convert(input, 'f');
                System.out.printf(" Kelvin: %.2f   ", input);
                input = convert(input, 'k');
                System.out.printf("Centigrados: %.2f %n", input);
            }
            else System.out.println("~ ~ No has escrito la unidad. ~ ~");
            System.out.print("  ¿Qúieres continuar? (´y´ o ´n´): ");
            exit = in.nextLine();
            System.out.println();
        } while (!Objects.equals(exit, String.valueOf('n')));
    }

    private static double convert(double valor, char tipoIn){
        if(tipoIn == 'k'){
            double c;
            c = valor - 273.15;
            return (c);
        }
        else if(tipoIn == 'c'){
            double f;
            f = ((valor*((double)9/5))+32);
            return (f);
        }
        else{
            return ((valor-32)*((double)5/9) + 273.15);
        }
    }
}
//*ENTRADA/SALIDA*
//Grados centigrados: **15,70**
//Farenheit: 60,26 Kelvin: 288,85
