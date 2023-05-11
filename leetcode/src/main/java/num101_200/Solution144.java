package num101_200;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}