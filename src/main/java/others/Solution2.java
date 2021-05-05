package others;

import java.math.BigDecimal;

/**
 * 计算 圆周率
 * 梅钦公式
 */
public class Solution2 {
    public String pi(int n) {
        BigDecimal arctan5 = BigDecimal.ZERO;
        BigDecimal arctan239 = BigDecimal.ZERO;
        int extra = 9;// 多余出来的精度。它们的意义是保证前边的精度有效，最终的返回值要舍弃这些精度。
        for (int i = 0; i < n; i++) {
            BigDecimal temp5 = new BigDecimal("1").divide(new BigDecimal(String.valueOf(2 * i + 1)).multiply(new BigDecimal("5").pow(2 * i + 1)), n + extra, BigDecimal.ROUND_HALF_UP);
            BigDecimal temp239 = new BigDecimal("1").divide(new BigDecimal(String.valueOf(2 * i + 1)).multiply(new BigDecimal("239").pow(2 * i + 1)), n + extra, BigDecimal.ROUND_HALF_UP);
            BigDecimal flag = new BigDecimal(i % 2 == 0 ? "1" : "-1");
            arctan5 = arctan5.add(temp5.multiply(flag));
            arctan239 = arctan239.add(temp239.multiply(flag));
        }

        BigDecimal ret = new BigDecimal("16").multiply(arctan5).subtract(new BigDecimal("4").multiply(arctan239));
        String str = ret.toString();
        return str.substring(0, str.length() - extra);
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(new Solution2().pi(10000));
        System.out.println(System.currentTimeMillis() - t1);
    }
}
