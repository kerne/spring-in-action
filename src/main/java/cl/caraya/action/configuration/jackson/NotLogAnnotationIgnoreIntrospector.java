package cl.caraya.action.configuration.jackson;

import cl.caraya.action.annotations.NotLogging;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class NotLogAnnotationIgnoreIntrospector extends AnnotationIntrospector {

    private final Predicate<AnnotatedMember> hasNotLogAnnotation = a -> a.getAnnotation(NotLogging.class) != null;

    @Override
    public Version version() {
        return null;
    }

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return hasNotLogAnnotation.test(m);
    }
}