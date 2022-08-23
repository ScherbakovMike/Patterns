package decorator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BuildingPart {
    private String name;
    private double cost;
    private double buildingCost;
}
