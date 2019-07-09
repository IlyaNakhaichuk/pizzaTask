package by.company.pizza.other.version;

public abstract class OrderPizza {
    private String name;

    public OrderPizza(String name) {
        this.name = name;
    }

    Pizza pizza = createPizza(name);

    abstract Pizza createPizza(String name);

}
