package set;


public interface Set<E extends Comparable<E>> {
	/**
	 * 集合中添加元素
	 * @param e
	 */
	void add(E e);
	/**
	 * 集合中删除元素
	 * @param e
	 */
	void remove(E e);
	/**
	 * 查看集合中是否包含元素E
	 * @param e
	 * @return
	 */
	boolean contains(E e);
	/**
	 * 获取集合大小
	 * @return
	 */
	int getSize();
	/**
	 * 判断集合是否为空
	 * @return
	 */
	boolean isEmpty();
}
