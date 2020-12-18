package bak.me;

import java.util.HashMap;

/**
 * 知乎面试题
 * 给定一个 int 数组，元素不重复，乱序
 * 查找和为 N 的 数对
 *
 * 比如 1,3,2,4,5,8,6,7 找出和为7的数对，即 1 6，2 5，3 4，打印出数对下标
 */
public class Zhihu {
    public static void main(String[] args) {
        int[] arr = new int[]{10,1,3,2,5,9,4,8,7,6};
        new Zhihu().process(arr,9);
    }

    private void process(int[] arr, int N) {

        // key 为 值， value 为 下标
        HashMap<Integer,Integer> temp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (temp.get(N-arr[i])!=null) {// 配对成功
                System.out.println(temp.get(N-arr[i]) + " " + i);
                temp.remove(N-arr[i]);
            } else {// 无配对
                temp.put(arr[i],i);
            }
        }

        // 未成对的数字和其下标
        System.out.println(temp);
    }
}
