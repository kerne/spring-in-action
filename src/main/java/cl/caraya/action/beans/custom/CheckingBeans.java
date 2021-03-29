package cl.caraya.action.beans.custom;

import cl.caraya.action.annotations.BeanQualified;
import cl.caraya.action.annotations.CustomQualified;
import cl.caraya.action.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckingBeans {

    @Autowired
    @CustomQualified // custom annotation as alternative Qualified
    BeanServices beanServices;

    public Person check(Person person) {
        return beanServices.print(person);
    }


}
