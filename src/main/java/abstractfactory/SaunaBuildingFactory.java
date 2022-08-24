package abstractfactory;

public class SaunaBuildingFactory implements BuildingFactory {
    @Override
    public void buildWalls() {
        System.out.println("Walls of sauna have been built.");
    }

    @Override
    public void buildRoof() {
        System.out.println("Roof of sauna has been built.");
    }

    @Override
    public void buildBasement() {
        System.out.println("Basement of sauna has been built.");
    }
}
