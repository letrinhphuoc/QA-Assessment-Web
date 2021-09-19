package web.annotations;


import web.element.WaitStrategy;
import web.element.WebLocatorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static web.element.WebLocatorType.ID;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FindElement {
    WebLocatorType type() default ID;

    String value();

    WaitStrategy waitUntil() default WaitStrategy.VISIBILITY;

}
