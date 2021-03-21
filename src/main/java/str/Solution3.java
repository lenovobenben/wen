package str;

/**
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 */
public class Solution3 {
    public int findClosest(String[] article, String x, String y) {
        int n = article.length;
        int ret = n;// 返回值，初始化为最大长度 n
        int flag = 0;// 默认0。上一个是 X 则为1； 上一个是 Y 则为-1。
        // 上一个 X Y 的坐标，默认为-1
        int xIndex = -1;
        int yIndex = -1;
        for (int i = 0; i < n; i++) {
            if (article[i].equals(x)) {// 是X
                xIndex = i;
                if (flag == -1) {// 上一次是 Y
                    int temp = Math.abs(xIndex - yIndex);// 距离差
                    ret = Math.min(ret, temp);
                }
                flag = 1;
            } else if (article[i].equals(y)) {// 是Y
                yIndex = i;
                if (flag == 1) {// 上一个是X
                    int temp = Math.abs(xIndex - yIndex);// 距离差
                    ret = Math.min(ret, temp);
                }
                flag = -1;
            }
        }
        return ret;
    }
}