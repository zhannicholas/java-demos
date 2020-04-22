package ml.zhannicholas.reflection.proxypattern;

public class RealSubject implements Subject {
    @Override
    public void request() {System.out.println("Request of RealSubject instance.");}
}
