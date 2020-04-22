package ml.zhannicholas.reflection.dynamicproxy;

public class RealSubject implements Subject {
    @Override
    public Object execute() {
        System.out.println("Real subject is executing.");
        return null;
    }
}
