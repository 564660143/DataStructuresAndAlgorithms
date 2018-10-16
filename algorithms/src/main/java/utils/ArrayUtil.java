package utils;

import java.util.Random ;
import sort.Sort ;

public class ArrayUtil {
	
	/**
	 * 生成int型随机测试数组
	 * @param n : 数组元素个数
	 * @param left : 数组最小值
	 * @param right : 数组元素最大值
	 * @return 
	 */
	public static int[] generateArray(int n, int left, int right){
		int[] arr = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(right - left) + left;
		}
		
		return arr;
	}
	
	/**
	 * 生成一个近乎有序的数组
	 * 1. 首先生成一个完全有序的数组
	 * 2. 然后对这个完全有序的数组进行一定次数的位置交换
	 * @param n : 数组元素个数
	 * @param swapTimes : 数组交换次数
	 * @return 
	 */
	public static int[] generateNearlyOrderedArray(int n, int swapTimes){
		int[] arr = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < swapTimes; i++) {
			int rand1 = random.nextInt(n);
			int rand2 = random.nextInt(n);
			swap(arr, rand1, rand2);
		}
		
		return arr;
	}
	
	/**
	 * 判读数组是否是一个从小到大排好序的数组
	 * @return
	 */
	public static boolean isSorted(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			if (arr[i -1] > arr[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 交换数组中两个元素位置
	 * @param arr
	 * @param first
	 * @param second
	 */
	public static void swap(int[] arr, int first, int second){
		if (first > arr.length || second > arr.length) {
			throw new IllegalArgumentException("下标越界");
		}
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	/**
	 * 数组打印
	 * @param arr
	 */
	public static void printArray(int[] arr){
		System.out.print("[") ;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]) ;
			if (i != arr.length - 1) {
				System.out.print(", ") ;
			}
		}
		System.out.println("]") ;
	}
	
	/**
	 * 返回排序算法时间
	 * @param arr
	 * @param sort
	 * @return
	 */
	public  static double testSort(int[] arr, Sort sort){
		long startTime = System.currentTimeMillis();
		sort.sort(arr);
		long endTime = System.currentTimeMillis();
		if (!isSorted(arr)) {
			throw new RuntimeException("数组排序失败");
		}
		return (endTime - startTime) / 1000.0;
	}
	
	/**
	 * 数组拷贝, 返回一个数组的深度拷贝对象
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int[] arr){
		int [] copyArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copyArr[i] = arr[i];
		}
		return copyArr;
	}
	
	/**
	 * 对数组arr的[l, r]的区间进行插入排序
	 * @param arr
	 * @param l
	 * @param r
	 */
	public static void insertSort(int[] arr, int l, int r){
		for (int i = l; i <= r; i++) {
			int temp = arr[i];
			int insertIndex;
			for (insertIndex = i; insertIndex > l && arr[insertIndex - 1] > temp ; insertIndex--) {
				arr[insertIndex] = arr[insertIndex - 1];
			}
			// 循环结束, j的位置就是元素i应该插入的位置
			arr[insertIndex] = temp;
		}
	}
	
}
