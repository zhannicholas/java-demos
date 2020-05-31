package ml.zhannicholas.designpatterns.adapterpattern.objectpattern;

import ml.zhannicholas.designpatterns.adapterpattern.Adaptee;
import ml.zhannicholas.designpatterns.adapterpattern.Target;

// 对象适配器
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapt method [specificRequest] to method [request] begin ...");
        adaptee.specificRequest();
        System.out.println("Adapt method [specificRequest] to method [request] end ...");
    }
}
