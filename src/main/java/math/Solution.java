package math;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 */
public class Solution {
    // 抄大佬的答案
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
