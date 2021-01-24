package str;

/**
 * 给定2个字符串s1和s2，请判断s2是否为s1旋转而成，返回bool值。
 * 字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 */
public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return false;
        }
        String s0 = s1 + s1;
        return s0.contains(s2);// KMP算法？
    }
}
