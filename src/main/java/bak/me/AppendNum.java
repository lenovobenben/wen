package bak.me;

import java.util.ArrayList;
import java.util.List;

/**
 * 微软 面试题
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最大的一个
 * 比如 75,9,7,76,54,79,112,776 ，应该输出 9,79,7,776,76,75,54,112
 */
public class AppendNum {
    public static void main(String[] args) {
        new AppendNum().find(new int[]{75, 9, 7, 76, 54, 79, 112, 7766, 776, 7767, 7765});
    }

    public void find(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i] + "");
        }

        // 核心代码
        list.sort((a, b) -> {
            int n1 = Integer.parseInt(a + b);
            int n2 = Integer.parseInt(b + a);
            if (n1 > n2) {
                return -1;
            } else if (n1 < n2) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(list);
    }

}
