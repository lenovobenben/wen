package arr;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution4 {
    /**
     * 每次都和第一个零互换，所以当前已知的 0 都是连续的！
     */
    public void moveZeroes(int[] nums) {
        int first0 = -1;// 第一个零出现的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (first0 != -1) {
                    int temp = nums[i];
                    nums[i] = nums[first0];
                    nums[first0] = temp;
                    first0++;
                }
            } else {// 元素为0
                if (first0 == -1) {// 初始化
                    first0 = i;
                }
            }
        }
    }
}
