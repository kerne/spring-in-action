package cl.caraya.action.domain;

import com.falabella.boss.logging.annotation.MaskLogging;
import com.falabella.boss.logging.annotation.NotLogging;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private Integer id;
    private String name;
    private String ctaCte;
}
