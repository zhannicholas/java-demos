package ml.zhannicholas.designpatterns.decoratorpattern;

/**
 * maintains a reference to a Component object and defines an interface
 * that conforms to Component's interface.
 */
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
