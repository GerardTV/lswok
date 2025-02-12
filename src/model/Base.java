package model;

public class Base {
    private String descripción;
    private String tamanio;
    private double price;

    public Base(String descripción, String tamanio, double price) {
        this.descripción = descripción;
        this.tamanio = tamanio;
        this.price = price;
    }

    public String getDescripción() {
        return descripción;
    }

    public String getTamanio() {
        return tamanio;
    }

    public double getPrice() {
        return price;
    }
}
