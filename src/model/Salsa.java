package model;

public class Salsa extends Producto {

    public Salsa(String descripción, double price) {
        super(descripción, price);
    }

    @Override
    public String toString() {
        return  " Salsa: " + super.getDescripción() + " - " + String.format("%.2f",super.getPrice()) + "€";
    }

}
