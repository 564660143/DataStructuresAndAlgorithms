package map;


public interface Map<K extends Comparable<K>, V> {
	/**
	 * 映射中添加元素
	 * @param k
	 * @param v
	 */
	void add(K k, V v);
	/**
	 * 根据键K删除映射中元素
	 * @param k
	 * @return
	 */
	V remove(K k);
	/**
	 * 判断映射中是否包含键值K
	 * @param k
	 * @return
	 */
	boolean contains(K k);
	/**
	 * 根据键K查找值V
	 * @param k
	 * @return
	 */
	V get(K k);
	/**
	 * 更新键为K元素值
	 * @param k
	 * @param v
	 */
	void set(K k, V v);
	/**
	 * 获取映射大小
	 * @return
	 */
	int getSize();
	/**
	 * 判断映射是否为空
	 * @return
	 */
	boolean isEmpty();
}
