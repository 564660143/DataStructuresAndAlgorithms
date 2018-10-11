package tree.segment;

import org.junit.Test ;

public class SegmentTreeTest {
	
	@Test
	public void testBuild(){
		Integer[] nums = {2, 3, 4, -1 , -2, 3};
		// jdk8的lambda表达式写法
		SegmentTree<Integer> segment = new SegmentTree<>(nums, (a, b) -> a + b);
		System.out.println(segment) ;
		System.out.println(segment.query(1, 3)) ;
	}
	
	@Test
	public void testBuildSet(){
		Integer[] nums = {2, 3, 4, -1 , -2, 3};
		// jdk8的lambda表达式写法
		SegmentTree<Integer> segment = new SegmentTree<>(nums, (a, b) -> a + b);
		System.out.println(segment) ;
		segment.set(3, 1);
		segment.set(4, 2);
		System.out.println(segment) ;
	}
	
	
}
