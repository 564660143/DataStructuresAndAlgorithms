package num401_500;

import helper.TreeNode;

/**
 * 437. 路径总和 III
 */
class Solution437 {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        findSum(root, sum);
        return result;
    }

    // 查找以root为起始节点的所有和为sum的路径
    private void findSum(TreeNode root, int sum){
        if (root == null) {
            return;
        }
        findPath(root, sum);
        findSum(root.left, sum);
        findSum(root.right, sum);

    }

    // 从root开始查找和为sum的路径
    private void findPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.val == sum) {
            result++;
        }

        findPath(root.left, sum - root.val);
        findPath(root.right, sum - root.val);
    }

}