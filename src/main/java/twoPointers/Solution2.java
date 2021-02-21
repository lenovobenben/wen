package twoPointers;

import java.util.HashMap;

/**
 * 给定一个数组 arr ，返回arr的 最长无重复子串 的长度(无重复指的是所有数字都不相同)。
 */
public class Solution2 {
    public int maxLength(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        // 只新增/修改，不删除
        HashMap<Integer, Integer> map = new HashMap<>();// key 值,value 下标
        int start = 0;
        int end = 0;
        int max = 1;
        while (true) {
            if (end >= arr.length) {
                break;
            }
            Integer temp = map.get(arr[end]);
            if (temp == null || temp < start) {
                max = Math.max(max, end - start + 1);
            } else {// 已经有了
                start = temp + 1;
            }
            map.put(arr[end],end);
            end++;
        }
        return max;
    }
}
