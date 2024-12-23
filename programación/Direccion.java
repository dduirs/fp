import java.util.Scanner;

public class Direccion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String nombre = in.nextLine();
        System.out.println("Escribe tus apellidos: ");
        String apellido = in.nextLine();
        System.out.println("Escribe tu dirección (nombre de la calle): ");
        String calle = in.nextLine();
        System.out.println("Escribe el número de la calle: ");
        String numero = in.nextLine();
        System.out.println("Escribe el número del portal: ");
        String portal = in.nextLine();
        System.out.println("Escribe el número del piso: ");
        String piso = in.nextLine();
        System.out.println("Escribe la letra del piso: ");
        String letra = in.nextLine();
        System.out.println("Escribe la localidad: ");
        String local = in.nextLine();
        System.out.println("Escribe la provincia: ");
        String prov = in.nextLine();
        System.out.println("Escribe el código postal: ");
        String codigo = in.nextLine();
        System.out.println("Escribe el país: ");
        String pais = in.nextLine();

        System.out.println(nombre+" "+apellido);
        System.out.println("C/ " + calle + " n.º " + numero + ", portal " + portal + ", " + piso + letra);
        System.out.println(local + ", " + prov + " " + codigo);
        System.out.println(pais);
    }
}
