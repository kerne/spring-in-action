package cl.caraya.action.configuration.jackson;

import cl.caraya.action.annotations.MaskLogging;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;

public class MaskLoggingSerializer extends StdSerializer<Object> implements ContextualSerializer {

    private final static char DEFAULT_MASK_CHAR = '*';
    private final static int DEFAULT_BEGIN_UNMASKED_CHARS = 0;
    private final static int DEFAULT_END_UNMASKED_CHARS = 0;

    private final char maskingCharacter;
    private final int beginUnmaskedChars;
    private final int endUnmaskedChars;

    private final BiFunction<String, Integer, Pair<String>> splitString =
            (s, i) -> Pair.<String>builder().v1(s.substring(0, i)).v2(s.substring(i)).build();

    private final BiFunction<String, Integer, Pair<String>> splitAtBegin =
            (s, i) -> this.splitString.apply(s, Math.min(i, s.length()));

    private final BiFunction<String, Integer, Pair<String>> splitAtEnd =
            (s, i) -> this.splitString.apply(s, s.length() - Math.min(i, s.length()));

    public MaskLoggingSerializer() {
        this(DEFAULT_MASK_CHAR, DEFAULT_BEGIN_UNMASKED_CHARS, DEFAULT_END_UNMASKED_CHARS);
    }

    public MaskLoggingSerializer(char maskingCharacter, int beginUnmaskedChars, int endUnmaskedChars) {
        super(Object.class);
        this.maskingCharacter = maskingCharacter;
        this.beginUnmaskedChars = beginUnmaskedChars;
        this.endUnmaskedChars = endUnmaskedChars;
    }


    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        Optional<MaskLogging> annotation = Optional.ofNullable(property)
                .map(prop -> prop.getAnnotation(MaskLogging.class));

        return new MaskLoggingSerializer(
                annotation.map(MaskLogging::maskingCharacter).orElse(DEFAULT_MASK_CHAR),
                annotation.map(MaskLogging::beginUnmaskedChars).orElse(DEFAULT_BEGIN_UNMASKED_CHARS),
                annotation.map(MaskLogging::endUnmaskedChars).orElse(DEFAULT_END_UNMASKED_CHARS)
        );
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String strValue = value.toString();
        Pair<String> beginPair = this.splitAtBegin.apply(strValue, this.beginUnmaskedChars);
        Pair<String> endPair = this.splitAtEnd.apply(beginPair.getV2(), this.endUnmaskedChars);

        String maskedValue = StringUtils.join(
                beginPair.getV1(),
                StringUtils.repeat(this.maskingCharacter, endPair.getV1().length()),
                endPair.getV2()
        );

        gen.writeString(maskedValue);
    }


    @Value
    @Builder
    private static class Pair<T> {
        T v1;
        T v2;
    }
}
