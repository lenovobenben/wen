package bak.me;

import java.util.HashSet;

/**
 * 给定一个N阶方阵int[][] mat及其阶数n，若方阵中某个元素为0，则将其所在的行与列清零。返回改变后的int[][]方阵。
 */
public class Clearer {

    public int[][] clearZero(int[][] mat, int n) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (set1.contains(i)) {
                for (int k = 0; k < n; k++) {
                    mat[i][k] = 0;// 此行 清零
                }
            }
            if (set2.contains(i)) {
                for (int k = 0; k < n; k++) {
                    mat[k][i] = 0;// 此列 清零
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        new Clearer().clearZero(arr, 3);
    }

}
