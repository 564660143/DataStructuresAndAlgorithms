package set;

import tree.bst.BSTree ;

/**
 * 直接使用二分搜索树实现集合
 * @author 七夜雪
 *
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
	private BSTree<E> bst;
	
	public BSTSet() {
		this.bst = new BSTree<>() ;
	}

	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e) ;
	}

	@Override
	public int getSize() {
		return bst.getSize() ;
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty() ;
	}
	
	
	
}
