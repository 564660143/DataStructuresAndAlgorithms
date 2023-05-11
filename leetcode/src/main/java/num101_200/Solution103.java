package num101_200;

import helper.TreeNode;
import helper.TreeUtils;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        // 用于记录层序遍历顺序, 从左到右还是从右到左
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                // 当前层从左到右遍历
                if (isLeftToRight) {
                    node = queue.poll();
                    levelList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    // 当前层从右往左遍历
                } else {
                    node = queue.removeLast();
                    levelList.add(node.val);
                    // 下一层从左往右遍历, 所以需要从前面开始添加元素,而且从右向左
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }

            }
            isLeftToRight = !isLeftToRight;
            result.add(levelList);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] elements = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeUtils.buildTree(elements);
        new Solution103().zigzagLevelOrder(treeNode);
    }

}