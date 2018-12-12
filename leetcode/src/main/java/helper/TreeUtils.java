package helper;

/**
 * 树工具类
 *
 * @author xuxiumeng
 * 2018/12/12 10:32
 */
public class TreeUtils {

    /**
     * nums
     * @param elements, 数组以完全二叉树的形式给出, 没有节点的位置用null填充
     * @return
     */
    public static TreeNode buildTree(Integer[] elements){
        if (elements == null || elements.length < 1) {
            return null;
        }

        TreeNode root = new TreeNode(elements[0]);
        buildTree(elements, root, 0);
        return root;
    }

    /**
     * 递归构建一棵树
     * @param elements 节点数组
     * @param node 当前节点
     * @param index 当前节点对应数组中的索引
     */
    private static void buildTree(Integer[] elements, TreeNode node, int index){
        if (node == null) {
            return;
        }

        int leftIndex = leftChildIndex(index);
        if (leftIndex < elements.length && elements[leftIndex] != null) {
            node.left = new TreeNode(elements[leftIndex]);
        }
        int rightIndex = rightChildIndex(index);
        if (rightIndex < elements.length && elements[rightIndex] != null) {
            node.right = new TreeNode(elements[rightIndex]);
        }
        // 递归构建左子树
        buildTree(elements, node.left, leftIndex);
        // 递归构建右子树
        buildTree(elements, node.right, rightIndex);
    }


    /**
     * 获取左孩子索引
     * @return
     */
    private static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右孩子索引
     * @return
     */
    private static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * 获取父节点
     * @return
     */
    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

}
