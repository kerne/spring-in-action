package cl.caraya.action.beans;

import cl.caraya.action.exception.PerformenceException;
import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer {

    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformenceException {
        System.out.println("Juggling " + beanBags);
    }
}
