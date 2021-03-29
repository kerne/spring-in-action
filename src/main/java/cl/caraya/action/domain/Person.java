package cl.caraya.action.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private Integer id;
    private String name;
    private String ctaCte;
}
