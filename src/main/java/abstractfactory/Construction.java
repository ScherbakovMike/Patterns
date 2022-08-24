package abstractfactory;

public class Construction {
    private final BuildingFactory factory;

    public Construction(BuildingFactory factory) {
        this.factory = factory;
    }

    public void build() {
        factory.buildBasement();
        factory.buildWalls();
        factory.buildRoof();
        System.out.println("Building has been finished.");
    }
}
