package num101_200;

import helper.TreeNode;

/**
 * 129. 求根到叶子节点数字之和
 */
class Solution129 {
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        findNum(root, 0);
        return result;
    }

    // 查找所有路径, 即所有数字
    private void findNum(TreeNode root, int num){
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result += num + root.val;
        } else {
            num += root.val;
            findNum(root.left, num * 10);
            findNum(root.right, num * 10);
        }

    }

}