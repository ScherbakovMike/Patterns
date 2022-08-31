package facade;

public class FacadeSolution {
    public static void main(String[] args) {
        new SimpleFacade(new SuperComplexInterfaceImpl()).makeAllPreparations();
    }
}
