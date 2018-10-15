package sort.bubble;

import sort.Sort ;
import utils.ArrayUtil ;

/**
 * 冒泡排序
 * @author 七夜雪
 *
 */
public class BubbleSort implements Sort {
	
	@Override
	public void sort(int [] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					ArrayUtil.swap(arr, j, j + 1);
				}
			}
		}
	}
	
}
