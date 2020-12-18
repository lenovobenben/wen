package bak.me;

/**
 * 给定一个int x，交换其二进制的奇数位和偶数位，并返回交换后的数int。
 * <p>
 * 测试样例：
 * 10
 * 返回：5
 */
public class Exchange {
    public int exchangeOddEven(int x) {
        // 一个 a 为 1010
        int even = x & (0xaaaaaaaa);// 偶数位

        // 一个 5 为 0101
        int odd = x & (0x55555555);// 奇数位

        return (even >> 1) + (odd << 1);
    }
}
