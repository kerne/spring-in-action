package cl.caraya.action.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Stage {

    public static Stage getInstance() {
        return Lazy.INSTACE;
    }

    public void print(String name) {
        log.info("NAME", name);
    }

    private static class Lazy {
        private static final Stage INSTACE = new Stage();
    }

}
