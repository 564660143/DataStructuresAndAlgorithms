package num201_300;

import helper.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 */
class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return  findLastIndex(root, 1);
    }

    /**
     * 假如将完全二叉树从第一层开始一层层放入一个数组中, 数组索引从1开始
     * 则最后一个节点的索引值, 就是二叉树的节点个数.
     * 用于查找二叉树最后一个节点的索引值
     * @param root 当前节点
     * @param index 当前节点索引值
     * @return 最后一个节点索引值
     */
    private int findLastIndex(TreeNode root, int index){
        if (root == null) {
            return index / 2;
        }

        int leftHeight = getHeight(root.left);
        int rightHeighr = getHeight(root.right);
        // 左子树高度较高时, 最后一个节点在左子树上
        if (leftHeight > rightHeighr) {
            return findLastIndex(root.left, 2 * index);
        // 左右子树相等时, 最后一个节点在右子树上, 完全二叉树不存在右子树高度大于左子树的情况
        } else {
            return findLastIndex(root.right, index * 2 + 1);
        }

    }

    // 获取节点高度
    private int getHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 完全二叉树的高度由左侧的节点得到
        return getHeight(root.left) + 1;
    }
}