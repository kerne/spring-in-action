package cl.caraya.action.beans.payload;

import cl.caraya.action.annotations.Logging;
import cl.caraya.action.annotations.Payload;
import cl.caraya.action.domain.PayLoadDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayloadImpl implements PayloadService {

    @Override
    @Payload
    @Logging
    public void payload(PayLoadDTO payLoadDTO, String payload) {
        log.info("PayLoad String {}", payload);
    }
}
