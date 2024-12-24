import java.util.Scanner;

public class Compra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double conIVA;
        double sinIVA;
        double iva;
        int percentIVA;
        do {
            System.out.println("Introduzca el valor con IVA (Entre 0,00€ y 500,00€): ");
            conIVA = in.nextDouble();
        } while (conIVA < 0 || conIVA > 500);
        do {
            System.out.println("Introduzca el % del IVA (Entre 0 y 25%): ");
            percentIVA = in.nextInt();
        } while (percentIVA < 0 || percentIVA > 25);
        iva = conIVA/100*percentIVA;
        sinIVA = conIVA-iva;
        System.out.printf("Compra: %.2f",sinIVA);
        System.out.println();
        System.out.printf("IVA: %.2f",iva);
    }
}
//Valor de la compra (entre 0.00 y 500.00):**298.45**
//IVA (entre 0 y 25%):**12**
//Compra: 262.64
//IVA: 35.81
