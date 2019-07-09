package by.company.pizza.other.version;

import by.company.pizza.old.version.PizzaIngredients;

import java.util.Map;
public interface Pizza {
    void addIngridient(PizzaIngredients ingredients);
    String getName();
    Map<String, Float> getIngridientSet();
}
