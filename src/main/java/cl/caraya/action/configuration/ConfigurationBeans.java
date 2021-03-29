package cl.caraya.action.configuration;

import cl.caraya.action.beans.BeanImpl;
import cl.caraya.action.beans.BeanServices;
import cl.caraya.action.beans.DuplicateBeanImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public BeanServices beanServices() {
        return new BeanImpl();
    }

    @Bean
    public BeanServices duplicateBean() {
        return new DuplicateBeanImpl();
    }
}