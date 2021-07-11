package tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class Solution7 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildNode(nums, start, mid - 1);
        node.right = buildNode(nums, mid + 1, end);
        return node;
    }

}
