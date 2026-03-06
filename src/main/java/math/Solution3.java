package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 优化后的圆周率计算
 * 使用梅钦公式：PI = 16*arctan(1/5) - 4*arctan(1/239)
 */
public class Solution3 {

    /**
     * 计算圆周率
     * @param digits 小数点后保留的位数
     * @return 圆周率字符串
     */
    public String pi(int digits) {
        // 为了保证最后一位的精确度，增加几位内部计算精度
        int internalPrecision = digits + 10;
        
        // 计算 16 * arctan(1/5)
        BigDecimal term1 = arctanInverseX(5, 16, internalPrecision);
        // 计算 4 * arctan(1/239)
        BigDecimal term2 = arctanInverseX(239, 4, internalPrecision);
        
        // PI = 16*arctan(1/5) - 4*arctan(1/239)
        BigDecimal pi = term1.subtract(term2);
        
        // 舍弃掉多出的精度并转为字符串
        return pi.setScale(digits, RoundingMode.HALF_UP).toString();
    }

    /**
     * 计算 multiplier * arctan(1/x)
     * 使用公式: arctan(1/x) = 1/x - 1/(3x^3) + 1/(5x^5) - 1/(7x^7) ...
     */
    private BigDecimal arctanInverseX(int x, int multiplier, int scale) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal xBig = BigDecimal.valueOf(x);
        BigDecimal x2 = xBig.multiply(xBig); // x^2
        
        // 初始项: (multiplier * 1) / x
        BigDecimal currentPower = BigDecimal.valueOf(multiplier)
                .divide(xBig, scale, RoundingMode.HALF_UP);
        
        for (int i = 0; ; i++) {
            // 计算当前项: currentPower / (2i + 1)
            BigDecimal denominator = BigDecimal.valueOf(2 * i + 1);
            BigDecimal term = currentPower.divide(denominator, scale, RoundingMode.HALF_UP);
            
            // 如果当前项已经小到不再影响精度（等于0），则停止
            if (term.signum() == 0) {
                break;
            }
            
            // 交替加减
            if (i % 2 == 0) {
                result = result.add(term);
            } else {
                result = result.subtract(term);
            }
            
            // 为下一轮准备 currentPower: currentPower / x^2
            currentPower = currentPower.divide(x2, scale, RoundingMode.HALF_UP);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        long t1 = System.currentTimeMillis();
        // 计算小数点后 10000 位
        int digits = 10000;
        String result = s.pi(digits);
        long t2 = System.currentTimeMillis();
        
        System.out.println("计算结果（前100位）: " + result.substring(0, 102) + "...");
        System.out.println("计算位数: " + digits);
        System.out.println("耗时: " + (t2 - t1) + "ms");
    }
}
