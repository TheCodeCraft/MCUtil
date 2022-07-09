package com.mcutil.reflection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionUtil {

    public Set<Class<?>> getTypesInPackage(String pack) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(pack.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, pack))
                .collect(Collectors.toSet());
    }

    public Set<Class<?>> getTypesAnnotatedWith(String pack, Class<? extends Annotation> annotation) {
        return this.getTypesInPackage(pack).stream()
                .filter(clazz -> clazz
                        .isAnnotationPresent(annotation))
                .collect(Collectors
                        .toSet()
                );
    }

    public Set<Field> getFieldsAnnotatedWith(Class<?> clazz, Class<? extends Annotation> annotation) {
        return Arrays.stream(clazz.getFields()).filter(field -> field.isAnnotationPresent(annotation)).collect(Collectors.toSet());
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
