package sort.heap;

import org.junit.Test;

import sort.merge.MergeSort;
import sort.merge.MergeSort2;
import sort.merge.MergeSort3;
import sort.merge.MergeSortBU;
import sort.quick.QuickSort;
import sort.quick.QuickSort2;
import sort.quick.QuickSort3;
import sort.quick.QuickSort3Ways;
import utils.ArrayUtil;

public class HeapTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
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
		int[] arr6 = ArrayUtil.copyArray(arr);
		int[] arr7 = ArrayUtil.copyArray(arr);
		int[] arr8 = ArrayUtil.copyArray(arr);
		System.out.println("----------------------------------随机数组----------------------------------") ;
		System.out.println("归并排序1 : " + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("归并排序2 : " + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("归并排序3 : " + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("自底向上的归并排序 : " + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;
		System.out.println("快速排序 : " + ArrayUtil.testSort(arr, new QuickSort()) + "s") ;
        System.out.println("快速排序2 : " + ArrayUtil.testSort(arr5, new QuickSort2()) + "s") ;
        System.out.println("快速排序3 : " + ArrayUtil.testSort(arr6, new QuickSort3()) + "s") ;
        System.out.println("三路快速排序 : " + ArrayUtil.testSort(arr7, new QuickSort3Ways()) + "s") ;
        System.out.println("堆排序 : " + ArrayUtil.testSort(arr8, new HeapSort()) + "s") ;

		/*
		 * 生成一个近乎有序的数组
		 * 100000 : 数组元素个数
		 * 10 : 在一个完全有序的数组上进行多少次元素交换
		 */
        arr = ArrayUtil.generateNearlyOrderedArray(1000000, 10);
		arr1 = ArrayUtil.copyArray(arr);
		arr2 = ArrayUtil.copyArray(arr);
		arr3 = ArrayUtil.copyArray(arr);
		arr4 = ArrayUtil.copyArray(arr);
	    arr5 = ArrayUtil.copyArray(arr);
	    arr6 = ArrayUtil.copyArray(arr);
	    arr7 = ArrayUtil.copyArray(arr);
	    arr8 = ArrayUtil.copyArray(arr);
		System.out.println("------------------------------近乎有序的数组------------------------------") ;
		System.out.println("归并排序1:" + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
		System.out.println("归并排序2:" + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
		System.out.println("归并排序3:" + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
		System.out.println("自底向上的归并排序:" + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;
		System.out.println("快速排序 : " + ArrayUtil.testSort(arr, new QuickSort()) + "s") ;
        System.out.println("快速排序2 : " + ArrayUtil.testSort(arr5, new QuickSort2()) + "s") ;
        System.out.println("快速排序3 : " + ArrayUtil.testSort(arr6, new QuickSort3()) + "s") ;
        System.out.println("三路快速排序 : " + ArrayUtil.testSort(arr7, new QuickSort3Ways()) + "s") ;
        System.out.println("堆排序 : " + ArrayUtil.testSort(arr8, new HeapSort()) + "s") ;

	      /*
         * 生成一个存在大量重复元素的数组
         * 100000 : 数组元素个数
         */
        arr = ArrayUtil.generateArray(1000000, 0,  100);
        arr1 = ArrayUtil.copyArray(arr);
        arr2 = ArrayUtil.copyArray(arr);
        arr3 = ArrayUtil.copyArray(arr);
        arr4 = ArrayUtil.copyArray(arr);
        arr5 = ArrayUtil.copyArray(arr);
        arr6 = ArrayUtil.copyArray(arr);
        arr7 = ArrayUtil.copyArray(arr);
        arr8 = ArrayUtil.copyArray(arr);
        System.out.println("------------------------------存在大量重复元素的数组------------------------------") ;
        System.out.println("归并排序1:" + ArrayUtil.testSort(arr1, new MergeSort()) + "s") ;
        System.out.println("归并排序2:" + ArrayUtil.testSort(arr2, new MergeSort2()) + "s") ;
        System.out.println("归并排序3:" + ArrayUtil.testSort(arr3, new MergeSort3()) + "s") ;
        System.out.println("自底向上的归并排序:" + ArrayUtil.testSort(arr4, new MergeSortBU()) + "s") ;
        System.out.println("快速排序 : " + ArrayUtil.testSort(arr, new QuickSort()) + "s") ;
        System.out.println("快速排序2 : " + ArrayUtil.testSort(arr5, new QuickSort2()) + "s") ;
        System.out.println("快速排序3 : " + ArrayUtil.testSort(arr6, new QuickSort3()) + "s") ;
        System.out.println("三路快速排序 : " + ArrayUtil.testSort(arr7, new QuickSort3Ways()) + "s") ;
        System.out.println("堆排序 : " + ArrayUtil.testSort(arr8, new HeapSort()) + "s") ;

	}
	
	
	
}
