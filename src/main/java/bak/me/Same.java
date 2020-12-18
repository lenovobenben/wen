package bak.me;

/**
 * 给定string stringA和string stringB，
 * 编写程序确认两字符串包含的字符是否完全相同，注意大小写为不同字符，且考虑字符串中的空格，
 * 返回一个bool，代表两串是否由一样的字符组成。保证两串的长度都小于等于5000。
 */
public class Same {

    public boolean checkSam(String A, String B) {

        if (A == null || B == null) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        } else if (A.length() == 0) {
            return true;
        } else {// 核心逻辑
            int[] numA = new int[128];
            int[] numB = new int[128];
            for (int i = 0; i < A.length(); i++) {
                numA[A.charAt(i)]++;
                numB[B.charAt(i)]++;
            }
            for (int i = 0; i < 128; i++) {
                if (numA[i] != numB[i]) {
                    return false;
                }
            }
            return true;
        }

    }

}
