package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历构造二叉树
 */
public class Solution8 {

    private Map<Integer, Integer> inIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * preorder[preL..preR], inorder[inL..inR]
     */
    private TreeNode build(int[] preorder, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inIndexMap.get(rootVal);
        int leftSize = inIndex - inL;

        root.left = build(preorder, preL + 1, preL + leftSize, inL, inIndex - 1);
        root.right = build(preorder, preL + leftSize + 1, preR, inIndex + 1, inR);
        return root;
    }
}
