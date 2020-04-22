package ml.zhannicholas.reflection.proxypattern;

public class Proxy implements Subject {
    private final RealSubject realSubject = new RealSubject();

    public void preRequest(){System.out.println("PreRequest.");}
    public void postRequest(){System.out.println("PostRequest.");}

    @Override
    public void request() {
        preRequest();
        System.out.println("Request of Proxy.");
        realSubject.request();
        postRequest();
    }
}
