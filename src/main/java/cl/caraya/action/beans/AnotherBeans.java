package cl.caraya.action.beans;

import org.springframework.stereotype.Component;

@Component
public class AnotherBeans implements AnotherBeansServices {

    @Override
    public String name(String name) {
        return name.replaceFirst("^0+(?!$)", "");
    }
}
