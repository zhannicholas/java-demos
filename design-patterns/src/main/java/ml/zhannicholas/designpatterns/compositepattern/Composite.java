package ml.zhannicholas.designpatterns.compositepattern;

import java.util.ArrayList;

// 容器类
public class Composite extends Component {
    private ArrayList<Component> children = new ArrayList<>();

    @Override
    public void add(Component c) {
        this.children.add(c);
    }

    @Override
    public void remove(Component c) {
        this.children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        System.out.println("Performing operation defined in Composite[" + this.hashCode() + "].");
        for (Component c: children) {
            c.operation();
        }
    }
}
