package stackQueue;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 注意：从数学的角度上 ([]) 不合法（小括号中不能有中括号）。但这里是合法的！
 */
public class Solution2 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c=='(') {
                stack.push(')');
            } else if (c=='[') {
                stack.push(']');
            } else if (c=='{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop()!=c) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
