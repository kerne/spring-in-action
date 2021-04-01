package cl.caraya.action;

import cl.caraya.action.beans.requeridconstructor.RequiredConstructorBean;
import lombok.extern.slf4j.Slf4j;

import static cl.caraya.action.context.ConfigurationContext.getBean;

/**
 * Main Configuration
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        RequiredConstructorBean services = (RequiredConstructorBean) getBean(RequiredConstructorBean.class);
        services.required();
    }

}
