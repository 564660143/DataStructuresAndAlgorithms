package num401_500;

import helper.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
class Solution450 {
    /**
     * 在以root为根节点的二分搜索树中删除节点key
     * @param root
     * @param key
     * @return 返回删除后新的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            // key大于当前节点, 从右子树删除节点key, 返回删除节点key后新的根节点
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            // key小于当前节点, 从左子树删除节点key, 返回删除节点key后新的根节点
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            // 左子树为空的情况
            if (root.left == null) {
                return root.right;
            }
            // 右子树为空的情况
            if (root.right == null) {
                return root.left;
            }

            // 左右子树都不为空的情况
            // 从右子树查找当前节点的后继节点
            TreeNode successor = findMin(root.right);
            // 在右子树中删除后继节点
            successor.right = deleteMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
    }

    /**
     * 查找以root为根节点的二分搜索树中的最小值, 用于删除节点时查找后继元素
     * @param root
     * @return 返回
     */
    private TreeNode findMin(TreeNode root){
        if (root.left != null) {
            return findMin(root.left);
        }
        return root;
    }

    /**
     * 删除root为根节点的二分搜索树中的最小值
     * @param root
     * @return 返回删除节点后的树的根节点
     */
    private TreeNode deleteMin(TreeNode root){
        if (root.left != null) {
            root.left = deleteMin(root.left);
            return root;
        }
        return root.right;
    }

}