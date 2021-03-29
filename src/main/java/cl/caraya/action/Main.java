package cl.caraya.action;

import cl.caraya.action.beans.custom.BeanServices;
import cl.caraya.action.beans.custom.CheckingBeans;
import cl.caraya.action.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        CheckingBeans services = (CheckingBeans) getBean(CheckingBeans.class);
        System.out.println(services.check(Person.builder().name("Cesar").build()));
    }

    public static Object getBean(String name) {
        return Context.INSTANCE.getBean(name);
    }

    public static Object getBean(Class type) {
        return Context.INSTANCE.getBean(type);
    }

    static class Context {
        private static final ApplicationContext INSTANCE =
                new ClassPathXmlApplicationContext("cl/caraya/action/caraya-action.xml");
    }
}
