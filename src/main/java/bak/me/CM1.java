package bak.me;

/**
 * 给定一个字符串string iniString，请返回一个bool值。
 * True代表字符串的所有字符全都不同，False代表存在相同的字符。
 * 保证字符串中的字符为ASCII字符且不允许使用额外的存储结构，字符串的长度小于等于3000。
 * <p>
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 */
public class CM1 {
    public static void main(String[] args) {
        boolean flag = new CM1().checkDifferent("fbcdbea");
        System.out.println(flag);
    }

    public  boolean checkDifferent(String iniString) {

        for (int i = 0; i < iniString.length(); i++) {
            char temp = iniString.charAt(i);
            for (int j = i + 1; j < iniString.length(); j++) {
                if (temp == iniString.charAt(j)) {
                    return false;
                }
            }
        }

        return true;

    }
}
