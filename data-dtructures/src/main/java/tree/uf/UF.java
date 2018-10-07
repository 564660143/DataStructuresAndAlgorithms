package tree.uf;

/**
 * 并查集接口
 * @author 七夜雪
 *
 */
public interface UF {
	/**
	 *  合并p,q两个节点
	 * @param p
	 * @param q
	 */
	public void union(int p, int q);
	/**
	 *  判断p,q两个节点是否相连
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isConnected(int p, int q);
	
	public int getSize();
}
