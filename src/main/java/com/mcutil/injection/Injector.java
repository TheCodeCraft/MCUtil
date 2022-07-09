package com.mcutil.injection;

import com.mcutil.injection.annotations.AutoSet;
import com.mcutil.injection.annotations.firstSet.*;
import com.mcutil.reflection.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Set;

public class Injector {

    public Injector(Class<?> clazz) {
        initFramework(clazz);
    }

    public void initFramework(Class<?> clazz) {
        initFirstSet(clazz);
        initAutoSet(clazz);
    }

    public void initFirstSet(Class<?> clazz) {
        final Set<Field> annotatedFields = new ReflectionUtil().getFieldsAnnotatedWith(clazz, StringFirstSet.class);
        annotatedFields.forEach(field -> {
            field.setAccessible(true);
            try {
                field.set(field.getType(), field.getAnnotation(StringFirstSet.class).set());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public void initAutoSet(Class<?> clazz) {
        final Set<Field> annotatedFields = new ReflectionUtil().getFieldsAnnotatedWith(clazz, AutoSet.class);
        annotatedFields.forEach(field -> {
            field.setAccessible(true);
            try {
                Object fieldTypeInstance = field.getType().newInstance();
                field.set(field.getType(), fieldTypeInstance);
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }

}
