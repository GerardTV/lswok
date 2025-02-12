package model;

public class Ingrediente {
    private String descripción;
    private double price;

    public Ingrediente(String descripción, double price) {
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
