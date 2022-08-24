package simplefactory.pizzas;

import lombok.Getter;
import lombok.Setter;
import simplefactory.PizzaType;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public abstract class Pizza {

    protected Pizza(PizzaType type) {
        this.type = type;
    }

    public void prepare() {
        System.out.println("Preparing ingredients...");
    }

    public void bake() {
        System.out.println("Baking....");
    }

    public void cut() {
        System.out.println("Cutting...");
    }

    public void box() {
        System.out.println("Boxing...");
        System.out.printf("Pizza %s is complete. Toppings: %s%n",
                this.getType().name(),
                String.join(", ", toppings));
    }

    private final PizzaType type;

    private List<String> toppings = new ArrayList<>();
}
