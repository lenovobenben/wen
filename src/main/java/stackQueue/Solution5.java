package stackQueue;

import java.util.*;

/**
 * 基础计算器 (支持 + - * / ( ) 和 整数)
 * 核心思路：
 * 1. 递归处理括号：把括号内的表达式看作一个子问题。
 * 2. 栈处理优先级：
 *    - '+' : 压入 num
 *    - '-' : 压入 -num
 *    - '*' : 弹出栈顶与 num 相乘后压回
 *    - '/' : 弹出栈顶与 num 相除后压回 (Java 整数除法默认取整)
 * 3. 结果：栈中所有元素求和。
 */
public class Solution5 {

    private int index = 0; // 全局索引，用于递归遍历字符串

    public int calculate(String s) {
        index = 0; // 重置索引
        return helper(s);
    }

    private int helper(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        while (index < s.length()) {
            char c = s.charAt(index++);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                num = helper(s); // 递归处理括号
            }

            // 如果是运算符，或者是最后一个字符，则结算上一个运算符
            if ((!Character.isDigit(c) && c != ' ') || index == s.length()) {
                switch (sign) {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                sign = c;
                num = 0;
            }

            if (c == ')') {
                break; // 结束当前层递归
            }
        }

        // 计算当前层结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 sol = new Solution5();

        // 示例 1: 基础优先级
        String s1 = "1 + 2 * 3";
        System.out.println("测试 1 - \"" + s1 + "\": " + sol.calculate(s1)); // 预期: 7

        // 示例 2: 括号嵌套
        String s2 = "(1 + (4 + 5 + 2) - 3) + (6 + 8)";
        System.out.println("测试 2 - \"" + s2 + "\": " + sol.calculate(s2)); // 预期: 23

        // 示例 3: 整数除法地板值
        String s3 = "1 / 3 * 3";
        System.out.println("测试 3 - \"" + s3 + "\": " + sol.calculate(s3)); // 预期: 0 (1/3=0, 0*3=0)

        // 示例 4: 综合运算
        String s4 = "3 * (2 + 10 / 2) - 5";
        System.out.println("测试 4 - \"" + s4 + "\": " + sol.calculate(s4)); // 预期: 3*(2+5)-5 = 16
    }
}
