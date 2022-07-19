package ru.ufa;

public class Bread implements ProductsForSale {
    private int price;
    private String name;

    public Bread(int price) {
        this.name = "Хлеб";
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