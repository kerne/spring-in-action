package cl.caraya.action.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Configuration Context from xml
 */
public final class ConfigurationContext {

    public static Object getBean(String name) {
        return Context.INSTANCE.getBean(name);
    }

    public static Object getBean(Class type) {
        return Context.INSTANCE.getBean(type);
    }

    private static class Context {
        private static final ApplicationContext INSTANCE =
                new ClassPathXmlApplicationContext("cl/caraya/action/caraya-action.xml");
    }
}
