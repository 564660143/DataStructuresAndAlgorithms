package num101_200;

import helper.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 以有序数组nums[]的[l...r]区间构建一颗BST
     * @param nums
     * @param l
     * @param r
     * @return 返回构建的树的根节点
     */
    private TreeNode buildBST(int[] nums, int l, int r){
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, l, mid - 1);
        root.right = buildBST(nums, mid + 1, r);
        return root;
    }

}