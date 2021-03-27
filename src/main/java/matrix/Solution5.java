package matrix;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution5 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {// 矩阵不存在
            return false;
        }

        int m = matrix.length;// 行
        int n = matrix[0].length;// 列
        int x1 = 0;
        int y1 = 0;
        int x2 = m - 1;
        int y2 = n - 1;

        // (x1,y1) 和 (x2,y2) 不停变化，缩小查找范围
        while (true) {
            if (x1 > x2 || y1 > y2) {// 没找到
                return false;
            } else {
                // 构成一个矩形。(x1,y1) 为矩形左上。(x2,y2)为矩形右下

                // 如果四个顶点符合，则返回 true
                if (matrix[x1][y1] == target || matrix[x2][y2] == target || matrix[x1][y2] == target || matrix[x2][y1] == target) {
                    return true;
                }

                if (matrix[x2][y1] < target) {// (x1,y1) 点所在的竖线的最下边 < 目标，则竖线放弃掉
                    y1++;
                    continue;
                }
                if (matrix[x1][y2] < target) {// 同上，(x1,y1)放弃横线
                    x1++;
                    continue;
                }
                if (matrix[x1][y2] > target) {// 同上，(x2,y2) 放弃竖线
                    y2--;
                    continue;
                }
                if (matrix[x2][y1] > target) {// 同上，(x2,y2) 放弃横线
                    x2--;
                    continue;
                }
            }
        }
    }
}