package tree.uf;

/**
 * 第三版并查集, 记录每个根节点所在的树的节点数量, 合并时数量少的树合并到数量多的树上面
 * 使用树来实现并查集
 * 将数组组织成树的形式, 每个节点都指向一个父节点, 根节点指向自己
 * 使用数组索引表示当前节点位置, 数组值表示父节点索引位置
 * 
 * 查询和union操作时间复杂度都是O(h), h表示树高度
 * @author 七夜雪
 *
 */
public class UnionFind3 implements UF {
	private int[] parent;
	// 下标为对应根节点下标, 数组值为对应根节点对应树的节点数量
	private int[] sz;
	
	public UnionFind3(int size) {
		this.parent = new int[size];
		this.sz = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			sz[i] = 1;
		}
	}
	
	/**
	 * 合并两个节点
	 * 合并两个节点之后, 表示这两个节点相连了
	 * 同样的, 这两个节点的所有其他元素也都相连了
	 * 所以可以认为两个节点合并之后, 就是把这两个节点所在的集合合并成一个集合
	 * 合并方式:
	 * 		找到节点p的根节点, 将p的根节点指向q的根节点
	 * 
	 */
	@Override
	public void union(int p, int q) {
		// p的根节点
		int pRoot = find(p);
		// q的根节点
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		
		if (sz[pRoot] < sz[qRoot]) {
			// 将p的根节点指向q的根节点
			parent[pRoot] = qRoot;
			 sz[qRoot]+= sz[pRoot];
		} else {
			// 将q的根节点指向p的根节点
			parent[qRoot] = pRoot;
			sz[pRoot]+= sz[qRoot];
		}
	}
	
	/**
	 * 判断节点p和节点q是否相连
	 * p,q属于一个集合时, 表示p,q相连, 这里表示p,q有一个共同的根节点
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q) ;
	}
	
	/**
	 * 查找节点p所属的跟节点
	 * @param p
	 * @return
	 */
	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException("节点id越界");
		}
		while(p != parent[p]){
			p = parent[p];
		}
		return p;
	}
	
	
	@Override
	public int getSize() {
		return parent.length ;
	}
	
}
