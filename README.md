﻿# Задача Магазин  
## Правила чистого кода и принципы SOLID


### принцип избегания магических чисел  
в строках 16,26,29,50,62 класса Main  
можем увеличивать массив с продуктами и с ценами на них без последствия для программы  

### Don’t Repeat Yourself  
получение числового значения и проверка его корректности проводится дважды  
что бы не дублировать код, создали метод с параметром и применили в строках 48 и 49 класса Main  

### SOLID  
*S - принцип единственной ответственности (Single Responsibility Principle)*  
Класс должен выполнять только те функции, для которых он логически предназначен.  
в классе Main создается список продуктов и происходит общение с клиентом (формируется корзина)  
класс MainTest для теста методов класса Main, классы продуктов для описания продуктов  

*O - принцип открытости/закрытости (Open Closed Principle)*
Программные сущности должны быть открыты для расширения, но закрыты для модификации.
мы можем добавить новые продукты для продажи имплементируя интерфейс ProductsForSale,
который обязывает реализовывать метод получения цены продукта.
при этом имена продуктов закрыты для изменения, цена же может меняться.

*L - принцип замены Барбары Лисков (Liskov Substitution Principle)*
Наследуй только тогда, когда можешь играть роль за предка.
у нас есть класс Monitor, в котором есть метод getPrice, схожий по названию с методом интерфейса ProdutsForSale
при этом они не связаны отношением наследования, т.к. монитор может присоединяться к компьютеру, продукты этого не могут.

*I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)*
Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.
у нас 2 интерфейса, но не все классы их наследуют, например монитору не надо следить за сроком годности
так же у картофеля большой срок, поэтому предпочтем не считать дни срока годности,
зато молочные продукты сметана и молоко реализуют методы обоих интерфейсов