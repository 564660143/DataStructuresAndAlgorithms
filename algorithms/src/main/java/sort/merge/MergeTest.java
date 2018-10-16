package sort.merge;

import org.junit.Test ;
import sort.insert.InsertSort2 ;
import utils.ArrayUtil ;

public class MergeTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
		new MergeSort().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	/**
	 * 测试插入排序和归并排序性能
	 */
	@Test
	public void testSort(){
		// 生成一个随机数组
		int[] arr = ArrayUtil.generateArray(100000, 0, 100000);
		int[] arr1 = ArrayUtil.copyArray(arr);
		int[] arr2 = ArrayUtil.copyArray(arr);
		int[] arr3 = ArrayUtil.copyArray(arr);
		int[] arr4 = ArrayUtil.copyArray(arr);
		System.out.println("随机数组->插入排序 : " + ArrayUtil.testSort(arr, new InsertSort2()) + "s") ;
		System.out.println("随机数组->归并排序1 : " + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("随机数组->归并排序2 : " + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("随机数组->归并排序3 : " + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("随机数组->自底向上的归并排序 : " + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;

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
		System.out.println("近乎有序的数组->插入排序:" + ArrayUtil.testSort(arr, new InsertSort2()) + "s") ;
		System.out.println("近乎有序的数组->归并排序1:" + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("近乎有序的数组->归并排序2:" + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("近乎有序的数组->归并排序3:" + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("近乎有序的数组->自底向上的归并排序:" + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;

	}
	
	
	
}
