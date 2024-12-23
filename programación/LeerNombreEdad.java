import java.util.Scanner;

public class LeerNombreEdad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ESCRIBE TU NOMBRE COMPLETO: ");
        String nombreCompleto = in.nextLine();
        System.out.println("ESCRIBE TU EDAD: ");
        String edad = in.nextLine();
        System.out.println("Te llamas "+nombreCompleto);
        System.out.println("Tienes "+edad+" años");
    }
}
