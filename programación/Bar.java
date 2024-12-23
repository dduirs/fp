import java.util.Scanner;

public class Bar {
    public static void main(String[] args) {
        double precioBeb = 1.25;
        double precioBoc = 2.05;
        Scanner in = new Scanner(System.in);
        System.out.println("El camarero dice: \"¡Buenas! ¿Qúe os pongo?\"");
        System.out.print("¿Cúantas bebidas queréis? ");
        int cantidadBebidas = in.nextInt();
        System.out.print("¿Cúantos bocadillos queréis? ");
        int cantidadComida = in.nextInt();
        System.out.println("Las bebidas cuestan: "+precioBeb*cantidadBebidas+"€");
        System.out.println("Los bocadillos cuestan: "+precioBoc*cantidadComida+"€");
        System.out.println("El total es: "+(int)((precioBeb*cantidadBebidas)+(precioBoc*cantidadComida))+"€");
    }
}
//ENTRADA/SALIDA
//Número de bebidas: 3
//Número de bocadillos: 5
//Coste de las bebidas: 3.75
//Coste de los bocadillos: 10.25
//Coste consumición: 14.0
