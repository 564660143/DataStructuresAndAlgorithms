package tree.uf;

/**
 * 第一版并查集, quick-sort方式实现
 * 查询时间复杂度O(1)
 * union时间复杂度O(n)
 * 使用数组实现并查集:
 * 		数组下标表示并查集id
 * 		数组值表示并查集所属的集合
 * @author 七夜雪
 *
 */
public class UnionFind1 implements UF {
	private int[] id;
	
	public UnionFind1(int size) {
		this.id = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * 合并两个节点
	 * 合并两个节点之后, 表示这两个节点相连了
	 * 同样的, 这两个节点的所有其他元素也都相连了
	 * 所以可以认为两个节点合并之后, 就是把这两个节点所在的集合合并成一个集合
	 */
	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		if (pid == qid) {
			return;
		}
		
		for (int i = 0; i < id.length; i++) {
			if (find(i) != pid) {
				id[i] = pid;
			}
		}
		
	}
	
	/**
	 * 判断节点p和节点q是否相连
	 * p,q属于一个集合时, 表示p,q相连
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q) ;
	}
	
	/**
	 * 查找节点p所属的集合
	 * @param p
	 * @return
	 */
	private int find(int p) {
		if (p < 0 || p >= id.length) {
			throw new IllegalArgumentException("节点id越界");
		}
		return id[p];
	}
	
	
	@Override
	public int getSize() {
		return id.length ;
	}
	
}
