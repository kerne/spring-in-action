package cl.caraya.action.annotations;

import cl.caraya.action.configuration.jackson.MaskLoggingSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = MaskLoggingSerializer.class)
public @interface MaskLogging {
    char maskingCharacter() default '*';
    int beginUnmaskedChars() default 0;
    int endUnmaskedChars() default 0;
}

