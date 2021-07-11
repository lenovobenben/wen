package bit;

/**
 * 面试题 05.07. 配对交换
 */
public class Solution3 {
    public int exchangeBits(int num) {
        // 一个 a 为 1010
        int even = num & (0xaaaaaaaa);// 偶数位

        // 一个 5 为 0101
        int odd = num & (0x55555555);// 奇数位

        return (even >> 1) + (odd << 1);
    }
}
