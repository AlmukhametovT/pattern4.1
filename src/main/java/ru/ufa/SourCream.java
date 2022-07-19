package ru.ufa;

public class SourCream implements ProductsForSale, ShortLivedProducts {
    private int price;
    private String name;

    public SourCream(int price) {
        this.name = "Сметана";
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