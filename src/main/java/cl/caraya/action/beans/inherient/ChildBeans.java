package cl.caraya.action.beans.inherient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChildBeans extends ParentBean {

    public ChildBeans() {
        type = "Child";
    }

    @Override
    public void syso(String msg) {
        log.info("{} {}", msg, type);
    }
}
