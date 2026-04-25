package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算 ln(2)
 * 使用公式: ln((1+x)/(1-x)) = 2 * (x + x^3/3 + x^5/5 + ...)
 * 取 x = 1/3, 则 ln(2) = 2 * (1/3 + 1/(3^3*3) + 1/(3^5*5) + ...)
 */
public class Solution5 {

    /**
     * 计算 ln(2)
     *
     * @param digits 小数点后保留位数
     * @return ln(2) 的十进制字符串
     */
    public String ln2(int digits) {
        int scale = digits + 10;
        BigDecimal x = BigDecimal.ONE.divide(BigDecimal.valueOf(3), scale, RoundingMode.HALF_UP);
        BigDecimal x2 = x.multiply(x).setScale(scale, RoundingMode.HALF_UP);
        BigDecimal currentPower = x;
        BigDecimal sum = BigDecimal.ZERO;

        for (int n = 0; ; n++) {
            BigDecimal denominator = BigDecimal.valueOf(2L * n + 1);
            BigDecimal term = currentPower.divide(denominator, scale, RoundingMode.HALF_UP);
            if (term.signum() == 0) {
                break;
            }
            sum = sum.add(term);
            currentPower = currentPower.multiply(x2).setScale(scale, RoundingMode.HALF_UP);
        }

        BigDecimal result = sum.multiply(BigDecimal.valueOf(2));
        return result.setScale(digits, RoundingMode.HALF_UP).toString();
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        long t1 = System.currentTimeMillis();
        int digits = 10000;
        String result = s.ln2(digits);
        long t2 = System.currentTimeMillis();

        System.out.println("计算结果（前100位）: " + result.substring(0, 102) + "...");
        System.out.println("计算位数: " + digits);
        System.out.println("耗时: " + (t2 - t1) + "ms");
    }
}
