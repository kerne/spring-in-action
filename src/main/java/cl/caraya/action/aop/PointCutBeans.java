package cl.caraya.action.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutBeans {
    @Pointcut("execution(* cl.caraya.action.beans.custom.*.print(..) )")
    public void pointCut() {
    }
}
