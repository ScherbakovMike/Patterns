package composite;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public abstract class ComponentWithText extends Element {
    private final List<ComponentWithText> childrenWithText = new ArrayList<>();
    private ComponentWithText parent;
    private String name;
    private String text;

    protected ComponentWithText(ComponentWithText parent, String name, String text) {
        super(name);
        this.parent = parent;
        this.name = name;
        this.text = text;
    }

    public ComponentWithText getChildAt(int childIndex) {
        return childrenWithText.get(childIndex);
    }

    public int getChildCount() {
        return childrenWithText.size();
    }

    public ComponentWithText getParent() {
        return parent;
    }

    public boolean getAllowsChildren() {
        return true;
    }

    public boolean isLeaf() {
        return childrenWithText.isEmpty();
    }

    public Iterator<ComponentWithText> childrenIterator() {
        return childrenWithText.iterator();
    }

    public abstract void print();
}
