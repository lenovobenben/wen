package dp;

/**
 * 斐波那契数列
 * （从0开始，第0项为0，第1项是1）
 * 0 1 1 2 3 5 8 13 21 34 55 89
 */
public class Solution {

    /**
     * 动态规划
     */
    public int Fibonacci(int n) {
        return 0;
    }


    /**
     * 递归
     */
    public int Fibonacci2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci2(11));
    }
}
