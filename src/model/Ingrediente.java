package model;

public class Ingrediente extends Producto implements Comparable<Ingrediente> {

    public Ingrediente(String descripción, double price) {
        super(descripción, price);
    }

    @Override
    public int compareTo(Ingrediente o) {
        return this.getDescripción().compareTo(o.getDescripción());
    }

    @Override
    public String toString() {
        return  super.getDescripción() + " - "+   String.format("%.2f",super.getPrice()) + "€";
    }
}
