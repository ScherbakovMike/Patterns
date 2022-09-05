package composite;

public class ComponentWithTextImpl extends ComponentWithText {
    public ComponentWithTextImpl(ComponentWithText parent, String name, String text) {
        super(parent, name, text);
    }

    public void print() {
        System.out.printf("Name: %s%nText: %s%nParent: %s%n", this.getName(), this.getText(), this.getParent());
        System.out.print("Children: ");
        childrenIterator().forEachRemaining(ComponentWithText::print);
    }

}
