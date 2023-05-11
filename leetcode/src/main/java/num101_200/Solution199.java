package num101_200;

import helper.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 */
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}