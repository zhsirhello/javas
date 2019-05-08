package numTread.eventBus;

import java.lang.reflect.Method;

public class Subscriber {
    private final Object subscribeObject;
    private final Method subscribeMethod;
    private boolean disable = false;

    public Subscriber(Object o,Method m){
        this.subscribeObject=o;
        this.subscribeMethod=m;
    }

    public Object getSubscribeObject() {
        return subscribeObject;
    }

    public Method getSubscribeMethod() {
        return subscribeMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
