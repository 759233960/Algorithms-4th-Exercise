package ThinkingInJava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy: " + proxy.getClass() + ", method: " + method + ", args: "
                + args + " *****");
        if (args != null)
            for (Object arg : args)
                System.out.println(" " + arg);
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("boboka");
    }

    public static void main(String[] args) {
        Interface realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);
    }
}
