package decorator;

public class Wall extends BuildingPart {
    public Wall() {
        setName("Walls");
        setCost(4 * 100.0);
        setBuildingCost(4 * 50.0);
    }
}
