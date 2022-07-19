package ru.ufa;

public class Tomato implements ProductsForSale {
    private int price;
    private String name;

    public Tomato(int price) {
        this.name = "Помидор";
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}