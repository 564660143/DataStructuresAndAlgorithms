package linked;

import org.junit.Test ;

public class LinkedTest {
	
	/**
	 * 链表基础功能测试
	 */
	@Test
	public void testBasic(){
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList) ;
		}
		
		linkedList.removFirst();
		System.out.println(linkedList) ;
		linkedList.removeLast();
		System.out.println(linkedList) ;
		linkedList.set(1, 666);
		System.out.println(linkedList) ;
	}
	
	/**
	 * 链表基础功能测试
	 */
	@Test
	public void testBasicByDummyHead(){
		MyLinkedListByDummyHead<Integer> linkedList = new MyLinkedListByDummyHead<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList) ;
		}
		
		linkedList.removFirst();
		System.out.println(linkedList) ;
		linkedList.removeLast();
		System.out.println(linkedList) ;
		linkedList.set(1, 666);
		System.out.println(linkedList) ;
	}
	
	/**
	 * 链表删除测试
	 */
	@Test
	public void testRemove(){
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList) ;
		}
		
		for (int i = 0; i < 5; i++) {
			linkedList.removeLast();
			System.out.println(linkedList) ;
		}
	}
	
	/**
	 * 链表删除测试
	 */
	@Test
	public void testRemoveByDummyHead(){
		MyLinkedListByDummyHead<Integer> linkedList = new MyLinkedListByDummyHead<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList) ;
		}
		
		for (int i = 0; i < 5; i++) {
			linkedList.removeLast();
			System.out.println(linkedList) ;
		}
	}
	
	
	
}
