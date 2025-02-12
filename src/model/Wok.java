package model;

public class Wok {
    private Base base;
    private Ingrediente[] ingredientes;
    private Salsa salsa;
    private double precio;

    public Wok(Base base,Ingrediente[] ingredientes,  Salsa salsa) {
        this.base = base;
        this.ingredientes = ingredientes;
        this.salsa = salsa;
        calcularPrecio();
    }

    private void calcularPrecio() {
        //TODO: Calcular el precio i establecer el valor atributo precio.
    }

    public double getPrecio() {
        return precio;
    }
}
