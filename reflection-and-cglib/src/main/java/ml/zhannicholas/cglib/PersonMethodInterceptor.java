package ml.zhannicholas.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PersonMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib intercept start...");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("cglib intercept end...");
        return result;
    }
}
