package by.company.pizza.other.version;

import java.util.List;

public class Reciept {

    void printResiept(List<Pizza> pizzaList) {
        float tottalPrice = 0;
        for (Pizza pizza : pizzaList) {
            float price = 0;
            for (Float aFloat : pizza.getIngridientSet().values()) {
                price += aFloat;
            }
            tottalPrice += price;
            System.out.println("blablalba " + pizza.getName() + "   price " + price);
        }

        System.out.println("total price" + tottalPrice);


    }
}
