package Metodos;

import java.util.ArrayList;

public class Metodo {

    private ArrayList Fibonacci = new ArrayList();

    public ArrayList sumarRecursiva(int a, int b, int maximo) {
        if (b < maximo) {
            sumarRecursiva(b, a + b, maximo);
        }
        Fibonacci.add(b);
        return Fibonacci;
    }
}
// Golden ratio = 1.6180339887498948482
