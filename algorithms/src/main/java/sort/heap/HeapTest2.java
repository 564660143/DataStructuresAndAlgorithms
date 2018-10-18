package sort.heap;

import org.junit.Test ;
import sort.merge.MergeSort ;
import sort.merge.MergeSort2 ;
import sort.merge.MergeSort3 ;
import sort.merge.MergeSortBU ;
import sort.quick.QuickSort ;
import utils.ArrayUtil ;

public class HeapTest2 {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(1000, 0, 100);
		new HeapSort().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	/**
	 * 测试插入排序和归并排序性能
	 */
	@Test
	public void testSort(){
		// 生成一个随机数组
		int[] arr = ArrayUtil.generateArray(1000000, 0, 1000000);
		int[] arr1 = ArrayUtil.copyArray(arr);
		int[] arr2 = ArrayUtil.copyArray(arr);
		int[] arr3 = ArrayUtil.copyArray(arr);
		int[] arr4 = ArrayUtil.copyArray(arr);
		int[] arr5 = ArrayUtil.copyArray(arr);
		System.out.println("----------------------------------随机数组----------------------------------") ;
		System.out.println("归并排序1 : " + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("归并排序2 : " + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("归并排序3 : " + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("自底向上的归并排序 : " + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;
		System.out.println("快速排序 : " + ArrayUtil.testSort(arr, new QuickSort()) + "s") ;
		System.out.println("堆排序 : " + ArrayUtil.testSort(arr5, new HeapSort()) + "s") ;

		/*
		 * 生成一个近乎有序的数组
		 * 100000 : 数组元素个数
		 * 10 : 在一个完全有序的数组上进行多少次元素交换
		 */
		arr = ArrayUtil.generateNearlyOrderedArray(1000000, 100);
		arr1 = ArrayUtil.copyArray(arr);
		arr2 = ArrayUtil.copyArray(arr);
		arr3 = ArrayUtil.copyArray(arr);
		arr4 = ArrayUtil.copyArray(arr);
		arr5 = ArrayUtil.copyArray(arr);
		System.out.println("------------------------------近乎有序的数组------------------------------") ;
		System.out.println("归并排序1:" + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("归并排序2:" + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("归并排序3:" + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("自底向上的归并排序:" + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;
		System.out.println("快速排序 : " + ArrayUtil.testSort(arr, new QuickSort()) + "s") ;
		System.out.println("堆排序 : " + ArrayUtil.testSort(arr5, new HeapSort()) + "s") ;
	}
	
	
	
}
