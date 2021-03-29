package cl.caraya.action.beans;

public interface Instrumental {


    default void play(){
        System.out.println("playing in mute");
    }

}
