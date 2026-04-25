package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算自然常数 e
 * 使用公式: e = 1 + 1/1! + 1/2! + 1/3! + ...
 */
public class Solution4 {

    /**
     * 计算自然常数 e
     *
     * @param digits 小数点后保留位数
     * @return e 的十进制字符串
     */
    public String e(int digits) {
        int scale = digits + 10; // 额外精度用于减少舍入误差
        BigDecimal result = BigDecimal.ONE;
        BigDecimal term = BigDecimal.ONE;

        for (int n = 1; ; n++) {
            term = term.divide(BigDecimal.valueOf(n), scale, RoundingMode.HALF_UP);
            if (term.signum() == 0) {
                break;
            }
            result = result.add(term);
        }

        return result.setScale(digits, RoundingMode.HALF_UP).toString();
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        long t1 = System.currentTimeMillis();
        int digits = 10000;
        String result = s.e(digits);
        long t2 = System.currentTimeMillis();

        System.out.println("计算结果（前100位）: " + result.substring(0, 102) + "...");
        System.out.println("计算位数: " + digits);
        System.out.println("耗时: " + (t2 - t1) + "ms");
    }
}
