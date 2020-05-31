package ml.zhannicholas.designpatterns.decoratorpattern;

/**
 * defines an object to which additional responsibilities can be
 * attached.
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Operating something in concrete component ...");
    }
}
