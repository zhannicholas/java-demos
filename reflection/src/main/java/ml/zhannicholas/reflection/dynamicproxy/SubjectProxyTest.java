package ml.zhannicholas.reflection.dynamicproxy;

import java.lang.reflect.Proxy;

public class SubjectProxyTest {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(
                SubjectProxy.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectProxy(new RealSubject()));
        subject.execute();
    }
}
