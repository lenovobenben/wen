package matrix;

/**
 * 面试题 17.23. 最大黑方阵
 *
 * 给定一个方阵，其中每个单元非黑即白(0 代表黑色，1 代表白色)。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。
 * 若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 */
public class Solution4 {
    public int[] findSquare(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rMat = new int[m][n];// 记录从[i][j]点开始向 右 的连续的0的数量，包括自身
        int[][] cMat = new int[m][n];// 记录从[i][j]点开始向 下 的连续的0的数量，包括自身
        // 利用 dp 思路，计算 rMat 和 cMat
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {// 最右边的要初始化
                    rMat[i][j] = mat[i][j] == 0 ? 1 : 0;
                } else {// dp 思路
                    if (mat[i][j] == 0) {
                        rMat[i][j] = rMat[i][j + 1] + 1;
                    } else {
                        rMat[i][j] = 0;
                    }
                }
            }
        }

        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                if (i == m - 1) {// 最下边要初始化
                    cMat[i][j] = mat[i][j] == 0 ? 1 : 0;
                } else {// dp 思路
                    if (mat[i][j] == 0) {
                        cMat[i][j] = cMat[i + 1][j] + 1;
                    } else {
                        cMat[i][j] = 0;
                    }
                }
            }
        }


        int r = 0;
        int c = 0;
        int size = 0;
        // 双层 for 遍历矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    int maxTemp = Math.min(rMat[i][j], cMat[i][j]);// 获得 上 / 左 ，取其小
                    for (int k = maxTemp; k > size; k--) {// 从大往小遍历，校验是否符合。当 k==size 退出（因为已经存在size的正方形。不用验证更小的）
                        int down = rMat[i + k - 1][j];
                        int right = cMat[i][j + k - 1];
                        if (down >= k && right >= k) {// 符合黑色正方形
                            r = i;
                            c = j;
                            size = k;
                        }
                    }
                }
            }
        }

        return size == 0 ? new int[0] : new int[]{r, c, size};
    }
}
