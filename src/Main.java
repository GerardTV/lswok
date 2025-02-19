import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int i = Utils.leerInt(scan, "Introduce el numero de woks que quieres pedir",1,5);
        ArrayList<Wok> woks = new ArrayList<>();
       for (int j = 0; j < i; j++) {
            Wok wok = pedirWok(scan);
            System.out.println("El precio de tu wok es: "+  wok.getPrecio());
            woks.add(wok);
        }
        Collections.sort(woks);
        i = 0;
    }

    private static Wok pedirWok(Scanner scan) {
        Base base = obtenerBase(scan);
        Ingrediente[] ingredientes = obtenerIngredientes(scan);
        Salsa salsa = obtenerSalsa(scan);
        return new Wok(base, ingredientes, salsa);
    }

    private static Salsa obtenerSalsa(Scanner scan) {
        System.out.println("Seleccione una salsa (ingrese el número correspondiente):");
        for (int i = 0; i < DatosWok.salsas.length; i++) {
            System.out.println((i + 1) + ". " + DatosWok.salsas[i]);
        }

        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine(); // Consume the newline character
        return new Salsa(DatosWok.salsas[selectedIndex], 0); // Assuming price is not needed for Salsa
    }

    private static Ingrediente[] obtenerIngredientes(Scanner scan) {
        System.out.println("Seleccione los ingredientes (ingrese los números separados por comas):");
        for (int i = 0; i < DatosWok.ingredientesDesc.length; i++) {
            System.out.println((i + 1) + ". " + DatosWok.ingredientesDesc[i] + " - " + DatosWok.preciosIngredientes[i] + "€");
        }

        String input = scan.nextLine();
        String[] selectedIndices = input.split(",");
        Ingrediente[] selectedIngredientes = new Ingrediente[selectedIndices.length];

        for (int i = 0; i < selectedIndices.length; i++) {
            int index = Integer.parseInt(selectedIndices[i].trim()) - 1;
            selectedIngredientes[i] = new Ingrediente(DatosWok.ingredientesDesc[index], DatosWok.preciosIngredientes[index]);
        }

        return selectedIngredientes;
    }

    private static Base obtenerBase(Scanner scan) {
        System.out.println("Seleccione una base (ingrese el número correspondiente):");
        for (int i = 0; i < DatosWok.basesDesc.length; i++) {
            System.out.println((i + 1) + ". " + DatosWok.basesDesc[i] + " - " + DatosWok.basePrecios[i] + "€");
        }

        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine(); // Consume the newline character
        if( DatosWok.baseTamanioConfigurable[selectedIndex]){
            int tamanio = Utils.leerInt(scan, "Seleccione el tamaño de la base (1. Pequeño, 2. Grande)", 1, 2);
            return new Base(DatosWok.basesDesc[selectedIndex],tamanio==1?"PEQUEÑO":"GRANDE", tamanio);
        }
        return new Base(DatosWok.basesDesc[selectedIndex],"GRANDE", DatosWok.basePrecios[selectedIndex] );
    }

}