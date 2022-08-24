package simplefactory.stores;

import simplefactory.pizzas.*;

public class RomePizzaStore extends PizzaStore {
    @Override
    protected Pizza addToppings(Pizza pizza) {
        pizza.getToppings().add("Pepper");
        pizza.getToppings().add("Sicilian herbs");

        return pizza;
    }
}
