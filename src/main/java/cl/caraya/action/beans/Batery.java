package cl.caraya.action.beans;

import org.springframework.stereotype.Component;

@Component
public class Batery implements Instrumental{
    @Override
    public void play() {
        System.out.println("Playing Batery...");
    }
}
