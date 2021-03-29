package cl.caraya.action.beans.inherient;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public abstract class ParentBean {

    protected String type = "Parent";

    public abstract void syso(String msg);

    public void print(String msg) {
        this.syso(msg);
    }

}
