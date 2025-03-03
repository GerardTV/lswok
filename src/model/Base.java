package model;

public class Base extends Producto{
    private MedidaBase tamanio;


    public Base(String descripción, MedidaBase tamanio, double price) {
        super(descripción, price);
        this.tamanio = tamanio;
    }

    public MedidaBase getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return super.getDescripción() + " " + this.getTamanio() + " - " + String.format("%.2f",this.getPrice()) + "€";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + (this.getTamanio() == MedidaBase.PEQUEÑA ? 0 : 1);
    }
}
