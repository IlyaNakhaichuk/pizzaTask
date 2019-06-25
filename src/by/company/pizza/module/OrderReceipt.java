package by.company.pizza.module;

class OrderReceipt {
    PizzaOrdering pizzaOrdering = new PizzaOrdering();

    public void createReceiptForTheOrder(){
        System.out.println( "\n********************************" );
        System.out.println( "Заказ: " + pizzaOrdering.getOrderId() );
        System.out.println( "Клиент: " + pizzaOrdering.getClientId() );
        creatingPizzaDetails();
        System.out.println("Общая сумма: "+ "\t\t\t\t" + totalAmountCalculation() + " €");
        System.out.println( "********************************\n" );
    }

    private void creatingPizzaDetails(){
        System.out.println("Название: " + pizzaOrdering.getPizzaName());
        System.out.println("--------------------------------");
        System.out.println(pizzaOrdering.getTypePizza() + "\t\t\t\t\t\t" + pizzaOrdering.singleIngredientPriceCalculation( pizzaOrdering.getTypePizza().toString()) + " €");
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

    private float totalAmountCalculation(){
        return pizzaOrdering.calculatesThePriceOfPizza()*pizzaOrdering.getNumberOfPizzas();
    }
}
