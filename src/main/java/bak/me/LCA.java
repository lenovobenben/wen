package bak.me;

/**
 * 将一棵无穷大满二叉树的结点按根结点一层一层地从左往右编号，根结点编号为1。
 * 现给定a，b为两个结点。设计一个算法，返回a、b最近的公共祖先的编号。注意其祖先也可能是结点本身。
 */
public class LCA {

    /**
     * 规律：每个节点 / 2 ，正好是父节点！！！
     */
    public int getLCA(int a, int b) {
        if (a == b) return a;

        while (a != b) {
            if (a > b) {
                a >>= 1;
            } else {
                b >>= 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new LCA().getLCA(8, 11));
    }
}
