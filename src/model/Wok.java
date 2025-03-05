package model;

import java.util.Arrays;

public class Wok implements Comparable<Wok> {
    private static int woksVendidos = 0;
    private Base base;
    private Ingrediente[] ingredientes;
    private Salsa salsa;
    private double precio;

    public Wok(Base base,Ingrediente[] ingredientes,  Salsa salsa) {
        this.base = base;
        this.ingredientes = ingredientes;
        this.salsa = salsa;
        calcularPrecio();
        woksVendidos++;
    }

    private void calcularPrecio() {
        double totalPrecio = base.getPrice();
        for (Ingrediente ingrediente : ingredientes) {
            totalPrecio += ingrediente.getPrice();
        }
        totalPrecio += salsa.getPrice();
        this.precio = totalPrecio;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Wok o) {
        return this.getPrecio() < o.getPrecio() ? -1 : this.getPrecio() == o.getPrecio() ? 0 : 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.base.toString() + "\n");
        result.append(" Ingredientes: ");
        for (Ingrediente i : this.ingredientes){
            result.append(i.toString()).append(", ");
        }
        result.append("\n").append(this.salsa.toString()).append("\n");
        result.append(" Precio Total: " + String.format("%.2f",precio) + "€\n");
        return result.toString();
    }
}
