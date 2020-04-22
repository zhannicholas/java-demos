package ml.zhannicholas.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxy implements InvocationHandler {
    private final Subject target;

    public SubjectProxy(Subject target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
