package sort.heap;

import utils.ArrayUtil ;

/**
 * 使用数组实现用于堆排序的最大堆
 * 数组下标以0开始时,父节点parent(i)=i/2, left child (i)= 2*i, right child = 2*i +1
 * 数组下标以1开始时,父节点parent(i)=(i-1)/2, left child (i)= 2*i + 1, right child = 2*i +2
 * 这里使用下标为1开始
 *  
 * @author 七夜雪
 *
 */
public class MaxHeapByInt {
	private int[] data;
	// 用于记录堆中元素个数
	private int size;
	
	
	/**
	 * Heapify方式将集合中的元素添加到最大堆中
	 * @param collection
	 */
	public MaxHeapByInt(int[] arr){
		data = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			data[i + 1] = arr[i];
		}
		size = arr.length;
		for(int i = parent(data.length -1); i >= 1; i--){
			siftDown(i);
		}
	}
	
	/**
	 * 返回堆中元素个数
	 * @return
	 */
	public int getSize(){
		return data.length - 1;
	}
	
	/**
	 * 返回堆中元素个数
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 返回下标为index的节点的父节点下标值
	 * @param index
	 * @return
	 */
	private int parent(int index){
		if (index <= 1) {
			throw new IllegalArgumentException("下标为1的节点不存在父节点");
		}
		return index / 2; 
	}
	
	/**
	 * 返回下标为index的节点的左孩子节点
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return 2 * index;
	}
	
	/**
	 * 返回下标为index的节点的右孩子节点
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return 2 * index + 1;
	}
	
	
	/**
	 * 查询最大堆中的最大元素
	 * @return
	 */
	public int findMax(){
		if (isEmpty()) {
			throw new IllegalArgumentException("当前堆为空, 无最大值");
		}
		return data[1];
	}

	/**
	 * 取出最大堆的元素
	 * @return
	 */
	public int extractMax(){
		// 获取最大值
		int ret = findMax();
		// 将最大值和最后一个叶子节点交换位置, 即用最后一个叶子节点替换了根节点
		ArrayUtil.swap(data, 1, size -1);
		// 删除最后一个叶子节点, 即删除了最大值, 这里直接使用size--表示删除
		size--;
		// 现在的根节点下沉
		siftDown(1);
		return ret;
	}
	
	/**
	 * 节点下沉
	 * @param index
	 */
	private void siftDown(int index){
		// 不是根节点, 且当前节点小于父节点时, 和父节点交换位置
		while (leftChild(index) < size) {
			// 用于和index节点进行比较的节点, 先默认为左孩子节点
			int swapIndex = leftChild(index);
			/*
			 * swapIndex + 1 < data.size表示右孩子也不为空
			 * 右孩子节点值大于左孩子时, 使用右子树与当前节点进行比较
			 */
			if (swapIndex + 1 < size && data[swapIndex + 1] > data[swapIndex]) {
				// 右孩子下标进行替换, 这里也可以直接写成swapIndex ++;
				swapIndex = rightChild(index);
			} 
			
			if (data[swapIndex] > data[index]) {
				ArrayUtil.swap(data, index, swapIndex);
				index = swapIndex;
			} else {
				return;
			}
			
		}
	}
	
}
