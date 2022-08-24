package simplefactory;

import simplefactory.stores.AntalyaPizzaStore;
import simplefactory.stores.RomePizzaStore;

import java.util.Arrays;

public class SimpleFactorySolution {
    public static void main(String[] args) {
        var romeStore = new RomePizzaStore();
        var antalyaStore = new AntalyaPizzaStore();

        System.out.println("Rome pizza store is baking pizza:");
        Arrays.stream(PizzaType.values()).forEach(romeStore::orderPizza);

        System.out.println("Antalya pizza store is baking pizza:");
        Arrays.stream(PizzaType.values()).forEach(antalyaStore::orderPizza);
    }
}
