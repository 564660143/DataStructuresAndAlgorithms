package sort.merge;

import sort.Sort ;
import utils.ArrayUtil ;

/**
 * 自底向上的归并排序
 * @author 七夜雪
 *
 */
public class MergeSortBU implements Sort {
	
	@Override
	public void sort(int [] arr) {
		int length = arr.length;
		// 数组元素个数小于等于16时, 直接使用插入排序
		if (length <= 16) {
			ArrayUtil.insertSort(arr, 0, length);
			return;
		}
		
		for (int sz = 8; sz < length; sz += sz) {
			// 每次遍历2*sz个长度
			for (int i = 0; i + sz < length; i +=sz + sz) {
				if (sz == 8 ) {
					ArrayUtil.insertSort(arr, i, Math.min(i + sz + sz -1, length - 1));
				} else {
					if (arr[i + sz - 1] > arr[i + sz]) {
						// 对[i, i + sz -1]和[i + sz, 2*sz + i -1]区间进行merge操作
						merge(arr, i, i + sz - 1, Math.min(i + sz + sz -1, length - 1));
					}
				}
			}
		}
		
	}
	
	
	
	/**
	 * 对数组[l, mid], [mid + 1, r]这两部分进行归并
	 * @param arr
	 * @param l
	 * @param mid
	 * @param r
	 */
	private void merge(int[] arr, int l, int mid, int r){
		// 用于归并排序的辅助空间, 因为[l, r]是前闭后闭的区间, 所以aux的大小是r - l + 1
		int[] aux = new int[r - l + 1];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = arr[i + l];
		}
		
//		for (int i = l; i <= r; i++) {
//			aux[i - l] = arr[i];
//		}
		
		// 用于记录左半部分数组下标
		int leftIndex = l;
		// 用于记录右半部分数组下标
		int rightIndex = mid + 1;
		// 循环进行归并
		for (int k = l; k <= r; k++) {
			// 表示左侧部分已经完成归并, 直接使用右侧部分进行归并
			if (leftIndex > mid) {
				arr[k] = aux[rightIndex - l];
				rightIndex++;
			// 表示右侧部分已经完成归并, 直接使用左侧部分进行归并
			} else if (rightIndex > r) {
				arr[k] = aux[leftIndex - l];
				leftIndex++;
			// 左侧元素小于右侧元素, 使用左边元素进行归并
			} else if (aux[leftIndex - l] < aux[rightIndex - l]) {
				arr[k] = aux[leftIndex - l];
				leftIndex++;
			} else {
				arr[k] = aux[rightIndex - l];
				rightIndex++;
			}
		}
	}
	
	
}
