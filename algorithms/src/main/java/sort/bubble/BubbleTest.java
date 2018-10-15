package sort.bubble;

import org.junit.Test ;
import sort.insert.InsertSort ;
import sort.insert.InsertSort2 ;
import sort.selection.SelectionSort ;
import utils.ArrayUtil ;

public class BubbleTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
//		new InsertSort().sort(arr);
		new BubbleSort().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	/**
	 * 测试选择排序和两种插入排序已及两种冒泡排序的性能
	 */
	@Test
	public void testSort(){
		// 生成一个随机数组
		int[] arr = ArrayUtil.generateArray(100000, 0, 100000);
		int[] arr1 = ArrayUtil.copyArray(arr);
		int[] arr2 = ArrayUtil.copyArray(arr);
		int[] arr3 = ArrayUtil.copyArray(arr);
		int[] arr4 = ArrayUtil.copyArray(arr);
		System.out.println("随机数组->选择排序 : " + ArrayUtil.testSort(arr, new SelectionSort()) + "s") ;
		System.out.println("随机数组->插入排序1 : " + ArrayUtil.testSort(arr1, new InsertSort()) + "s") ;
		System.out.println("随机数组->插入排序2 : " + ArrayUtil.testSort(arr2, new InsertSort2()) + "s") ;
		System.out.println("随机数组->冒泡排序1 : " + ArrayUtil.testSort(arr3, new BubbleSort()) + "s") ;
		System.out.println("随机数组->冒泡排序2 : " + ArrayUtil.testSort(arr4, new BubbleSort2()) + "s") ;

		/*
		 * 生成一个近乎有序的数组
		 * 100000 : 数组元素个数
		 * 10 : 在一个完全有序的数组上进行多少次元素交换
		 */
		arr = ArrayUtil.generateNearlyOrderedArray(100000, 10);
		arr1 = ArrayUtil.copyArray(arr);
		arr2 = ArrayUtil.copyArray(arr);
		arr3 = ArrayUtil.copyArray(arr);
		arr4 = ArrayUtil.copyArray(arr);
		System.out.println("近乎有序的数组->选择排序:" + ArrayUtil.testSort(arr, new SelectionSort()) + "s") ;
		System.out.println("近乎有序的数组->插入排序1:" + ArrayUtil.testSort(arr1, new InsertSort()) + "s") ;
		System.out.println("近乎有序的数组->插入排序2:" + ArrayUtil.testSort(arr2, new InsertSort2()) + "s") ;
		System.out.println("近乎有序的数组->冒泡排序1:" + ArrayUtil.testSort(arr3, new BubbleSort()) + "s") ;
		System.out.println("近乎有序的数组->冒泡排序2:" + ArrayUtil.testSort(arr4, new BubbleSort2()) + "s") ;

	}
	
	
	
}
