package cl.caraya.action.aop;

import cl.caraya.action.annotations.Logging;
import cl.caraya.action.annotations.Payload;
import org.aspectj.lang.annotation.Pointcut;

public class PointCutBeans {
    @Pointcut("execution(* cl.caraya.action.beans.custom.*.print(..) )")
    public void pointCut() {
    }

    @Pointcut("@annotation(payload)")
    public void pointCutPayload(Payload payload) {
    }

    @Pointcut("@annotation(payload)")
    public void pointCutLogging(Logging payload) {
    }
}
