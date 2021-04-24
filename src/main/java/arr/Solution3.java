package arr;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution3 {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ret = nums[i + 1];
                    // i+1 不会越界。
                    // 反证法：如果 count为0，且为最后一个元素。
                    // 则表明不存在多数元素。但是题目保证存在多数元素！
                }
            }
        }
        return ret;
    }
}