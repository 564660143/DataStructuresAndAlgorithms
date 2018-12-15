package num101_200;

import helper.TreeNode;

/**
 * 129. 求根到叶子节点数字之和
 */
class Solution129 {
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        findNum(root, "");
        return result;
    }

    // 查找所有路径, 即所有数字
    private void findNum(TreeNode root, String num){
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result += Integer.valueOf(num + root.val);
        } else {
            num += root.val;
            findNum(root.left, num);
            findNum(root.right, num);
        }

    }

}