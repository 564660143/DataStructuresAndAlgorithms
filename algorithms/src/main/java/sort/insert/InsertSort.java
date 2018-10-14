package sort.insert;

import sort.Sort ;
import utils.ArrayUtil ;

/**
 * 插入排序
 * @author 七夜雪
 *
 */
public class InsertSort implements Sort{

	@Override
	public void sort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					ArrayUtil.swap(arr, j, j -1);
				} else {
					break;
				}
			}
		}
	}
	
}
