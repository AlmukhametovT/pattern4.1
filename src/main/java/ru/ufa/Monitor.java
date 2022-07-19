package ru.ufa;

public class Monitor {
    private int price;
    private String name;

    public int getPrice() {
        return price;
    }

    public void connectToPC(String pcName) {
        System.out.println("Меня подключили к компьютеру +" + pcName);
    }
}