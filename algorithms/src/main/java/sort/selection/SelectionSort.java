package sort.selection;

import sort.Sort ;
import utils.ArrayUtil ;

/**
 * 选择排序
 * @author 七夜雪
 *
 */
public class SelectionSort implements Sort{
	
	/**
	 * 对int类型数组arr进行排序
	 * @param arr
	 */
	@Override
	public void sort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			// 保存最小元素所在位置
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			ArrayUtil.swap(arr, i, minIndex);
		}
	}
	
}
