package num301_400;

import helper.TreeNode;

/**
 * 337. 打家劫舍 III
 */
class Solution337 {
    public int rob(TreeNode root) {
        int[] res = tryRob(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 尝试偷取以root为根节点的二叉树
     * 返回一个int[]数组res,
     * 其中res[0]表示不偷取root节点能够获得的最大值
     * res[1]表示偷取了root节点能够获得的最大值
     * @param root
     * @return
     */
    private int[] tryRob(TreeNode root){
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);
        res[0] = left[0] + right[0] + root.val;
        res[1] = Math.max(left[0], left[1]) +  Math.max(right[0], right[1]);
        return res;
    }
}