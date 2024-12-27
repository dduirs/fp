import java.util.Scanner;

public class Numero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numero = new int[5];
        String[] etiquetas = new String[5];
        etiquetas[0] = "Decenas de mil";
        etiquetas[1] = "Unidades de mil";
        etiquetas[2] = "Centenas";
        etiquetas[3] = "Decenas";
        etiquetas[4] = "Unidades";
        StringBuilder resultado = new StringBuilder();
        for(int i = 0; i<numero.length; i++){
            System.out.printf("%s: ",etiquetas[i]);
            resultado.append(in.nextInt());
        }
        System.out.printf("Numero introducido: %s ", resultado);
    }
}
