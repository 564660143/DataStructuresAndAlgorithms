package sort.insert;

import sort.Sort ;

/**
 * 插入排序, 优化排序方法, 不每次进行交换, 找到元素对应位置时才进行交换
 * @author 七夜雪
 *
 */
public class InsertSort2 implements Sort{

	@Override
	public void sort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			// 保存元素i应该插入的位置
			int j;
			// arr[j - 1] > temp表示还未找到元素i应该插入的位置
			for (j = i; j > 0 && arr[j - 1] > temp ; j--) {
				// 未找到元素i应该插入的位置之前, 前面的元素只要每次往后移动一位即可
				arr[j] = arr[j - 1];
			}
			// 循环结束, j的位置就是元素i应该插入的位置
			arr[j] = temp;
		}
	}
	
}
