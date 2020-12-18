package bak.me;

/**
 * 给定2个字符串s1和s2，请判断s2是否为s1旋转而成，返回bool值。
 * 字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 *
 * 测试样例：
 * "Hello world","worldhello "
 * 返回：false
 * "waterbottle","erbottlewat"
 * 返回：true
 */
public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {

        String s0 = s1+s1;// 自己拼接一次
        if(s0.contains(s2)){// 包含，则一定是
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseEqual().checkReverseEqual("waterbottle","erbottlewat"));
    }
}
