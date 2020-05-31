package ml.zhannicholas.designpatterns.adapterpattern;

// 适配者类
public class Adaptee {
    // 需要被适配的方法
    public void specificRequest() {
        System.out.println("I'm the mothod [specificRequest] in Adaptee.");
    }
}
