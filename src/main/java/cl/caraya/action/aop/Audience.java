package cl.caraya.action.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Audience {
    public Audience(){}

    public void takeSeats(){
      log.info("the audience is taking  their seats");
    }

    public void turnOffCellPhones(){
      log.info("the audience is turning off their cellphones");
    }

    public void applaud(){
      log.info("Clap Clap Clap !!!");
    }

    public void demandRefund(){
      log.info("");
    }
}
