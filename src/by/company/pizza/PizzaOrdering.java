package by.company.pizza;

import java.util.ArrayList;

class PizzaOrdering implements Ingredient  {
    private int orderNumber;
    private int clientIsNumber;
    private String pizzaName;
    private int numberOfPizzas;
    private String typePizza;
    private ArrayList<Object> ingredientList = new ArrayList<>(  );
    private ArrayList<Object> itemsPizza = new ArrayList<>(  );

    public PizzaOrdering() {
        this.orderNumber = (int) (Math.random()*(10000-99999))+100000;
        this.clientIsNumber = (int) (Math.random()*(1000-9999))+10000;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getClientIsNumber() {
        return clientIsNumber;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = (pizzaName.length()>=4 && pizzaName.length()<=20) ? pizzaName : getClientIsNumber()+"_"+ pizzaName ;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public void setNumberOfPizzas(int numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }

    public String getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(String typePizza) {
        this.typePizza = typePizza;
    }

    @Override
    public void deleteIngredientFromTheList(PizzaIngredients ingredients){
        if(ingredientList.contains( ingredients )){
            for (int i = 0; i <ingredientList.size() ; i++) {
                if(ingredientList.get( i ) == ingredients){
                    ingredientList.remove( i );
                }
            }
        }else {
            throw new IllegalArgumentException( "Пицца не содержит данный ингридиент: "+ ingredients );
        }
    }

    public Object getIngredientList(){
        return ingredientList;
    }

    public void setItemsPizza(){
        itemsPizza.add( getPizzaName() );
        itemsPizza.add( ingredientList );
        itemsPizza.add( getTypePizza() );
        itemsPizza.add(getNumberOfPizzas());
    }

    public String displaysPizzaAttributes(){
        StringBuilder attributeString = new StringBuilder(  );
        return attributeString.append( getOrderNumber() ).append( ":" ).append( getClientIsNumber() ).append( ":" ).append( getPizzaName() ).append( ":" ).append( getNumberOfPizzas() ).toString();
    }

    @Override
    public void addIngredient(PizzaIngredients ingredients) {
        if(ingredientList.size()>5){
            throw new IllegalArgumentException("Пицца заполнена");
        }
        if(!ingredientList.contains( ingredients )) {
            ingredientList.add( ingredients );
        }else {
            throw new IllegalArgumentException( "Пицца уже содержит данный ингридиетн: " + ingredients + " Добавте другой ингридиент.");
        }
    }
}