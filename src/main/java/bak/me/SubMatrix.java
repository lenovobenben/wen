package bak.me;

/**
 * 给定一个01方阵mat及方阵的边长n，该方阵每个单元非0及1，
 * 请设计一个高效的算法，返回四条边颜色相同的最大子方阵的边长。保证母方阵边长小于等于100。
 *
 * 测试样例：
 * [[1,1,1],[1,0,1],[1,1,1]],3
 * 返回：3
 */
public class SubMatrix {
    public int maxSubMatrix(int[][] mat, int n) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left_up = mat[i][j];// 以此顶点为 左上顶点 来构造正方形
                int retTemp = 0; // 构造的正方形最大边长
                for (int k = 0; k < Math.min(n-i,n-j); k++) {// k = 正方形的边长（从0开始，最终结果要+1）
                    int right_up = mat[i][j+k];
                    int left_down = mat[i+k][j];
                    int right_down = mat[i+k][j+k];
                    if (right_up != left_up || left_down != left_up) {// 后续无法继续构造了，上边/左边是复用的
                        break;
                    }
                    if (right_down != left_up) {// 右下顶点不一致。后续继续尝试，随着 k 增大，此点成为了正方形内部的点
                        continue;
                    }

                    // 四个顶点都一样了。再判断：右边/下边 中间的点是否一样
                    boolean flag = true;
                    for (int p = 0; p < k-1; p++) {// 假如 k=2 ，则只需循环一次。k=3，循环两次。。。
                        int rightTemp = mat[i+1+p][j+k];// 右边 某个中间点
                        int downTemp = mat[i+k][j+1+p];// 下边 某个中间点
                        if (rightTemp!=left_up || downTemp!=left_up) {// 当前的正方形，右边/下边 某个中间点 不符合
                            flag = false;
                            break;// 判定为非正方形了。退出
                        }
                    }

                    if (flag) {// 右边/下边 中间的点 一样
                        retTemp = k;
                    } else {// 有不一样的，继续尝试。随着 k 增大，此点成为了正方形内部的点
                        continue;
                    }

                }
                ret = Math.max(ret,retTemp);
            }
        }

        return ret + 1;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        new SubMatrix().maxSubMatrix(mat,3);
    }
}
