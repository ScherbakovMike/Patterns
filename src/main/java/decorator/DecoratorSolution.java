package decorator;

public class DecoratorSolution {
    public static void main(String[] args) {
        System.out.println(
                new BuildingDecorator(new Basement(),
                        new BuildingDecorator(new Wall(),
                                new BuildingDecorator(new Roof()))).build()
        );

    }
}
