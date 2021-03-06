package sort.insert;

import org.junit.Test ;
import sort.selection.SelectionSort ;
import utils.ArrayUtil ;

public class InsertTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
//		new InsertSort().sort(arr);
		new InsertSort2().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	/**
	 * 测试选择排序和两次插入排序性能
	 */
	@Test
	public void testSort(){
		// 生成一个随机数组
		int[] arr = ArrayUtil.generateArray(100000, 0, 100000);
		int[] arr1 = ArrayUtil.copyArray(arr);
		int[] arr2= ArrayUtil.copyArray(arr);
		System.out.println("随机数组->选择排序 : " + ArrayUtil.testSort(arr, new SelectionSort()) + "s") ;
		System.out.println("随机数组->插入排序1 : " + ArrayUtil.testSort(arr1, new InsertSort()) + "s") ;
		System.out.println("随机数组->插入排序2 : " + ArrayUtil.testSort(arr2, new InsertSort2()) + "s") ;
		
		/*
		 * 生成一个近乎有序的数组
		 * 100000 : 数组元素个数
		 * 10 : 在一个完全有序的数组上进行多少次元素交换
		 */
		arr = ArrayUtil.generateNearlyOrderedArray(100000, 10);
		arr1 = ArrayUtil.copyArray(arr);
		arr2= ArrayUtil.copyArray(arr);
		System.out.println("近乎有序的数组->选择排序:" + ArrayUtil.testSort(arr, new SelectionSort()) + "s") ;
		System.out.println("近乎有序的数组->插入排序1:" + ArrayUtil.testSort(arr1, new InsertSort()) + "s") ;
		System.out.println("近乎有序的数组->插入排序2:" + ArrayUtil.testSort(arr2, new InsertSort2()) + "s") ;

	}
	
	
	
}
