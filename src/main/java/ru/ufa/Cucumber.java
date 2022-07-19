package ru.ufa;

public class Cucumber implements ProductsForSale {
    private int price;
    private String name;

    public Cucumber(int price) {
        this.name = "Огурец";
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