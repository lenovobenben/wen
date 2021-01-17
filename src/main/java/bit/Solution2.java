package bit;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution2 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
