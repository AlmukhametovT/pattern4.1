package ru.ufa;

public class Potato implements ProductsForSale {
    private int price;
    private String name;

    public Potato(int price) {
        this.name = "Картошка";
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