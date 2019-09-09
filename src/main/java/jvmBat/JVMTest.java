package jvmBat;

import java.util.ArrayList;

/**
 * 测试堆溢出，dunp堆等参数
 */
public class JVMTest {
    static class OOMObject{}
    public static void main(String[] args){
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
