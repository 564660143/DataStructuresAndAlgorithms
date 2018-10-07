package heap;

import java.util.ArrayList ;
import java.util.Collection ;

/**
 * 使用动态数组实现最大堆, 这里jdk中ArrayList实现
 * 数组下标以0开始时,父节点parent(i)=i/2, left child (i)= 2*i, right child = 2*i +1
 * 数组下标以1开始时,父节点parent(i)=(i-1)/2, left child (i)= 2*i + 1, right child = 2*i +2
 * 这里使用下标为0开始
 *  
 * @author 七夜雪
 *
 */
public class MaxHeap<E extends Comparable<E>> {
	// 使用动态数组保存堆中元素
	private ArrayList<E> data;
	
	public MaxHeap(int capacity){
		data = new ArrayList<>(capacity);
	}
	
	public MaxHeap(){
		data = new ArrayList<>();
	}
	
	/**
	 * Heapify方式将集合中的元素添加到最大堆中
	 * @param collection
	 */
	public MaxHeap(Collection<E> collection){
		data = new ArrayList<>(collection);
		for(int i = parent(data.size() -1); i >= 0; i--){
			siftDown(i);
		}
	}
	
	/**
	 * 返回堆中元素个数
	 * @return
	 */
	public int getSize(){
		return data.size();
	}
	
	/**
	 * 返回堆是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	/**
	 * 返回下标为index的节点的父节点下标值
	 * @param index
	 * @return
	 */
	private int parent(int index){
		if (index == 0) {
			throw new IllegalArgumentException("下标为0的节点不存在父节点");
		}
		return (index - 1) / 2; 
	}
	
	/**
	 * 返回下标为index的节点的左孩子节点
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return 2 * index +1;
	}
	
	/**
	 * 返回下标为index的节点的右孩子节点
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return 2 * index +2;
	}
	
	/**
	 * 向最大堆中添加元素
	 * @param e
	 */
	public void add(E e)	{
		data.add(e);
		siftUp(data.size() - 1);
	}
	
	/**
	 * 节点上浮
	 * @param index
	 */
	private void siftUp(int index){
		// 不是根节点, 且当前节点大于父节点时, 和父节点交换位置
		while (index != 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	/**
	 * 查询最大堆中的最大元素
	 * @return
	 */
	public E findMax(){
		if (data.isEmpty()) {
			throw new IllegalArgumentException("当前堆为空, 无最大值");
		}
		return data.get(0);
	}

	/**
	 * 取出最大堆的元素
	 * @return
	 */
	public E extractMax(){
		// 获取最大值
		E ret = findMax();
		// 将最大值和最后一个叶子节点交换位置, 即用最后一个叶子节点替换了根节点
		swap(0, data.size() -1);
		// 删除最后一个叶子节点, 即删除了最大值
		data.remove(data.size() - 1);
		// 现在的根节点下沉
		siftDown(0);
		return ret;
	}
	
	/**
	 * 节点下沉
	 * @param index
	 */
	private void siftDown(int index){
		// 不是根节点, 且当前节点小于父节点时, 和父节点交换位置
		while (leftChild(index) < data.size()) {
			// 用于和index节点进行比较的节点, 先默认为左孩子节点
			int swapIndex = leftChild(index);
			/*
			 * swapIndex + 1 < data.size表示右孩子也不为空
			 * 右孩子节点值大于左孩子时, 使用右子树与当前节点进行比较
			 */
			if (swapIndex + 1 < data.size() && data.get(swapIndex + 1).compareTo(data.get(swapIndex)) > 0) {
				// 右孩子下标进行替换, 这里也可以直接写成swapIndex ++;
				swapIndex = rightChild(index);
			}
			
			if (data.get(swapIndex).compareTo(data.get(index)) > 0) {
				swap(index, swapIndex);
				index = swapIndex;
			} else {
				return;
			}
			
		}
	}
	
	/**
	 * 对data中的元素交换位置
	 * @param first
	 * @param second
	 */
	private void swap(int first, int second){
		E temp = data.get(first);
		data.set(first, data.get(second));
		data.set(second, temp);
	}
	
	/**
	 * 替换根节点
	 * @param e
	 * @return
	 */
	public E replace(E e){
		E ret = findMax();
		// 替换根节点
		data.set(0, e);
		// 根节点下沉
		siftDown(0);
		return ret;
	}
	
	
	
	
}
