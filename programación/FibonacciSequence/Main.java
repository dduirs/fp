import Metodos.Metodo;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList result;
        Metodo sumar = new Metodo();
        result = sumar.sumarRecursiva(0,1, 1200000000);
        result.sort(null);
        System.out.println("result = " + result.toString());
    }

}
