package ml.zhannicholas.designpatterns.adapterpattern.classadapter;

import ml.zhannicholas.designpatterns.adapterpattern.Target;

// 客户端类
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}