package cl.caraya.action.beans.custom;

import cl.caraya.action.annotations.BeanQualified;
import cl.caraya.action.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BeanImpl annotated as BeanQualified to different it of another bean that implement interfaces BeanServices
 */
@Slf4j
@BeanQualified
@Component
public class BeanImpl implements BeanServices {

    @Autowired
    ObjectMapper mapper;


    @Override
    public Person print(Person msg) {
        try {
            log.info("{}", mapper.writeValueAsString(msg));
            return msg;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
