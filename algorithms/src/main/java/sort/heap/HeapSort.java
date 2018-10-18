package sort.heap;

import sort.Sort ;

/**
 * 堆排序, 使用最大堆特性进行排序
 * @author 七夜雪
 *
 */
public class HeapSort implements Sort {
	
	@Override
	public void sort(int [] arr) {
		MaxHeapByInt heap = new MaxHeapByInt(arr);
		// 堆是最大堆, 排序是从小到大排序, 所以逆向遍历
		for (int i = arr.length -1; i >= 0; i--) {
			arr[i] = heap.extractMax();
		}
	}
	
}
