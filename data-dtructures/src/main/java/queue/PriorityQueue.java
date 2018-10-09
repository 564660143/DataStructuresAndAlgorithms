package queue;

import heap.MaxHeap ;

/**
 * 使用最大堆实现优先队列
 * @author 七夜雪
 *
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;
	
	public PriorityQueue() {
		maxHeap = new MaxHeap<>();
	}
	
	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax() ;
	}

	@Override
	public E getFront() {
		return maxHeap.findMax() ;
	}

	@Override
	public int getSize() {
		return maxHeap.getSize() ;
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty() ;
	}
	
}
