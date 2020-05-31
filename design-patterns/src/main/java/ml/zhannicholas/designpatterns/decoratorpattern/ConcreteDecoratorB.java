package ml.zhannicholas.designpatterns.decoratorpattern;

/**
 * adds responsibilities to the component.
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    private void addBehavior() {
        System.out.println("Attaching new responsibilities to concrete component ...");
    }
}
