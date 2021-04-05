package cl.caraya.action;

import cl.caraya.action.beans.payload.PayloadService;
import cl.caraya.action.domain.PayLoadDTO;
import lombok.extern.slf4j.Slf4j;

import static cl.caraya.action.context.ConfigurationContext.getBean;

/**
 * Main Configuration
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        PayloadService services = (PayloadService) getBean(PayloadService.class);
        services.payload(PayLoadDTO.builder().name("Cesar").lastName("ARaya").build(), null);
        services.payload(PayLoadDTO.builder().name("Patricio").lastName("ARaya").build(), null);
    }

}
