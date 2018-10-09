package tree.bst;

import org.junit.Test ;


public class BSTreeTest {
	static int[] nums = {5, 3, 6, 8, 4, 2};
	static BSTree<Integer> bsTree;
	static{
		bsTree = new BSTree<>();
		for (int i = 0; i < nums.length; i++) {
			bsTree.add(nums[i]);
		}
	}
	
	@Test
	public void testOrder() {
		
		
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
		
		System.out.println(bsTree) ;
		
		// 前序遍历, 5->3->2->4->6->8
		bsTree.preOrder();
		System.out.println("-------------------------------------------------") ;
		// 前序遍历非递归, 5->3->2->4->6->8
		bsTree.preOrderNR();
		// 中序遍历, 2->3->4->5->6->8
		bsTree.inOrder();
		System.out.println("-------------------------------------------------") ;
		// 后序遍历, 2->4->3->8->6->5
		bsTree.postOrder();
		
	}
	
	/**
	 * 测试二分搜索树删除
	 */
	@Test
	public void testRemove(){
		for (int i : nums) {
			System.out.println("------------------------" + i + "-------------------------") ;
			bsTree.remove(i);
			bsTree.inOrder();
		}
	}
	
}
