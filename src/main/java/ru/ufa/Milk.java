package ru.ufa;

public class Milk implements ProductsForSale, ShortLivedProducts {
    private int price;
    private String name;

    public Milk(int price) {
        this.name = "Молоко";
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

    @Override
    public boolean checkExpirationDate() {
        return false;
    }
}