package tree.avl;

import java.net.URL ;
import java.util.ArrayList ;
import org.junit.Test ;
import util.FileOperation ;

public class AVLTreeTest {
	
	/**
	 * 测试AVL树添加操作
	 */
	@Test
	public void testAVLAdd() {
		System.out.println("Pride and Prejudice") ;
		URL resource = this.getClass().getClassLoader().getResource("pride-and-prejudice.txt");
		ArrayList<String> words = new ArrayList<>() ;
		if (FileOperation.readFile(resource.getPath() , words)) {
			AVLTree<String, Integer> avlMap = new AVLTree<>();
			for (String word : words){
				avlMap.add(word, 0);
			}
			
			// isBST(), 辅助函数, 判断树是否符合二分搜索树特性
			System.out.println("AVL Tree is BST: " + avlMap.isBST()) ;
			// isBalanced(), 辅助函数, 判断树是否符合AVL树特性
			System.out.println("AVL Tree is isBalanced: " + avlMap.isBalanced()) ;
			
			// 删除操作
			for (String word : words){
				avlMap.remove(word);
				// 如果元素删除之后存在不符合二分搜索树或平衡二叉树的特性, 就打印错误日志
				if (!(avlMap.isBST() && avlMap.isBalanced())) {
					System.err.println("Error") ;
				}
			}
			
			// isBST(), 辅助函数, 判断树是否符合二分搜索树特性
			System.out.println("AVL Tree is BST: " + avlMap.isBST()) ;
			// isBalanced(), 辅助函数, 判断树是否符合AVL树特性
			System.out.println("AVL Tree is isBalanced: " + avlMap.isBalanced()) ;
		}
	}
	
	
}
