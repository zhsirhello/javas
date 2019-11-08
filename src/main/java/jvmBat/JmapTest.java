package jvmBat;

public class JmapTest {
    public static void main(String[] args){
        while (true){
            Object[] arr = new Object[100];
            for (int i=0;i<100;i++){
                arr[i]=new Object();
            }
            arr=null;
        }
    }

}
