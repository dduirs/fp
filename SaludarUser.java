import java.util.Scanner;

public class SaludarUser{
    public static void main(String[] args){
        System.out.println("Hola " + new SaludarPerso().saludar());
    }
    public String saludar(){;
        Scanner personName = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = personName.nextLine();
        return name;
    }
}
