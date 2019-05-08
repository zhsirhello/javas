package numTread.eventBus.test;

import numTread.eventBus.Subcribe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Tempor subscriber = new Tempor();
        final List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();
        while (temp!=null){
            //以下，为什么不直接getMethods,因为后面过滤时规定修饰符为public
            /*Method[] declaredMethod = temp.getDeclaredMethods();*/
            Method[] declaredMethod = temp.getDeclaredMethods();
            Arrays.stream(declaredMethod).filter(m->m.isAnnotationPresent(Subcribe.class)
                    && m.getParameterCount()==0
                    ).forEach(methods::add);
            temp=temp.getSuperclass();
        }
        Arrays.stream(methods.toArray()).forEach(System.out::println);

    }
}
