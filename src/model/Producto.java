package model;

public abstract class Producto {
    private String descripción;
    private double price;

    public Producto(String descripción, double price) {
        this.descripción = descripción;
        this.price = price;
    }

    public String getDescripción() {
        return descripción;
    }

    public double getPrice() {
        return price;
    }
}
