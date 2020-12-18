package bak.me;

/**
 * 给定一个元素各不相同的有序序列int[] vals（升序排列）,假设创建一棵高度最小的二叉查找树，求出树的高度。
 */
public class MinimalBST {

    /**
     * 只需要得出高度即可，不用真的构造这棵树
     */
    public int buildMinimalBST(int[] vals) {

        // 完全平衡二叉树 高度是最低的。它的特征就是：每个子节点 / 2 是父节点。参照考题 LCA

        int n = vals.length;
        int i = 1;
        while (n != 1) {
            n = n >> 1;
            i++;
        }
        return i;
    }
}
