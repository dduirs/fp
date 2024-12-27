// import java.util.InputMismatchException;
import java.util.Scanner;

public class CosteBar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cantidad;
        double precio;
        String[] producto = new String[2];
        double[] totalPrecio = new double[2];
        producto[0] = "bebida";
        producto[1] = "bocadillo";
        System.out.println("           ARTICULO             CANTIDAD    PRECIO      COSTE");
        System.out.println("           =========            ========    ======      =====");
        for(int i=0; i<producto.length; i++) {
//            try {} catch (InputMismatchException e){}
            do {
                System.out.printf("Número de %ss (entre 0 y 20): ", producto[i]);
                cantidad = in.nextInt();
            } while (cantidad < 0 | cantidad > 20);
            do {
                System.out.printf("   Precio de cada %ss (entre 0,00 y 3,00): ", producto[i]);
                precio = in.nextDouble();
            } while (precio < 0.00 | precio > 3.00);
            totalPrecio[i] = cantidad*precio;
            System.out.printf("        Total %s     Cantidad: %d  Precio: %.2f  Coste: %.2f %n",producto[i], cantidad, precio, totalPrecio[i]);
        }
        System.out.print("Número de gente: ");
        int gente = in.nextInt();
        System.out.printf("COSTE TOTAL (la cuenta): %.2f    ",(totalPrecio[0]+totalPrecio[1]));
        System.out.printf("Coste por persona: %.2f",(totalPrecio[0]+totalPrecio[1])/gente);
    }
}
