package cl.caraya.action.beans.custom;

import cl.caraya.action.annotations.CustomQualified;
import cl.caraya.action.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@CustomQualified
@Component
public class DuplicateBeanImpl implements BeanServices {
    @Override
    public Person print(Person msg) {
        log.info("Duplicate beans");
        return msg;
    }
}
