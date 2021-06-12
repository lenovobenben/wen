package hash;

import java.util.HashSet;

/**
 * 面试题 01.04. 回文排列
 */
public class Solution2 {
    /**
     * 回文的特点：
     * 奇数个字符的情况 <= 1
     */
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }

        return set.size() <= 1;
    }
}
