package simplefactory.stores;

import simplefactory.pizzas.Pizza;

public class AntalyaPizzaStore extends PizzaStore {
    @Override
    protected Pizza addToppings(Pizza pizza) {
        pizza.getToppings().add("Shrimps");
        pizza.getToppings().add("Mussels");

        return pizza;
    }
}
