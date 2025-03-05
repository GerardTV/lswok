import model.*;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Wok> woks = new ArrayList<>();
        addTestData(woks,10);
        Collections.sort(woks);
        //woks.stream().forEach(System.out::println);
        //filtrarPorPrecio(woks, 15).forEach(System.out::println);
        filtrarPorIngrediente(woks,2,3).forEach(System.out::println);
    }

    private static List<Wok> filtrarPorIngrediente(ArrayList<Wok> woks,int indexIngrediente, int maxIngredientes) {
        return woks.stream().filter(w -> w.getIngredientes().length >= maxIngredientes && w.getIngredientes().length <= maxIngredientes).collect(Collectors.toList());
    }

    private static List<Wok> filtrarPorPrecio(ArrayList<Wok> woks, double precioMaximo) {
        return woks.stream().filter(w -> w.getPrecio() <= precioMaximo).collect(Collectors.toList());
    }

    private static void addTestData(ArrayList<Wok> woks,int numeroWoks) {
        Random random = new Random();
        for (int i = 0; i < numeroWoks; i++) {
            Base base = new Base(
                    DatosWok.basesDesc[random.nextInt(DatosWok.basesDesc.length)],
                    random.nextInt(2)==1?MedidaBase.PEQUEÑA:MedidaBase.GRANDE,
                    DatosWok.basePrecios[random.nextInt(DatosWok.basePrecios.length)]
            );

            Ingrediente[] ingredientes = new Ingrediente[random.nextInt(5) + 1]; // Entre 1 y 5 ingredientes
            for (int j = 0; j < ingredientes.length; j++) {
                int index = random.nextInt(DatosWok.ingredientesDesc.length);
                ingredientes[j] = new Ingrediente(DatosWok.ingredientesDesc[index], DatosWok.preciosIngredientes[index]);
            }

            Salsa salsa = new Salsa(DatosWok.salsas[random.nextInt(DatosWok.salsas.length)], 0);

            woks.add(new Wok(base, ingredientes, salsa));
        }
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
            return new Base(DatosWok.basesDesc[selectedIndex],tamanio==1?MedidaBase.PEQUEÑA: MedidaBase.GRANDE, tamanio);//inline if


        }
        return new Base(DatosWok.basesDesc[selectedIndex],MedidaBase.GRANDE, DatosWok.basePrecios[selectedIndex] );
    }

}