package model;

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

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Wok o) {
        return this.getPrecio() < o.getPrecio() ? -1 : this.getPrecio() == o.getPrecio() ? 0 : 1;
    }
}
