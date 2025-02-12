package model;

public class Salsa {
    private String descripción;
    private double price;

    public Salsa(String descripción, double price) {
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
