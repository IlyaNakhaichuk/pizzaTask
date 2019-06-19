package by.company.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OrderingPizzaUI {
    private final Scanner scanner;
    private OrderReceipt orderReceipt = new OrderReceipt();

    public OrderingPizzaUI(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println( "******************************************************" );
        System.out.println( "1. Введите название пиццы. " );
        System.out.println( "2. Введите количество пицц. " );
        System.out.println( "3. Выберите ингредиенты из приведенного списка. " );
        System.out.println( "4. Отобразить чек заказа. " );
        System.out.println( "5. Изменить состав заказа." );
        System.out.println( "6. Оформить заказ и вывести чек" );
        System.out.println( "******************************************************" );
    }

    private void printMenuIngredient() {
        System.out.println( "---************************************************---" );
        System.out.println( "1. TOMATO_PASTE " );
        System.out.println( "2. CHEESE " );
        System.out.println( "3. SALAMI " );
        System.out.println( "4. BACON " );
        System.out.println( "5. GARLIC " );
        System.out.println( "6. CORN " );
        System.out.println( "7. PEPPER " );
        System.out.println( "8. PEPERONI " );
        System.out.println( "9. OLIVES " );
        System.out.println("10. Выход на стартовое меню.");
        System.out.println( "---************************************************---" );
    }

    public void start() throws IllegalArgumentException {
        if (this.scanner != null) {
            int key;
            printMenu();
            do {
                //printMenu();
                System.out.println( "Ввыберите пункт меню: " );
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        System.out.println( "------------------------------------------------" );
                        System.out.print( "Задайте название пиццы: " );
                        try {
                            String str = new BufferedReader( new InputStreamReader( System.in ) ).readLine();
                            orderReceipt.pizzaOrdering.setPizzaName( str );
                        } catch (IOException ex) {
                            ex.getStackTrace();
                        }
                        System.out.println( "\n------------------------------------------------" );
                        printMenu();
                        break;
                    case 2:
                        System.out.println( "------------------------------------------------" );
                        System.out.print( "Укажите количество пицц: " );
                        try {
                            int number = Integer.parseInt( new BufferedReader( new InputStreamReader( System.in ) ).readLine() );
                            orderReceipt.pizzaOrdering.setNumberOfPizzas( number );
                        } catch (IOException ex) {
                            ex.getStackTrace();
                        }
                        System.out.println( "\n------------------------------------------------" );
                        printMenu();
                        break;
                    case 3:
                        System.out.println( "Выберите ингредиенты для своей пиццы(не более 4):" );
                        printMenuIngredient();
                        addIngredients();
                        printMenu();
                        break;
                    case 4:
                        orderReceipt.createReceiptForTheOrder();
                        printMenu();
                        break;
                    case 5:
                        deleteIngredients();
                        printMenu();
                        break;
                    case 6:
                        System.exit( -1 );
                        break;
                    default:
                        throw new IllegalArgumentException( "Вы ввели неверное значение меню." );
                }
            } while (key != 6);
        }
    }

    private void addIngredients() throws IllegalArgumentException {
        if (this.scanner != null) {
            int key;
            do {
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.TOMATO_PASTE );
                        break;
                    case 2:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.CHEESE );
                        break;
                    case 3:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.SALAMI );
                        break;
                    case 4:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.BACON );
                        break;
                    case 5:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.GARLIC );
                        break;
                    case 6:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.CORN );
                        break;
                    case 7:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.PEPPER );
                        break;
                    case 8:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.PEPERONI );
                        break;
                    case 9:
                        orderReceipt.pizzaOrdering.addIngredient( PizzaIngredients.OLIVES );
                        break;
                    case 10:
                        break;
                    default:
                        throw new IllegalArgumentException( "Данного ингридиента не существует\n" );
                }
                System.out.println("Добавленные элементы:");
                orderReceipt.pizzaOrdering.displayAddedIngredients();
            } while (key != 10);
        }
    }
    private void deleteIngredients() throws IllegalArgumentException {
        if (this.scanner != null) {
            int key;
            do {
                key = this.scanner.nextInt();
                orderReceipt.pizzaOrdering.deleteIngredientFromTheList( orderReceipt.pizzaOrdering.getIngridient(--key ) );
                System.out.println("Добавленные элементы:");
                orderReceipt.pizzaOrdering.displayAddedIngredients();
            } while (key != 4);
        }
    }

}