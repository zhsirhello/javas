package JavaLeiUseExample.TimeUnit;

import java.util.concurrent.TimeUnit;

public class TimeUnitApi {
    public static void main(String[] args){
        //把分钟转换成毫秒
        long convert = TimeUnit.MILLISECONDS.convert(10L, TimeUnit.MINUTES);
        System.out.println(convert);
    }
}
