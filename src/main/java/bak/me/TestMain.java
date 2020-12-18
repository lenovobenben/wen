package bak.me;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 弱引用
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        List<MyEntry> list = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE / 1024; i++) {
            list.add(new MyEntry(i+"",3));
        }

        System.gc();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Thread.sleep(2000);

        int valueSum = 0;
        int keySum = 0;

        for (int i = 0; i < Integer.MAX_VALUE / 1024; i++) {
            Object value = list.get(i).getValue();
            String key = list.get(i).getKey();

            if (value==null) {
                valueSum++;
            }

            if (key==null) {
                keySum++;
            }
        }

        System.out.println("valueSum " + valueSum);
        System.out.println("keySum " + keySum);

    }
}
