import model.*;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Base base = obtenerBase(scan);
        Ingrediente[] ingredientes = obtenerIngredientes(scan);
        Salsa salsa = obtenerSalsa(scan);
        Wok wok = new Wok(base,ingredientes,salsa);
        System.out.println("El precio de tu wok es: "+  wok.getPrecio());
    }

    private static Salsa obtenerSalsa(Scanner scan) {
        //TODO: pedir al suaurio que salsa quiere
        return null;
    }

    private static Ingrediente[] obtenerIngredientes(Scanner scan) {
        //TODO:pedir al usuario todos los ingredientes
        return null;
    }

    private static Base obtenerBase(Scanner scan) {
        //TODO:pedir al usuario los datos de la base
        return null;
    }


}