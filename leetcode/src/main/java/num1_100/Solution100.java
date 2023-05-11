package num1_100;

import helper.TreeNode;

/**
 * 100. 相同的树
 */
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == q) {
                return true;
            }
            return false;
        } else {
            // 判断当前节点是否相等
            if (p.val != q.val) {
                return false;
            }
            // 判断左子树是否相等
            boolean leftIsEqual = isSameTree(p.left, q.left);
            // 判断右子树是否相等
            boolean rightIsEqual = isSameTree(p.right, q.right);
            return leftIsEqual && rightIsEqual;
        }
    }
}