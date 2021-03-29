package cl.caraya.action.beans;

import cl.caraya.action.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeanImpl implements BeanServices {

    ObjectMapper mapper;

    @Override
    public Person print(Person msg) {
        try {
            if (msg.getId() == 123456789) {

                log.info("{}", mapper.writeValueAsString(msg));
            }
            return msg;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
