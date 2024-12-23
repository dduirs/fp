public class Segundos {
    public static void main(String[] args) {
        int s = 24973;
        int min = s/60;
        s -= (min*60);
        int h = min/60;
        min -= h*60;
        System.out.println("Horas: " +h);
        System.out.println("Minutos: "+min);
        System.out.println("Segundos: "+s);
    }
}
//*ENTRADA/SALIDA*
//Horas: 6
//Minutos: 56
//Segundos: 13
