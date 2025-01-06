import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Coches {

    static ArrayList coches = new ArrayList();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        String buscado;
        System.out.println("Introduce los detalles del primer coche. ");
        coches.add(nuevoCoche());
        System.out.println("\033[0;32m Coche añadido correctamente\033[0m");
        boolean repetir = true;
        do {
            System.out.println("""
                    MENU:
                     1. Añadir coche
                     2. Ver colección
                     3. Buscar por marca
                     4. Buscar por matrícula
                     5. Buscar por CV
                     6. Salir""");
            do {
                try {
                    choice = in.nextInt();
                    repetir = false;
                } catch (InputMismatchException e) {
                    System.out.print(" Debes introducir un número: ");
                    in.next();
                }
            } while (repetir);
            repetir = true;
            switch (choice) {
                case 1:
                    System.out.println("Introduce los detalles del coche.");
                    coches.add(nuevoCoche());
                    System.out.println("\033[0;32m Coche añadido correctamente\033[0m");
                    break;
                case 2:
                    if (!coches.isEmpty()) {
                        if(coches.size() != 1){
                            System.out.printf("Hay %d coches en la colección: %n", coches.size());
                        }
                        else {
                            System.out.println("Hay 1 coche en la colección: ");
                        }
                        loopPrint(null, 0, true);
                    }
                    else {
                        System.out.println(" Aún no has añadido coches a la colección");
                    }
                    break;
                case 3:
                    System.out.print("Introduce la\033[0;32m marca\033[0m que quieres buscar: ");
                    buscado = in.next();
                    loopPrint(buscado, 1, true);
                    break;
                case 4:
                    System.out.print("Introduce la\033[0;32m matrícula\033[0m que quieres buscar: ");
                    buscado = in.next();
                    loopPrint(buscado, 0, true);
                    break;
                case 5:
                    System.out.print("Introduce los\033[0;32m CV: \033[0m");
                    buscado = in.next();
                    loopPrint(buscado, 3, true);
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println(" Selección no válida. Elige de nuevo.");
                    break;
            }
        }while(choice != 6);
    }

    private static String[] nuevoCoche(){
        String[] coche = new String[4];
        System.out.print("Introduce la matrícula: ");
        coche[0] = in.next();
        while (loopPrint(coche[0], 0, false)){
            System.out.println(" El record de este coche ya existe.");
            System.out.println(" Introduce otra matrícula: ");
            coche[0] = in.next();
        }
        System.out.print("Introduce la marca: ");
        coche[1] = in.next();
        System.out.print("Introduce el modelo: ");
        coche[2] = in.next();
        System.out.print("Introduce los CV: ");
        coche[3] = in.next();
        return coche;
    }

    private static boolean loopPrint(String identifier, int posicion, boolean printVerbose) {
        String[] etiquetas = new String[]{"Matrícula: ","Marca: ","Modelo: ","CV: "};
        boolean match = false;
        int count = 0;
        for (int i = 0; i < coches.size(); i++) {
            String[] c;
            c = (String[]) coches.get(i);
            if (identifier != null){
                if (Objects.equals(c[posicion], identifier)) {
                    count++;
                    if(printVerbose && (count==1)) {
                        System.out.printf("%n    Resultado de la búsqueda: %n%n");
                    }
                    System.out.print(i+1+")  ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print(etiquetas[j]);
                        if (Objects.equals(c[j], identifier)) {
                            System.out.print("\033[0;32m" + c[j] + "  " + "\033[0m");
                        }
                        else{
                            System.out.print(c[j] + "  ");
                        }
                    }
                    match = true;
                    System.out.println();
                }
            }
            else {
                System.out.print(i+1+")  ");
                for (int j = 0; j < 4; j++) {
                    System.out.print(etiquetas[j]);
                    System.out.print(c[j] + "  ");
                }
                System.out.println();
                match = true;
            }
        }
        if(printVerbose) {
            if(count>0 && coches.size()>1) {
                System.out.printf("%n");
                System.out.println("    (Mostrando " + count + " de " + coches.size() + " coches)");
            }
            if(!match){
                System.out.println(" No se han encontrado resultados");
            }
            System.out.println();
        }
        return match;
    }
}
