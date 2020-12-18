package bak.me;

import java.util.HashMap;

/**
 * 给定一个数组 arr ，返回arr的 最长无重复子串 的长度(无重复指的是所有数字都不相同)。
 */
public class Solution13 {

    /**
     * 双指针
     */
    public int maxLength(int[] arr) {
        // key 值 。value 下标
        HashMap<Integer, Integer> map = new HashMap<>(1000);// 只有 插入/更新，无删除
        int start = 0;
        int end = 0;
        int max = 0;
        while (true) {
            if (end >= arr.length) break;

            Integer temp = map.get(arr[end]);
            if (temp == null || temp < start) {// 没有值。或者小于 start（这样的数没有意义）。
                max = Math.max(max, end - start);// 重置最大值
            } else {// 已经存在
                start = temp + 1;// start 跳过此数
            }

            map.put(arr[end], end);// 不存在则放入。存在则重置为 end
            end++;// end 右移
        }

        return max + 1;// 返回要 +1
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 4, 4, 4, 5, 6, 7, 6};
        System.out.println(new Solution13().maxLength(arr));
    }
}
