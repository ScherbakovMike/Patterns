package abstractfactory;

public class SkyScraperBuildingFactory implements BuildingFactory {
    @Override
    public void buildWalls() {
        System.out.println("Walls of skyscraper have been built.");
    }

    @Override
    public void buildRoof() {
        System.out.println("Roof of skyscraper has been built.");
    }

    @Override
    public void buildBasement() {
        System.out.println("Basement of skyscraper has been built.");
    }
}
