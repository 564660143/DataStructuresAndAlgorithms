package num101_200;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}