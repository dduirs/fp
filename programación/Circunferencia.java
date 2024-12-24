import java.util.Scanner;

public class Circunferencia {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe un radio entero: ");
        int radio = in.nextInt();
        double circun = radio*2*Math.PI;
        double area = Math.PI*(radio*radio);
        System.out.printf("Longitud de la circunferencia: %.14f",circun);
        System.out.println();
        System.out.printf("Area de circulo: %.13f", area);
    }
}
//*ENTRADA/SALIDA*
//Escribe un radio entero: **15**
//Longitud de la circunferencia: 94.24777960769379
//Area de circulo: 706.8583470577034
