package by.company.pizza.other.version;

import by.company.pizza.old.version.PizzaIngredients;

import java.util.HashMap;
import java.util.Map;

public class ClosePizza implements Pizza {
    private String name;
    private Map<String, Float> ingridientSet = new HashMap<>();

    public ClosePizza(String name) {
        this.name = name;
        ingridientSet.put( PizzaIngredients.CALSONE.name(), PizzaIngredients.CALSONE.getIngredientPrice());
    }

    @Override
    public void addIngridient(PizzaIngredients ingredients) {
        if(!ingridientSet.containsKey(ingredients)){
            ingridientSet.put(ingredients.name(), ingredients.getIngredientPrice());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Float> getIngridientSet() {
        return ingridientSet;
    }


}
