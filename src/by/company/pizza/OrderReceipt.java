package by.company.pizza;

public class OrderReceipt {
    PizzaOrdering pizzaOrdering = new PizzaOrdering();
    public void createReceiptForTheOrder(){
        System.out.println("********************************");
        System.out.println("Заказ: " + pizzaOrdering.getOrderNumber());
        System.out.println("Клиент: " + pizzaOrdering.getClientIsNumber());
        System.out.println("Название: " + pizzaOrdering.getPizzaName());
        System.out.println("--------------------------------");
        for (Object ingredient: pizzaOrdering.getIngredientList().toString().replaceAll( "\\]|\\[|\\ ", "" ).split( "," )) {
            System.out.println(ingredient + "");
        }

    }
}
