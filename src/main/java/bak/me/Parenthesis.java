package bak.me;

/**
 * 给定一个字符串A和其长度n，请返回一个bool值代表它是否为一个合法的括号串（只能由括号组成）。
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {

        int status = 0;
        for (int i = 0; i < n; i++) {
            char temp = A.charAt(i);
            if (temp == '(') {
                status++;
            } else if (temp == ')') {
                status--;
                if (status < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
