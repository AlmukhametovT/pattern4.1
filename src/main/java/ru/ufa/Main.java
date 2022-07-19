package ru.ufa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductsForSale product1 = new Bread(40);
        ProductsForSale product2 = new Milk(50);
        ProductsForSale product3 = new SourCream(60);
        ProductsForSale product4 = new Cucumber(70);
        ProductsForSale product5 = new Tomato(80);
        ProductsForSale product6 = new Potato(10);

        ProductsForSale[] products = {product1, product2, product3, product4, product5, product6};
        int[] prices = new int[products.length];

        for (int i = 0; i < products.length - 1; i++) {
            prices[i] = products[i].getPrice();
        }

        System.out.println("Список возможных товаров для покупки:");

        // принцип избегания магических чисел в строках 16,26,29,50,62
        // можем увеличивать массив с продуктами и с ценами на них без последствия для программы
        for (int i = 0; i < prices.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        int[] inBasket = new int[prices.length];
        int sumProducts = 0; // итоговая сумма чека
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите товар и количество или введите \"end\":");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if (!checkInput(input)) {
                System.out.println("необходимо ввести номер товара из списка и через пробел его количество");
                continue;
            }
            String[] parts = input.split(" ");

            // Don’t Repeat Yourself
            // получение числового значения и проверка его корректности проводится дважды
            // что бы не дублировать код, создали метод с параметром и применили в строках 48 и 49
            int productNumber = getIntValue(parts[0]); // номер продукта
            int productCount = getIntValue(parts[1]); // кол-во продуктов
            if (productNumber < 1 || productCount < 0 || productNumber > products.length) {
                System.out.println("номер продукта должен быть в диапазоне указанных выше значений");
                System.out.println("количество продукта должно быть положительным числом");
                System.out.println("данная позиция учтена не будет!");
                continue;
            }
            inBasket[productNumber - 1] += productCount;
            int currentPrice = prices[productNumber - 1]; // стоимость продукта
            sumProducts += currentPrice * productCount;
        }
        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара   " + "Количество   " + "Цена/за.ед   " + "Общая стоимость");
        for (int i = 0; i < prices.length; i++) {
            if (inBasket[i] != 0) {
                System.out.printf("%-22s %-11d %-12d %-14d \n", products[i], inBasket[i], prices[i], inBasket[i] * prices[i]);
            }
        }
        System.out.printf("%41s %9d", "Итого ", sumProducts);
    }

    public static boolean checkInput(String input) {
        if (input.indexOf(" ") == -1) {
            return false;
        } else if (input.indexOf(" ") != input.lastIndexOf(" ")) {
            return false;
        }
        return true;
    }

    public static int getIntValue(String input) {
        try {
            int intValue = Integer.parseInt(input);
            return intValue;
        } catch (NumberFormatException e) {
            System.out.println("необходимо указать целое положительное число для значения номер продукта и количество");
        }
        return -1;
    }
}

// SOLID
//        S - принцип единственной ответственности (Single Responsibility Principle)
//        Класс должен выполнять только те функции, для которых он логически предназначен.
//в классе Main создается список продуктов и происходит общение с клиентом (формируется корзина)
//класс MainNest для теста методов класса Main, классы продуктов для описания продуктов
//
//        O - принцип открытости/закрытости (Open Closed Principle)
//        Программные сущности должны быть открыты для расширения, но закрыты для модификации.
//мы можем добавить новые продукты для продажи имплементируя интерфейс ProductsForSale,
//который обязывает реализовывать метод получения цены продукта.
//при этом имена продуктов закрыты для изменения, цена же может меняться.
//
//        L - принцип замены Барбары Лисков (Liskov Substitution Principle)
//        Наследуй только тогда, когда можешь играть роль за предка.
//у нас есть класс Monitor, в котором есть метод getPrice, схожий по названию с методом интерфейса ProdutsForSale
//при этом они не связаны отношением наследования, т.к. монитор может присоединяться к компьютеру, продукты этого не могут.
//
//        I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
//        Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.
//у нас 2 интерфейса, но не все классы их наследуют, например монитору не надо следить за сроком годности
//так же у картофеля большой срок, поэтому предпочтем не считать дни срока годности,
//зато молочные продукты сметана и молоко реализуют методы обоих интерфейсов
