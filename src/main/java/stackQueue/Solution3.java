package stackQueue;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 */
public class Solution3 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNum = 1;// 当前层的元素个数。根节点为1
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int nextNum = 0;// 记录下一层的元素个数
            for (int i = 0; i < curNum; i++) {// 只取当前层的，不能多取
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextNum++;
                }
            }
            ret.add(temp);// 将当前层加入返回结果中
            curNum = nextNum;// 重置为下一层的个数
        }

        return ret;
    }
}
