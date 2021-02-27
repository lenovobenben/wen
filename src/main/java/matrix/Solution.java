package matrix;

/**
 * 718. 最长重复子数组
 *
 * （略不同）
 *
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 */
public class Solution {

    public String LCS_(String str1, String str2) {
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


    /**
     * 两个字符串组成矩阵。所有的斜45°线中，求 最长的相同区间
     */
    public String LCS2(String str1, String str2) {
        int start = 0;// 重复的子串开始位置
        int len = 0;// 重复的最大长度
        for (int i = 0; i < str1.length(); i++) {// 每行第1列，斜下方45°
            int iTemp = i;
            int startTemp = 0;// 每条斜线上的最大长度的开始位置
            int lenTemp = 0;// 每条斜线上的最大长度
            int startIter = 0;// 每条斜线的临时开始位置
            int lenIter = 0;// 每条斜线的临时长度
            for (int j = 0; j < str2.length(); j++,iTemp++) {
                if (iTemp >= str1.length()) {
                    break;
                }
                if (str1.charAt(iTemp) == str2.charAt(j)) {// 相同
                    lenIter++;// 临时长度+1
                    if (lenIter > lenTemp) {// 重置当前斜线的最大值
                        lenTemp = lenIter;
                        startTemp = startIter;
                    }
                } else {// 不相同，重置 临时开始位置 和 临时长度
                    startIter = iTemp + 1;// 当前的不相同，只能期待下一个是相同的
                    lenIter = 0;
                }
            }

            if (lenTemp > len) {// 重置 全局最大值
                len = lenTemp;
                start = startTemp;
            }
        }

        return str1.substring(start, start + len);
    }

    public String LCS(String str1, String str2) {
        String s1 = this.LCS2(str1, str2);
        String s2 = this.LCS2(str2, str1);
        String ret = s1.length() > s2.length() ? s1 : s2;
        return ret.equals("") ? "-1" : ret;
    }

}
