public class Calculadora {
    public static void main(String[] args) {
        final int a = 24;
        final int b = 7;
        System.out.println("Suma:" + (a + b));
        System.out.println("Resta:" + (a - b));
        System.out.println("Multiplicación:" + (a * b));
        System.out.println("División entera:" + (a / b));
        System.out.println("Resto:" + (a % b));
        System.out.println("División real:" + ((double) a / b));
        System.out.println("Resto real:" + (double) (a % b));
    }
}
