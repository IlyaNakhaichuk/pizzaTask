package by.company.pizza;

import by.company.pizza.module.OrderingPizzaUI;

import java.util.Scanner;

public class PizzaMain {
    public static void main(String[] args) {
        new OrderingPizzaUI(new Scanner( System.in ) ).start();

    }
}
