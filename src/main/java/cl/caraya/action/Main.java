package cl.caraya.action;

import cl.caraya.action.beans.BeanServices;
import cl.caraya.action.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        BeanServices services = (BeanServices) getBean("beanImpl");
        System.out.println(services.print(Person.builder().name("Cesar").build()));
    }

    public static Object getBean(String name) {
        return Context.INSTANCE.getBean(name);
    }

    static class Context {
        private static final ApplicationContext INSTANCE =
                new ClassPathXmlApplicationContext("cl/caraya/action/caraya-action.xml");
    }
}
