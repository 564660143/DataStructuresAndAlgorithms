package linked ;

/**
 * 使用虚拟头节点实现链表
 * @author 七夜雪
 *
 * @param <E>
 */
public class MyLinkedListByDummyHead<E> {
	
	// 虚拟头节点
	private Node	dummyHead ;
	private int		size ;
	
	public MyLinkedListByDummyHead() {
		this.dummyHead = new Node() ;
		this.size = 0;
	}
	
	/**
	 * 链表头添加元素
	 * @param index
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * 指定位置添加元素
	 * 需要先找到指定位置的前一个元素
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add fail, illegal index");
		}
		
		// 要添加元素位置的前一个节点, dummyHead为虚拟头节点, 所以prev从dummyHead.next开始
		Node prev = dummyHead;
		for(int i = 0; i < index; i++){
			prev = prev.next;
		}
		
		Node node = new Node(e);
		node.next = prev.next;
		prev.next = node;
		
		// 优雅写法
		// prev.next = new Node(e, prev.next);
		size++;
		
	}
	
	/**
	 * 链表尾部添加元素
	 * @param e
	 */
	public void addLast(E e){
		add(size, e);
	}
	
	/**
	 * 判断链表中是否包含指定元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		Node node = dummyHead.next;
		while(node.next != null){
			if (node.e.equals(e)){
				return true;
			} else{
				node = node.next;
			}
		}
		return false;
	}
	
	/**
	 * 按"下标"获取元素, 这个"下标"只是一个逻辑上的下标, 事实上链表并没有下标的概念
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("get fail, illegal index");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		
		return cur.e;
	}
	
	/**
	 * 获取链表第一个元素
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}
	
	/**
	 * 获取链表最后一个元素
	 * @return
	 */
	public E getLast(){
		return get(size);
	}
	
	/**
	 * 更新指定下标的链表的值
	 * @param index
	 * @param e
	 * @return
	 */
	public E set(int index, E e){
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("set fail, illegal index");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		
		E ret = cur.e;
		cur.e = e;
		return ret;
	}
	
	/**
	 * 删除指定位置的节点
	 * @param index
	 * @return
	 */
	public E remove(int index){
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("remove fail, illegal index");
		}
		
		// 要删除节点的前一个节点
		Node prev = dummyHead;
		// 因为要查找要删除节点的前一个节点, 所以从虚拟机头节点开始遍历到index
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		Node del = prev.next;
		prev.next = del.next;
		
		// help gc
		del.next = null; 
		size--;
		return del.e;
	}
	
	/**
	 * 删除第一个节点
	 * @return
	 */
	public E removFirst(){
		return remove(0);
	}
	
	/**
	 * 删除最后一个节点
	 * @return
	 */
	public E removeLast(){
		return remove(size - 1);
	}
	
	
	public int getSIze(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("MyLinkedListByDummyHead [");
		Node cur = dummyHead.next;
		for (int i = 0; i < size; i++) {
			res.append(cur.e).append("->");
			cur = cur.next;
		}
		res.append("NULL] size= " + size);
		return res.toString() ;
	}




	/**
	 * 链表节点类
	 * @author 七夜雪
	 */
	private class Node {
		
		public E	e ;
		public Node	next ;
		
		public Node(E e, Node next) {
			this.e = e ;
			this.next = next ;
		}
		
		public Node(E e) {
			this(e, null) ;
		}
		
		public Node() {
			this(null, null) ;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + "]" ;
		}
		
	}
	
}
