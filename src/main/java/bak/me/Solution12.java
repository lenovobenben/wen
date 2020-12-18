package bak.me;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 */
public class Solution12 {

    public String LCS(String str1, String str2) {
        int start = 0;
        int len = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int temp = 0;
                for (int k = 0; k < Math.min(str1.length() - i, str2.length() - j); k++) {
                    if (str1.charAt(i + k) == str2.charAt(j + k)) {
                        temp++;
                        if (temp > len) {
                            len = temp;
                            start = i;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        String ret = str1.substring(start, start + len);
        return ret.equals("") ? "-1" : ret;
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(new Solution12().LCS(s1, s2));
    }
}
