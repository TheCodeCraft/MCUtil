package di;

import com.mcutil.injection.Injector;
import com.mcutil.injection.annotations.*;
import com.mcutil.injection.annotations.firstSet.StringFirstSet;


public class DITest {


    @StringFirstSet(set = "s")
    public static String s;

    @AutoSet
    public static Test test;

    public static void main(String[] args) {
        Injector injector = new Injector(DITest.class);
        test.sout();
        System.out.println(s);
    }

}
