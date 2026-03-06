package backtracking;

import java.util.*;

/**
 * 93. 复原 IP 地址 (Restore IP Addresses)
 * 经典回溯题目：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 核心思路：
 * 1. 使用回溯算法 (Backtracking) 尝试在不同位置插入 "."
 * 2. 剪枝条件：
 *    - 每个部分长度在 1-3 之间。
 *    - 数值在 0-255 之间。
 *    - 不能有前导 0 (例如 "01" 不合法，但 "0" 合法)。
 *    - 总共只能有 4 个部分。
 */
public class Solution2 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backtrack(s, 0, 0, "", res);
        return res;
    }

    /**
     * @param s 原字符串
     * @param start 当前处理字符串的起始下标
     * @param count 已经确定的 IP 段数 (0-3)
     * @param current 当前拼接的 IP 字符串
     * @param res 结果集
     */
    private void backtrack(String s, int start, int count, String current, List<String> res) {
        // 终止条件：如果已经找齐 4 段且遍历完字符串
        if (count == 4) {
            if (start == s.length()) {
                res.add(current.substring(0, current.length() - 1)); // 去掉最后一个点
            }
            return;
        }

        // 回溯：尝试截取 1, 2, 3 位字符
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break; // 越界

            String segment = s.substring(start, start + i);
            
            // 校验合法性
            if (isValid(segment)) {
                backtrack(s, start + i, count + 1, current + segment + ".", res);
            }
        }
    }

    private boolean isValid(String segment) {
        // 1. 不能有前导零 (如果长度 > 1 且以 '0' 开头则不合法)
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        
        // 2. 数值必须在 0 - 255 之间
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        
        // 示例 1:
        String s1 = "25525511135";
        System.out.println("测试 1 - s: " + s1);
        System.out.println("结果: " + sol.restoreIpAddresses(s1)); 
        // 预期输出: ["255.255.11.135", "255.255.111.35"]

        // 示例 2: 前导零处理
        String s2 = "101023";
        System.out.println("测试 2 - s: " + s2);
        System.out.println("结果: " + sol.restoreIpAddresses(s2));
        // 预期输出: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]

        // 示例 3: 无法处理的情况
        String s3 = "0000";
        System.out.println("测试 3 - s: 0000");
        System.out.println("结果: " + sol.restoreIpAddresses(s3)); // 预期输出: ["0.0.0.0"]
    }
}
