package bit;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
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

    public int NumberOf1_(int n) {
        int num = 0;
        while (true) {
            if (n == 0) {
                return num;
            } else if (n == 1) {
                return num + 1;
            } else {
                if ((n & 1) == 1) {
                    num++;
                }
                n = n >>> 1;
            }
        }
    }
}
