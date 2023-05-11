package num201_300;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
class Solution257 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return result;
    }

    private void binaryTreePaths(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        } else {
            path = path + root.val + "->";
            binaryTreePaths(root.left, path);
            binaryTreePaths(root.right, path);
        }
    }

}