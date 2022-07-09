package reflections;

import com.mcutil.reflection.ReflectionUtil;

import java.util.Set;

public class ReflectionTest {

    public static void main(String[] args) {
        final Set<Class<?>> classes = new ReflectionUtil().getTypesAnnotatedWith("reflections", TestAnnotation.class);
        System.out.println(classes);
    }

}
