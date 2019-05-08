package numTread.eventBus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Registry {
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer=
            new ConcurrentHashMap<>();
    //获得某个类被@subscribe修饰的方法
    private List<Method> getSubscribeMethods(Object subscriber){
        final List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();
        while (temp!=null){
            //以下，为什么不直接getMethods,因为后面过滤时规定修饰符为public
            Method[] declaredMethod = temp.getDeclaredMethods();
            Arrays.stream(declaredMethod).filter(m->m.isAnnotationPresent(Subcribe.class)
                                                 && m.getParameterCount()==1
                                                 && m.getModifiers()== Modifier.PUBLIC);
            temp=temp.getSuperclass();
        }
        return methods;
    }

    private void tierSubscriber(Object subscriber,Method method){
        final Subcribe subsribe = method.getDeclaredAnnotation(Subcribe.class);
        String topic = subsribe.topic();
        subscriberContainer.computeIfAbsent(topic,key -> new ConcurrentLinkedQueue<>());
        subscriberContainer.get(topic).add(new Subscriber(subscriber,method));

    }
}
