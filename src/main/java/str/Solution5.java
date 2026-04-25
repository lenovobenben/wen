package str;

import java.util.*;

/**
 * 28. 实现 strStr() (KMP 算法)
 * 经典字符串匹配题目：在 haystack 中寻找 needle 第一次出现的位置。
 * 
 * 核心原理 (KMP)：
 * 1. 构建 next 数组 (即前缀表 Prefix Table)：
 *    - next[i] 表示模式串 needle[0...i] 中最长公共前后缀的长度。
 * 2. 匹配过程：
 *    - 当字符不匹配时，不回退 haystack 指针，而是根据 next 数组将 needle 指针回退到合适位置。
 */
public class Solution5 {

    /**
     * KMP 主匹配过程
     * @param haystack 主串
     * @param needle 模式串
     * @return 匹配的第一个起始下标，若不匹配返回 -1
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        // 1. 构建 next 数组
        int[] next = getNext(needle);
        
        int j = 0; // needle 指针
        for (int i = 0; i < haystack.length(); i++) {
            // 2. 当不匹配时，needle 指针根据 next 数组不断回退
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            
            // 3. 匹配当前字符
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            
            // 4. 找到匹配结果
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * 构建 next 数组的核心逻辑
     */
    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int j = 0; // 前缀末尾，也是 [0,i] 区间内最长公共前后缀的长度
        
        for (int i = 1; i < needle.length(); i++) {
            // 前后缀不相同，j 不断回跳
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 前后缀相同，j 增加
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j; // 记录当前最长公共前后缀长度
        }
        return next;
    }

    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        
        // 示例 1: 
        String h1 = "hello", n1 = "ll";
        System.out.println("测试 1 - h: \"" + h1 + "\", n: \"" + n1 + "\"");
        System.out.println("下标: " + sol.strStr(h1, n1)); // 预期: 2

        // 示例 2: KMP 优势场景 (大量重复字符)
        String h2 = "aabaaabaaac", n2 = "aabaaac";
        System.out.println("测试 2 - h: \"" + h2 + "\", n: \"" + n2 + "\"");
        System.out.println("下标: " + sol.strStr(h2, n2)); // 预期: 4
    }
}
