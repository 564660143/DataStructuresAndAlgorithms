package map;

/**
 * 使用二分搜索树实现Map
 * @author 七夜雪
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
	// 根节点
	private Node root ;
	// 映射大小
	private int size ;
	
	@Override
	public void add(K k, V v) {
		root = add(root, k, v) ;
	}
	
	/**
	 * 向以node节点为根节点的树上添加节点e
	 * 递归方法
	 * @param node
	 * @param k
	 */
	private Node add(Node node, K k, V v) {
		// 递归终止条件
		if (node == null) {
			size++ ;
			return new Node(k, v) ;
		}
		
		// 添加的元素键小于当前元素键, 向左递归
		if (node.k.compareTo(k) > 0) {
			node.left = add(node.left, k, v) ;
			// 添加的元素键小于当前元素键, 向右递归
		} else if (node.k.compareTo(k) < 0) {
			node.right = add(node.right, k, v) ;
		} else { // 这里设置如果键已存在, 就更新
			node.v = v;
		}
		
		return node ;
	}

	@Override
	public V remove(K k) {
		V retV = get(k);
		if (retV != null) {
			root = remove(root, k);
		}
		return retV;
	}
	
	/**
	 * 删除以node为根节点中的二分搜索树中
	 * @param node
	 * @param e
	 * @return 返回删除后的新二分搜索树的根节点
	 */
	private Node remove(Node node, K k){
		if (node == null) {
			return null;
		}
		
		// node.k > k
		if (node.k.compareTo(k) > 0) {
			node.left =remove(node.left, k);
			return node;
		// node.k < k	
		} else if (node.k.compareTo(k) < 0) {
			node.right = remove(node.right, k);
			return node;
		} else { // k == node.k
			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			
			// 待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			
			// 待删除节点左右子树均不为空的情况
			
			// 查找待删除节点的后继节点
			// 用后继节点替换当前待删除节点
			
			// 查找后继节点, 从待删除节点的右子树,查找最小值
			Node successor = minimum(node.right);
			/*
			 *  需要注意的是, 这里removeMin中进行了size--操作, 
			 *  但是实际上最小的元素变成了successor, 并没有删除
			 *  所以按照逻辑的话, 这里应该有一个size++
			 *  但是后面删除了元素之后,需要再进行一次size--, 所以这里就不对size进行操作了
			 */
			successor.right = removeMin(node.right);
			successor.left = node.left;
			// 后继节点完成替换, 删除当前节点
			node.left = node.right = null;
			return successor;
		}
	}

	@Override
	public boolean contains(K k) {
		return contains(root, k) ;
	}
	
	/**
	 * 判断树中是否包含元素e
	 * 递归方法
	 * @param node
	 * @param k
	 * @return
	 */
	private boolean contains(Node node, K k) {
		// 递归终结条件
		if (node == null) { 
			return false ; 
		}
		
		if (node.k.compareTo(k) == 0) {
			return true;
		} else if (node.k.compareTo(k) > 0) {
			return contains(node.left, k) ;
		} else { // node.e < e
			return contains(node.right, k) ;
		} 
	}

	@Override
	public V get(K k) {
		Node retNode = get(root, k);
		return root == null ? null : retNode.v ;
	}
	
	/**
	 * 根据键查找值
	 * 递归方法
	 * @param node
	 * @param k
	 * @return
	 */
	private Node get(Node node, K k) {
		// 递归终结条件
		if (node == null) { 
			return null ; 
		}
		
		if (node.k.compareTo(k) == 0) {
			return node;
		} else if (node.k.compareTo(k) > 0) {
			return get(node.left, k) ;
		} else { // node.k < k
			return get(node.right, k) ;
		}
	}

	@Override
	public void set(K k, V v) {
		if (!contains(k)) {
			throw new IllegalArgumentException("不存在的键值 :" + k);
		}
		// 直接调用增加元素的方法, add方法中包含更新逻辑
		add(k, v);
		
	}

	@Override
	public int getSize() {
		return size ;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ;
	}
	
	/**
	 * 查找树中最小元素
	 * @return
	 */
	public K minimum(){
		if (size == 0) {
			throw new IllegalArgumentException("BSTMap is empty");
		}
		return minimum(root).k;
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
	 * 删除二分搜索树中的最小值
	 * @return
	 */
	public K removeMin(){
		K ret = minimum();
		root = removeMin(root);
		return ret;
	}
	
	/**
	 * 删除以node为根节点的树的最小值
	 * @param node
	 * @return 返回删除后的新的二分搜索树的根
	 */
	private Node removeMin(Node node){
		// 递归终止条件
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	
	
	
	/**
	 * 二分搜索树节点类
	 * @author 七夜雪
	 *
	 */
	private class Node {
		public K	k ;
		public V	v ;
		// 左右子树
		public Node	left , right ;
		
		public Node(K k, V v) {
			this.k = k ;
			this.v = v ;
			this.left = null ;
			this.right = null ;
		}
	}
}
