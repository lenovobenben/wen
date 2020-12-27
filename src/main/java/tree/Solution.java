package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {



    /**
     * 中序遍历
     */
    public void traversal(TreeNode node, List<TreeNode> list) {

        if (node != null) {
            traversal(node.left,list);
            list.add(node);
            traversal(node.right,list);
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        this.traversal(pRootOfTree,list);
        // 改变指针
        list.get(0).left = null;
        list.get(list.size()-1).right = null;
        for (int i = 0; i < list.size(); i++) {
            if (i-1>=0) {
                list.get(i).left = list.get(i-1);
            }
            if (i+1<list.size()) {
                list.get(i).right = list.get(i+1);
            }
        }
        return list.get(0);
    }


    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.left.left.left = new TreeNode(1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = Solution.buildTree();
        new Solution().Convert(root);
    }
}
