package cl.caraya.action.configuration;

import cl.caraya.action.beans.custom.BeanImpl;
import cl.caraya.action.beans.custom.BeanServices;
import cl.caraya.action.beans.custom.CheckingBeans;
import cl.caraya.action.beans.custom.DuplicateBeanImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigurationBeans {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
//
//    @Bean
//    @Primary
//    public BeanServices beanServicesImpl() {
//        return new BeanImpl();
//    }
//
//    @Bean
//    public BeanServices duplicateBean() {
//        return new DuplicateBeanImpl();
//    }

}