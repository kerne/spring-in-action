package cl.caraya.action.beans.requeridconstructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequiredBeanImpl implements RequiredBeanService {
    @Override
    public void required() {
        log.info("BEANS REQUIRED");
    }
}
