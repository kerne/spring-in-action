package cl.caraya.action.beans.payload;

import cl.caraya.action.domain.PayLoadDTO;

public interface PayloadService {
    void payload(PayLoadDTO payLoadDTO, String payload);
}
