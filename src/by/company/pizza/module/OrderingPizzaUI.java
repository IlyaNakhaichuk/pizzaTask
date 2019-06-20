package by.company.pizza.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OrderingPizzaUI {
    private final Scanner scanner;
    private OrderReceipt orderReceipt = new OrderReceipt();

    public OrderingPizzaUI() {
        this.scanner = new Scanner( System.in );
    }

    private void printStartMenu(){
        System.out.println("1.Закзать пиццу");
        System.out.println("2.Заказать ещё одну пиццу");
    }

    private void printOrderMenu() {
        System.out.println( "******************************************************" );
        System.out.println( "1. Ввести/изменить название пиццы. " );
        System.out.println( "2. Ввести/изменить количество пицц. " );
        System.out.println( "3. Выбрать/изменить основание пиццы. " );
        System.out.println( "4. Выберать ингредиенты из приведенного списка. " );
        System.out.println( "5. Отобразить чек заказа. " );
        System.out.println( "6. Изменить состав заказа." );
        System.out.println( "7. Оформить заказ и вывести чек" );
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

    public void start(){
        if (this.scanner != null) {
            int keyboardInput = 0;
            printStartMenu();
            do {
                try{
                    System.out.print( "Ввыберите пункт меню: " );
                    keyboardInput = this.scanner.nextInt();
                    switch (keyboardInput) {
                        case 1:
                            runOrderMenu();
                            printStartMenu();
                            break;
                        case 2:
                            new OrderingPizzaUI().runOrderMenu();
                            printStartMenu();
                            break;
                        case 3:
                            System.exit( -1 );
                            break;
                        default:
                            throw new IllegalArgumentException( "Вы ввели неверное значение меню. Если хотите выйти введите 3.");
                    }
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } while (keyboardInput < 3 && keyboardInput>0);
        }
    }

    private void runOrderMenu() {
        if (this.scanner != null) {
            int keyboardInput = 0;
            printOrderMenu();
            do {
                try{
                System.out.print( "Ввыберите пункт меню: " );
                keyboardInput = this.scanner.nextInt();
                switch (keyboardInput) {
                    case 1:
                        addNamePizza();
                        printOrderMenu();
                        break;
                    case 2:
                        addPizzaNumber();
                        printOrderMenu();
                        break;
                    case 3:
                        addBaseName();
                        printOrderMenu();
                        break;
                    case 4:
                        addIngredients();
                        printOrderMenu();
                        break;
                    case 5:
                        try {
                            orderReceipt.createReceiptForTheOrder();
                        }catch (NullPointerException ex){
                            System.out.println("Заказ не может быть сформирован, заполние предыдущие пункты меню");
                        }
                        printOrderMenu();
                        break;
                    case 6:
                        deleteIngredients();
                        printOrderMenu();
                        break;
                    case 7:
                        break;
                    default:
                        throw new IllegalArgumentException( "Вы ввели неверное значение меню. Если хотите выйти введите 6.");
                }
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } while (keyboardInput < 7);
        }
    }

    private void addNamePizza(){
        System.out.println( "------------------------------------------------" );
        System.out.print( "Задайте название пиццы: " );
        try {
            String str = new BufferedReader( new InputStreamReader( System.in ) ).readLine();
            orderReceipt.pizzaOrdering.setPizzaName( str );
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        System.out.println( "\n------------------------------------------------" );
    }

    private void addPizzaNumber(){
        System.out.println( "------------------------------------------------" );
        System.out.print( "Укажите количество пицц: " );
        try {
            int number = Integer.parseInt( new BufferedReader( new InputStreamReader( System.in ) ).readLine() );
            orderReceipt.pizzaOrdering.setNumberOfPizzas( number );
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        System.out.println( "\n------------------------------------------------" );
    }

    private void addBaseName() {
        System.out.println( "Выбирете основания из представленного: " );
        System.out.println( "1.Base " );
        System.out.println( "2.Calzone " );
        int value = this.scanner.nextInt();
        orderReceipt.pizzaOrdering.setTypePizza( (value==1)? PizzaIngredients.BASE :
                (value==2)? PizzaIngredients.CALSONE : null );
    }

    private void addIngredients() throws IllegalArgumentException {
        System.out.println( "Выберите ингредиенты для своей пиццы(не более 4):" );
        printMenuIngredient();
        if (this.scanner != null) {
            int keyboardInput=0;
            do {
                try {
                    keyboardInput = this.scanner.nextInt();
                    switch (keyboardInput) {
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
                    System.out.println( "Добавленные элементы:" );
                    orderReceipt.pizzaOrdering.displayAddedIngredients();
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } while (keyboardInput != 10);
        }
    }

    private void deleteIngredients() throws IllegalArgumentException {
        if (this.scanner != null) {
            int keyboardInput=0;
            orderReceipt.pizzaOrdering.displayAddedIngredients();
            System.out.print("Выберете ингридиент который хотите удалить(для выхода нажмите 5): ");
            do {
                try {
                    keyboardInput = this.scanner.nextInt();
                    if(keyboardInput==5){
                        break;
                    }
                    orderReceipt.pizzaOrdering.deleteIngredientFromTheList( orderReceipt.pizzaOrdering.getIngridient( --keyboardInput ) );
                    orderReceipt.pizzaOrdering.displayAddedIngredients();
                }catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println(ex.getMessage());
                }
            } while (keyboardInput < 4);
        }
    }
}