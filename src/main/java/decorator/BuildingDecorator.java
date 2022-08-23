package decorator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDecorator implements Buildable {
    private final BuildingPart part;
    private Buildable internalDecorator;

    public BuildingDecorator(BuildingPart part) {
        this.part = part;
    }

    public BuildingDecorator(BuildingPart part, Buildable internalDecorator) {
        this.part = part;
        this.internalDecorator = internalDecorator;
    }

    @Override
    public double build() {
        System.out.printf(
                "The part %s with cost %3.2f has been built for %3.2f.%n",
                part.getName(),
                part.getCost(),
                part.getBuildingCost());
        return (internalDecorator == null ? 0.0 : internalDecorator.build())
                + part.getCost() + part.getBuildingCost();
    }
}
