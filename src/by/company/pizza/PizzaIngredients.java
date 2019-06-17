package by.company.pizza;

public enum PizzaIngredients {
    TOMATO_PASTE(1), CHEESE(1), SALAMI(1.5f), BACON(0.3f), GARLIC(0.7f), CORN(0.7f), PEPERONI(0.6f),OLIVES(0.5f);
    private float ingredientPrice;
    PizzaIngredients(float price){
        price=ingredientPrice;
    }
    public float getIngredientPrice(){
        return ingredientPrice;
    }
}
