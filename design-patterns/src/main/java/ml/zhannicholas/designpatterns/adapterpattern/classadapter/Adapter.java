package ml.zhannicholas.designpatterns.adapterpattern.classadapter;

import ml.zhannicholas.designpatterns.adapterpattern.Adaptee;
import ml.zhannicholas.designpatterns.adapterpattern.Target;

// 类适配器
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("Adapt method [specificRequest] to method [request] begin ...");
        specificRequest();
        System.out.println("Adapt method [specificRequest] to method [request] end ...");
    }
}
