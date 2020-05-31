package ml.zhannicholas.designpatterns.decoratorpattern;

public class Client {
    public static void main(String[] args) {
        Component component1 = new ConcreteComponent();
        Component component2 = new ConcreteDecoratorB(component1);  // decorate component1 with component2
        component2.operation();
    }
}
