package com.mcutil.injection.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is an annotation to automatically create new Object of annotated field.
 * @see com.mcutil.injection.Injector
 * In the injector its code to perform this in a class.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoSet {

}
