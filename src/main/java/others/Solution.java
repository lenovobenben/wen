package others;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、库函数、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution {
    // 递归代替 for
    // 短路代替 if
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
