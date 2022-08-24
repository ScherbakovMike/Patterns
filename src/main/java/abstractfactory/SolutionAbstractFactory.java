package abstractfactory;

public class SolutionAbstractFactory {
    public static void main(String[] args) {

        System.out.println("Building of the sauna:");
        var construction = new Construction(new SaunaBuildingFactory());
        construction.build();

        System.out.println("Building of the skyscraper:");
        construction = new Construction(new SkyScraperBuildingFactory());
        construction.build();
    }
}
