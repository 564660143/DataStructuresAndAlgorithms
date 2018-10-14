package tree.avl ;

import java.util.ArrayList ;
import java.util.List ;

/**
 * 递归实现AVL平衡二叉树
 * 这里设计的树是不存储重复元素的, 重复添加元素只保存一个
 * @author 七夜雪
 *
 */
public class AVLTree<K extends Comparable<K>, V> {
	
	// 根节点
	private Node root ;
	// 树容量
	private int size ;
	
	public AVLTree() {
		this.root = null ;
		this.size = 0 ;
	}
	
	public boolean isEmpty() {
		return size == 0 ;
	}
	
	public int getSize(){
		return size;
	}
	
	/**
	 * 获取节点高度
	 * @param node
	 * @return
	 */
	private int getHeight(Node node){
		if (node == null) {
			return 0;
		}
		return node.height;
	}
	
	/**
	 * 获取节点平衡因子
	 * @param node
	 * @return
	 */
	private int getBalanceFactor(Node node){
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
	
	/**
	 * 判断树是否符合二分搜索树的特点
	 * 根据二分搜索树的中序遍历具有顺序的特点来判断
	 * @return
	 */
	public boolean isBST(){
		List<K> keys = new ArrayList<>();
		inOrder(root, keys);
		for (int i = 1; i < keys.size(); i++) {
			if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
				return false;
			}
		}
		
		return  true;
	}
	
	/**
	 * 
	 * 中序遍历的递归方法, 深度优先
	 * 中序遍历指的是访问当前元素的顺序放在访问左右子节点之间
	 * 中序遍历的结果是有序的
	 * @param node
	 */
	private void inOrder(Node node, List<K> keys) {
		// 递归终止条件
		if (node == null) { 
			return ; 
		}
		
		// 1. 中序遍历访问左孩子
		inOrder(node.left, keys) ;
		// 2. 中序遍历先访问当前节点
		keys.add(node.key);
		// 3. 中序遍历访问右孩子
		inOrder(node.right, keys) ;
	}
	
	/**
	 * 判断是否为平衡二叉树
	 * @return
	 */
	public boolean isBalanced(){
		return isBalanced(root);
	}
	
	/**
	 *  判断node节点的平衡因子是否符合AVL树特性
	 *  递归方法
	 * @param node
	 * @return
	 */
	private boolean isBalanced(Node node){
		// 递归终止条件
		if (node == null) {
			return true;
		}
		
		// 获取节点平衡因子
		int balanceFactor = getBalanceFactor(node);
		// 节点平衡因子大于1时表示不再是AVL树
		if (Math.abs(balanceFactor) > 1) {
			System.out.println(node.key +  ":" + balanceFactor) ;
			return false;
		}
		
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	
	/**
	 * 向二分搜索树上添加节点
	 * @param e
	 */
	public void add(K key, V value) {
		root = add(root, key, value) ;
	}
	
	/**
	 * 向以node节点为根节点的树上添加节点e
	 * 递归方法
	 * @param node
	 * @param e
	 */
	private Node add(Node node, K key, V value) {
		// 递归终止条件
		if (node == null) {
			size++ ;
			return new Node(key, value) ;
		}
		
		// 添加的元素小于当前元素, 向左递归
		if (node.key.compareTo(key) > 0) {
			node.left = add(node.left, key, value) ;
			// 添加的元素小于当前元素, 向右递归
		} else if (node.key.compareTo(key) < 0) {
			node.right = add(node.right, key, value) ;
		} else {
			node.value = value;
		}
		
		// 更新节点高度
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(node);
		
		// 平衡维护, 右旋转,  LL 
		if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
			return rightRotate(node);
		}
		
		// 平衡维护, 左旋转,  RR
		if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
			return leftRotate(node);
		}
		
		// 平衡维护, LR, 先左旋转转换成LL, 再右旋转
		if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
			// LR的情况先对当前节点的左孩子进行左旋转
			node.left = leftRotate(node.left);
			// 再对当前节点进行右旋转
			return rightRotate(node);
		}
		
		// 平衡维护, RL, 先右旋转转换成RR, 再左旋转
		if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
			// RL的情况先对当前节点的右孩子进行右旋转
			node.right = rightRotate(node.right);
			// 再对当前节点进行左旋转
			return leftRotate(node);
		}
		
		return node ;
	}
	
	/**
	 * 对y节点进行右旋转操作
	 *          y                                      x
     *         / \                                   /     \
     *       x   T4     向右旋转 (y)        z        y
     *      / \       - - - - - - - ->        / \      /  \
     *     z   T3                            T1  T2  T3   T4
     *    / \
     *  T1   T2
	 * 
	 * @param y
	 * @return 返回旋转之后的平衡二叉树的根节点
	 */
	private Node rightRotate(Node y){
		Node x = y.left;
		Node T3 = x.right;
		
		// 右旋转操作
		x.right = y;
		y.left = T3;
		
		// 高度维护, 因为x节点的高度要依赖于y的高度, 所以要先计算y节点的高度
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	/**
	 * 对y节点进行左旋转操作
	 * 
     *           y                                      x
     *         /  \                                 /       \
     *       T1   x      向左旋转 (y)       y         z
     *             / \   - - - - - - - ->     / \      /   \
     *           T2  z                        T1 T2  T3  T4
     *                / \
     *              T3 T4
	 * @param y
	 * @return 返回旋转之后的平衡二叉树的根节点
	 */
	private Node leftRotate(Node y){
		Node x = y.right;
		Node T2 = x.left;
		
		// 右旋转操作
		x.left = y;
		y.right = T2;
		
		// 高度维护, 因为x节点的高度要依赖于y的高度, 所以要先计算y节点的高度
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	/**
	 * 判断树中是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(K key) {
		return contains(root, key) ;
	}
	
	/**
	 * 判断树中是否包含元素e
	 * 递归方法
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node, K key) {
		// 递归终结条件
		if (node == null) { 
			return false ; 
		}
		
		if (node.key.compareTo(key) == 0) {
			return true;
		} else if (node.key.compareTo(key) > 0) {
			return contains(node.left, key) ;
		} else { // node.e < e
			return contains(node.right, key) ;
		} 
		
	}
	
	/**
	 * 根据key值获取value
	 * @param key
	 * @return
	 */
	public V get(K key){
		return get(root, key);
	}
	
	/**
	 * 判断树中是否包含元素e
	 * 递归方法
	 * @param node
	 * @param e
	 * @return
	 */
	private V get(Node node, K key) {
		// 递归终结条件
		if (node == null) { 
			return null ; 
		}
		
		if (node.key.compareTo(key) == 0) {
			return node.value;
		} else if (node.key.compareTo(key) > 0) {
			return get(node.left, key) ;
		} else { // node.e < e
			return get(node.right, key) ;
		} 
		
	}
	
	
	/**
	 * 查找树中最小元素
	 * @return
	 */
	public K minimum(){
		if (size == 0) {
			throw new IllegalArgumentException("BSTree is empty");
		}
		return minimum(root).key;
	}
	
	/**
	 * 查找以node为根节点的最小元素, 递归方法
	 * @param node
	 * @return
	 */
	private Node minimum(Node node){
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}
	
	/**
	 * 查找树中最大元素
	 * @return
	 */
	public K maximum(){
		if (size == 0) {
			throw new IllegalArgumentException("BSTree is empty");
		}
		return maximum(root).key;
	}
	
	/**
	 * 查找以node为根节点的最大元素, 递归方法
	 * @param node
	 * @return
	 */
	private Node maximum(Node node){
		if (node.right == null) {
			return node;
		}
		return maximum(node.right);
	}
	
	
	/**
	 * 删除指定元素e所在的节点
	 * @param e
	 */
	public void remove(K key){
		root = remove(root, key);
	}
	
	/**
	 * 删除以node为根节点中的二分搜索树中
	 * @param node
	 * @param e
	 * @return 返回删除后的新二分搜索树的根节点
	 */
	private Node remove(Node node, K key){
		if (node == null) {
			return null;
		}
		
		Node retNode;
		// node.e > e
		if (node.key.compareTo(key) > 0) {
			node.left =remove(node.left, key);
			retNode = node;
		// node.e < e	
		} else if (node.key.compareTo(key) < 0) {
			node.right = remove(node.right, key);
			retNode = node;
		} else { // e == node.e
			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size --;
				retNode = rightNode;
			// 待删除节点右子树为空的情况
			} else if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				retNode = leftNode;
			// 待删除节点左右子树均不为空的情况
			} else {
				// 查找待删除节点的后继节点
				// 用后继节点替换当前待删除节点
				
				// 查找后继节点, 从待删除节点的右子树,查找最小值
				Node successor = minimum(node.right);
				// 这个时候要删除的节点的key和successor的key是相等的
				successor.right = remove(node.right, successor.key);
				successor.left = node.left;
				// 后继节点完成替换, 删除当前节点
				node.left = node.right = null;
				retNode = successor;
			}
		}
		
		if (retNode == null) {
			return null;
		}
		
		/**********************平衡维护操作******************************/
		// 更新节点高度
		retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
		
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(retNode);
		
		// 平衡维护, 右旋转,  LL 
		if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
			return rightRotate(retNode);
		}
		
		// 平衡维护, 左旋转,  RR
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
			return leftRotate(retNode);
		}
		
		// 平衡维护, LR, 先左旋转转换成LL, 再右旋转
		if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
			// LR的情况先对当前节点的左孩子进行左旋转
			node.left = leftRotate(retNode.left);
			// 再对当前节点进行右旋转
			return rightRotate(retNode);
		}
		
		// 平衡维护, RL, 先右旋转转换成RR, 再左旋转
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
			// RL的情况先对当前节点的右孩子进行右旋转
			node.right = rightRotate(retNode.right);
			// 再对当前节点进行左旋转
			return leftRotate(retNode);
		}
		/**********************平衡维护操作******************************/
		
		return retNode;
	}
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateString(root, 0, res);
		return res.toString();
	}
	
	/**
	 * 生成以node为根节点，深度为depth的描述二叉树的字符串
	 * @param node 根节点
	 * @param depth 深度
	 * @param res 用于拼接字符串的StringBuilder
	 * @return
	 */
	private void generateString(Node node, int depth, StringBuilder res){
		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
            return; 
		}
		res.append(generateDepthString(depth)).append(node.key + "\n");
		generateString(node.left, depth + 1, res);
		generateString(node.right, depth + 1, res);
	}

	private StringBuilder generateDepthString(int depth){
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res;
	}

	/**
	 * 二分搜索树节点类
	 * @author 七夜雪
	 *
	 */
	private class Node {
		public K key ;
		public V value;
		// 左右子树
		public Node	left , right ;
		public int height;
		
		public Node(K key, V value) {
			this.key = key ;
			this.value = value ;
			// 叶子节点高度默认为1
			this.height = 1;
			this.left = null ;
			this.right = null ;
		}
	}
}
