package matrix;

/**
 * 面试题 01.07. 旋转矩阵
 *
 * 现有一个 NxN 的矩阵，阶数为N，请编写一个算法将矩阵顺时针旋转90度并将其作为返回值。
 * 要求不使用缓存矩阵，保证N不大于500，元素不大于256，每个元素用int表示。
 *
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Solution2 {

    public int[][] transformImage(int[][] mat, int n) {

        // 上下翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = tmp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        return mat;
    }

}
