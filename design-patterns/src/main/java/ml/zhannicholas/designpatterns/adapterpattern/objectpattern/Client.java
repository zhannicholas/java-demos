package ml.zhannicholas.designpatterns.adapterpattern.objectpattern;

import ml.zhannicholas.designpatterns.adapterpattern.Adaptee;
import ml.zhannicholas.designpatterns.adapterpattern.Target;

// 客户端类
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
