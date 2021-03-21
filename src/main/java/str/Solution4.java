package str;

/**
 * 5. 最长回文子串
 */
public class Solution4 {
    public String longestPalindrome(String s) {
        int start = 0;// 最长回文的起点
        int len = 0;// 最长回文的长度
        // 奇数
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    int tempLen = 2 * j + 1;
                    if (tempLen > len) {
                        len = tempLen;
                        start = i - j;
                    }
                } else {
                    break;
                }
            }
        }

        // 偶数
        if (s.length() > 1) {
            for (int i = 0; i + 1 < s.length(); i++) {
                for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        int tempLen = 2 * j + 2;
                        if (tempLen > len) {
                            len = tempLen;
                            start = i - j;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return s.substring(start, start + len);
    }
}