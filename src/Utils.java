import java.util.Scanner;

public class Utils {
    public static int leerInt(Scanner scanner, String s) {
        int numero;
        while(true){
            System.out.println(s);
            if(scanner.hasNextInt()){
                numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            }else{
                System.out.println("ERROR: Por favor introduzca un volorentero válido.");
                scanner.next();
            }
        }
    }
    public static int leerInt(Scanner scanner, String s, int min, int max ) {
        int numero;
        while(true){
            numero = leerInt(scanner,s);
            if (numero >= min && numero <= max){
                return numero;
            }else{
                System.out.println("ERROR: Introduzco un valor entre " + min + " y " + max+".");
            }
        }
    }
}
