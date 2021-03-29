package cl.caraya.action;

import cl.caraya.action.beans.custom.CheckingBeans;
import cl.caraya.action.domain.Person;
import lombok.extern.slf4j.Slf4j;

import static cl.caraya.action.context.ConfigurationContext.getBean;

/**
 * Main Configuration
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        CheckingBeans services = (CheckingBeans) getBean(CheckingBeans.class);
        Person request = Person.builder().name("Cesar").build();

        log.info("Final Response {}", services.check(request));
    }

}
