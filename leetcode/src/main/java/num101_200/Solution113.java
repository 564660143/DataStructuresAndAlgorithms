package num101_200;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
class Solution113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findPath(root, sum, new ArrayList<>());
        return result;
    }


    /**
     * 在以root为根节点的树中查找路径和为sum的路径
     */
    private void findPath(TreeNode root, int sum, List<Integer> path){
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && sum - root.val == 0) {
            path.add(root.val);
            // 因为java是引用传递, 所以添加到result中答案要是当前path的一个副本
            result.add(new ArrayList<>(path));
            // 同样的, 因为是引用传递, 所以结果添加完成之后, 需要把当前的元素再移除掉
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        findPath(root.left, sum - root.val, path);
        findPath(root.right, sum - root.val, path);
        // 左右子节点都找不到的话, 就移除当前节点, 因为Java是引用传递的,所以要将当前节点移除
        path.remove(path.size() - 1);
    }

}