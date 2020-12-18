package bak.me;

/**
 * 给定一个string数组article（有单词构成）和数组中元素的个数n，
 * 同时给定数组中的两个单词x和y。
 * 请返回这两个单词的最短距离（比如两个单词分别在第1和第3个位置，则最短距离为2）。
 * 保证两个单词不相同且均在数组中出现，同时保证数组中单词数小于等于1000。
 */
public class Distance {

    public int getDistance(String[] article, int n, String x, String y) {

        int ret = n;// 返回值，初始化为最大长度 n

        int flag = 0;// 默认0。上一个是 X 则为1； 上一个是 Y 则为-1。

        // 上一个 X Y 的坐标
        int xIndex = -1;
        int yIndex = -1;

        for (int i = 0; i < n; i++) {

            if (article[i].equals(x)) {// 是X
                xIndex = i;

                if (flag==-1) {// 上一次是 Y
                    int temp = Math.abs(xIndex - yIndex);// 距离差
                    if (temp < ret) {
                        ret = temp;// 替换 ret
                    }
                }

                flag = 1;
            } else if (article[i].equals(y)) {// 是Y
                yIndex = i;

                if (flag==1) {// 上一个是X
                    int temp = Math.abs(xIndex - yIndex);// 距离差
                    if (temp < ret) {
                        ret = temp;// 替换 ret
                    }
                }

                flag = -1;
            }
        }

        return ret;
    }
}
