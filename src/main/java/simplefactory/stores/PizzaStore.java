package simplefactory.stores;

import simplefactory.PizzaType;
import simplefactory.pizzas.*;

public abstract class PizzaStore {

    public Pizza orderPizza(PizzaType type) {
        var pizza = createPizza(type);

        pizza.prepare();
        addToppings(pizza);
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected Pizza createPizza(PizzaType type) {
        return switch (type) {
            case NAPOLETANA -> new PizzaNapolitana();
            case CALZONE -> new PizzaCalzone();
            case ROMANA -> new PizzaRomana();
            case SICILIANA -> new PizzaSiciliana();
            case FRITTA -> new PizzaFritta();
            case TEGAMINO -> new PizzaTegamino();
        };
    }

    protected abstract Pizza addToppings(Pizza pizza);
}
