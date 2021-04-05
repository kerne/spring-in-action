package cl.caraya.action.domain;

import cl.caraya.action.annotations.MaskLogging;
import cl.caraya.action.annotations.NotLogging;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayLoadDTO {
    private String name;

    @MaskLogging
    private String lastName;
}
