package model;

public class Base extends Producto{
    private String tamanio;


    public Base(String descripción, String tamanio, double price) {
        super(descripción, price);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }
}
