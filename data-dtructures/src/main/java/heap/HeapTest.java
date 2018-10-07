package heap;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Random ;
import org.junit.Test ;

public class HeapTest {
	
	private static MaxHeap<Integer> maxHeap = new MaxHeap<>();
	private static Random random = new Random();
	private static int nums = 10000000;
	static {
		for(int i = 0; i < nums ; i++ ){
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}
	}
	
	@Test
	public void testBasic(){
		int arr[] = new int[nums];
		for(int i = 0; i < nums; i++ ){
			arr[i] = maxHeap.extractMax();
		}
		
		for(int i = 1; i < nums; i++ ){
			if (arr[i - 1] < arr[i]) {
				System.err.println(arr[i - 1]) ;
//				System.err.println("ERROR") ;
			}
		}
		
		System.out.println("MaxHeap 测试完成") ;
	}
	
	
	@Test
	public void testHeapify(){
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums ; i++ ){
			list.add(random.nextInt(Integer.MAX_VALUE));
		}
		// 非heapify方式
		double t1 = testListCovertMapHeap(list, false);
		System.out.println("非Heapify方式操作耗时 : " + t1) ;
		System.out.println() ;
		double t2 = testListCovertMapHeap(list, true);
		System.out.println("Heapify方式操作耗时 : " + t2) ;
	}
	
	/**
	 * 返回消耗时间
	 */
	private double testListCovertMapHeap(List<Integer> list, boolean isHeapify){
		long startTime = System.currentTimeMillis();
		if (isHeapify) {
			MaxHeap<Integer>maxHeap = new MaxHeap<>(list);
		} else {
			MaxHeap<Integer>maxHeap = new MaxHeap<>();
			for (Integer integer : list) {
				maxHeap.add(integer);
			}
		}
		
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) / 1000.0;
	}
	
}
