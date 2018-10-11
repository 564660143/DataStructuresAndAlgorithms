package tree.segment;

/**
 * 使用数组实现线段树
 * @author 七夜雪
 *
 * @param <E>
 */
public class SegmentTree<E> {
	
	private Merger<E> merger;
	private E[] tree;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public SegmentTree (E[] arr, Merger<E> merger){
		this.merger = merger;
		// java中无法直接使用new E[arr.length];这种方式创建泛型数组
		data = (E[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		
		// 对于有n个元素的区间, 使用数组实现线段树的话, 需要4n的空间来存储
		tree = (E[])new Object[arr.length * 4];
		buildSegmentTree(0, 0, data.length - 1);
	}
	
	/**
	 * 在treeIndex的位置, 创建表示区间[l, r]的线段树
	 * 递归算法
	 * @param treeIndex
	 * @param l
	 * @param r
	 */
	private void buildSegmentTree(int treeIndex, int l, int r){
		// 递归到底的情况
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		int mid = l + (r - l) / 2;
		buildSegmentTree(leftTreeIndex, l, mid);
		buildSegmentTree(rightTreeIndex, mid + 1, r);
		// 根据具体场景自定义merge方法
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}
	
	/**
	 * 计算index节点左孩子的位置
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return 2 * index + 1;
	}
	
	/**
	 * 计算index节点左孩子的位置
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return 2 * index + 2;
	}
	
	/**
	 * 查询QueryL~QueryR之间的区间
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	public E query(int queryL, int queryR){
		if (queryL < 0 || queryL >=data.hashCode() || 
			queryR < 0 || queryR >= data.length ||
			queryL > queryR) {
			throw new IllegalArgumentException("无效的区间[" + queryL + ", " + queryR + "]");
		}
		
		return query(0, 0, data.length - 1 , queryL, queryR);
	}
	
	/**
	 * 从treeIndex节点开始, 在l~r的范围内查找QueryL~QueryR之间的区间
	 * @param treeIndex
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	private E query(int treeIndex, int l, int r, int queryL, int queryR){
		// 递归终结条件, 左右边界相同时, 表示找到了对应的区间
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}
		
		int mid = l + (r - l) / 2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		// 要查找的区间右边界小于mid时, 说明只需要到左子树进行查找即可
		if (queryR <= mid) {
			return query(leftTreeIndex, l, mid, queryL, queryR);
		// 要查找的区间左边界大于mid时, 说明只需要到右子树进行查找即可
		} else if (queryL > mid){
			return query(rightTreeIndex, mid + 1, r, queryL, queryR);
		// queryL <=mid < queryR这种情况需要对左右子树分别进行查找
		} else { // queryL <=mid < queryR
			return merger.merge(query(leftTreeIndex, l, mid, queryL, mid), query(rightTreeIndex, mid + 1, r, mid + 1, queryR));
		}
	}
	
	/**
	 * 更新位置index的值
	 * @param index
	 * @param value
	 */
	public void set(int index, E value){
		 if(index < 0 || index >= data.length)
	            throw new IllegalArgumentException("下标越界");

	        data[index] = value;
	        set(0, 0, data.length - 1, index, value);
	}
	
	/**
	 * 在以treeIndex为根的线段树中更新index的值为e
	 * 递归算法
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @param index
	 */
	private void set(int treeIndex, int l, int r, int index, E value){
		// 递归终止条件
		if (l == r) {
			tree[treeIndex] = value;
			return;
		}
		
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
		if (index <= mid) {
			set(leftTreeIndex, l, mid, index, value);
		} else { // index > mid
			set(rightTreeIndex, mid + 1, r, index, value);
		}
        
		// 因为所有包含index区间的值都要更新, 所以需要对treeIndex节点进行一次merge操作
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}
	
	// size
	public int getSize(){
		return data.length;
	}
	
	// get
	public E get(int index){
		if (index < 0 || index >=data.length) {
			throw new IllegalArgumentException("无效的位置 : " + index);
		}
		return data[index];
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder(); 
		res.append("SegmentTree [");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null) {
				res.append(tree[i]);
			} else {
				res.append("null");
			}
			
			if (i != tree.length -1) {
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}
	
	

	
}
