package cl.caraya.action.configuration;

import cl.caraya.action.beans.requeridconstructor.RequiredBeanImpl;
import cl.caraya.action.beans.requeridconstructor.RequiredBeanService;
import cl.caraya.action.beans.requeridconstructor.RequiredConstructorBean;
import cl.caraya.action.beans.requeridconstructor.RequiredConstructorImpl;
import cl.caraya.action.configuration.jackson.NotLogAnnotationIgnoreIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setAnnotationIntrospector(
                AnnotationIntrospector.pair(
                        new JacksonAnnotationIntrospector(),
                        new NotLogAnnotationIgnoreIntrospector()
                )
        );
        return objectMapper;
    }

    @Bean
    public RequiredConstructorBean requiredConstructorBean(RequiredBeanService service) {
        return new RequiredConstructorImpl(service);
    }
    @Bean
    public RequiredBeanService requiredBeanService() {
        return new RequiredBeanImpl();
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