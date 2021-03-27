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
        // 执行业务逻辑之前的预处理逻辑……
         preprocess();
        Object result = method.invoke(target, args);
        // 执行业务逻辑之后的后置处理逻辑……
         postprocess();
        return result;
    }

    private void preprocess() {
        System.out.println("Preprocess...");
    }

    private void postprocess() {
        System.out.println("Postprocess...");
    }
}
