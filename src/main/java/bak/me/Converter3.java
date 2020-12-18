package bak.me;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树 -> 双向链表
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Converter3 {

    private List<TreeNode> list = new ArrayList<>();

    /**
     * 中序遍历
     */
    public void traversal(TreeNode node) {
        if (node != null) {
            traversal(node.left);
            list.add(node);
            traversal(node.right);
        }
    }

    public TreeNode Convert(TreeNode root) {
        this.traversal(root);// 放入 list 中
        if (list.size() == 0) {
            return root;
        }
        list.get(0).left = null;// 边界
        list.get(list.size() - 1).right = null;// 边界
        for (int i = 0; i < list.size(); i++) {
            if (i - 1 >= 0) {
                list.get(i).left = list.get(i - 1);
            }
            if (i + 1 < list.size()) {
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();
        Converter3 c = new Converter3();
        System.out.println(c.Convert(root));
    }
}
