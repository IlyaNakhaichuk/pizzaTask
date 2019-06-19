package by.company.pizza;

public class OrderReceipt {
    PizzaOrdering pizzaOrdering = new PizzaOrdering();
    {
        System.out.println( "********************************" );
        System.out.println( "Заказ: " + pizzaOrdering.getOrderNumber() );
        System.out.println( "Клиент: " + pizzaOrdering.getClientIsNumber() );
    }
    public void createReceiptForTheOrder(){
        System.out.println("Название: " + pizzaOrdering.getPizzaName());
        System.out.println("--------------------------------");
        for (Object ingredient: pizzaOrdering.getIngredientList().toString().replaceAll( "\\]|\\[|\\ ", "" ).split( "," )) {
            System.out.println(ingredient.toString()
                    + ((ingredient.toString().length()>8)?"\t\t\t\t":(ingredient.toString().length()>6)? "\t\t\t\t\t":"\t\t\t\t\t\t")
                    + pizzaOrdering.singleIngredientPriceCalculation( ingredient.toString() ) + " €");
        }
        System.out.println("--------------------------------");
        System.out.println("Всего: \t\t\t\t\t\t" + pizzaOrdering.calculatesThePriceOfPizza() + " €");
        System.out.println("Кол-во: \t\t\t\t\t\t" + pizzaOrdering.getNumberOfPizzas());
        System.out.println("--------------------------------");


    }
}
