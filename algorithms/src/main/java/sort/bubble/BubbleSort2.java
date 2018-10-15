package sort.bubble;

import sort.Sort ;
import utils.ArrayUtil ;

/**
 * 冒泡排序
 * @author 七夜雪
 *
 */
public class BubbleSort2 implements Sort {
	
	@Override
	public void sort(int [] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// 用于记录数组是否已经是有序的了
			boolean isSorted = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				// 如果本次循环数组发生交换, 就认为数组还不是有序的
				if (arr[j] > arr[j + 1]) {
					ArrayUtil.swap(arr, j, j + 1);
					isSorted = false;
				}
			}
			
			// 如果内存循环结束, isSorted扔为true, 则表示数组已经排序完成
			if (isSorted) {
				break;
			}
		}
	}
	
}
