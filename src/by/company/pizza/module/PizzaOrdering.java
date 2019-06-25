package by.company.pizza.module;

import java.util.ArrayList;

class PizzaOrdering implements Ingredient {
    private int orderId;
    private int clientId;
    private String pizzaName;
    private int numberOfPizzas;
    private PizzaIngredients typePizza;
    private ArrayList<Object> ingredientList = new ArrayList<>(  );
    private ArrayList<Object> itemsPizza = new ArrayList<>(  );

    PizzaOrdering() {
        this.orderId = (int) (Math.random()*(10000-99999))+100000;
        this.clientId = (int) (Math.random()*(1000-9999))+10000;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = (pizzaName.length()>=4 && pizzaName.length()<=20) ? pizzaName : getClientId()+"_"+ pizzaName ;
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

    public PizzaIngredients getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(PizzaIngredients typePizza) throws IllegalArgumentException {
        if(typePizza == PizzaIngredients.BASE || typePizza ==PizzaIngredients.CALSONE) {
            this.typePizza = typePizza;
        }else {
            throw new IllegalArgumentException( "Вы должны выбрать основание пиццы." );
        }
    }

    public PizzaIngredients getIngridient(int ingredientNumberInArray)throws ArrayIndexOutOfBoundsException {
        if (ingredientNumberInArray < ingredientList.size()) {
            return (PizzaIngredients) ingredientList.get( ingredientNumberInArray );
        } else {
            throw new ArrayIndexOutOfBoundsException( "Несуществоет ингридиента под таким номером" );
        }
    }

    @Override
    public void deleteIngredientFromTheList(PizzaIngredients ingredients) throws IllegalArgumentException{
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
        return attributeString.append( getOrderId() ).append( ":" ).append( getClientId() ).append( ":" ).append( getPizzaName() ).append( ":" ).append( getNumberOfPizzas() ).toString();
    }

    @Override
    public void addIngredient(PizzaIngredients ingredients) throws IllegalArgumentException {
        if (ingredientList.size() > 3) {
            throw new IllegalArgumentException( "Пицца заполнена. Введите 10 для выхода на главное меню." );
        }
        if (!ingredientList.contains( ingredients )) {
            ingredientList.add( ingredients );
        } else {
            throw new IllegalArgumentException( "Пицца уже содержит данный ингридиетн: " + ingredients + "\nДобавте другой ингридиент." );
        }
    }

    public float singleIngredientPriceCalculation(String ingridient){
        return PizzaIngredients.valueOf(ingridient.toUpperCase().trim()).getIngredientPrice();
    }

    public float calculatesThePriceOfPizza() {
        float sumOfAllIngredients =0.0f;
        for (int i = 0; i <ingredientList.size() ; i++) {
            sumOfAllIngredients += PizzaIngredients.valueOf(ingredientList.get( i ).toString()).getIngredientPrice();
        }
        return Math.round( sumOfAllIngredients*100.0f )/100.0f;
    }
    @Override
    public void displayAddedIngredients(){
        for (int i=0,j=1;i<ingredientList.size();i++,j++) {
            System.out.println(j+". "+ingredientList.get( i ).toString());
        }
    }
}