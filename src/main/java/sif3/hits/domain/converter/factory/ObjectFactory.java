package sif3.hits.domain.converter.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * This class is defined so that we can use a custom proxy to handle nulls
 * differently to the default Object Factory.
 * <p>
 * If we are setting a value that is null do not call the setter.
 *
 * @see sif3.hits.domain.converter.HitsConverter#nullValueInvocationHandler
 */
public class ObjectFactory extends sif.dd.au30.model.ObjectFactory implements IObjectFactory {
    private static final IObjectFactory target = new ObjectFactory();
    private static final InvocationHandler nullValueInvocationHandler = (proxy, method, args) -> {
        // if this method has one parameter and the parameter value is null return
        // null otherwise
        // invoke the method on the objectFactory
        if (args != null && args.length == 1 && args[0] == null) {
            return null;
        } else {
            return method.invoke(target, args);
        }
    };

    private static final IObjectFactory proxy = (IObjectFactory) Proxy.newProxyInstance(ObjectFactory.class.getClassLoader(), new Class[]{IObjectFactory.class}, nullValueInvocationHandler);

    private ObjectFactory() {
        // Singleton
    }

    public static IObjectFactory getInstance() {
        return proxy;
    }
}
