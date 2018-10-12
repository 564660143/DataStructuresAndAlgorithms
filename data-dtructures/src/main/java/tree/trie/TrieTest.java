package tree.trie ;

import java.net.URL ;
import java.util.ArrayList ;
import org.junit.Test ;
import set.BSTSet ;
import util.FileOperation ;

public class TrieTest {
	
	@Test
	public void testTrieAndBSTree() {
		System.out.println("Pride and Prejudice") ;
		URL resource = this.getClass().getClassLoader().getResource("pride-and-prejudice.txt");
		System.out.println(resource.getPath()) ;
		ArrayList<String> words = new ArrayList<>() ;
		if (FileOperation.readFile(resource.getPath() , words)) {
			long startTime = System.nanoTime() ;
			
			BSTSet<String> set = new BSTSet<>() ;
			for (String word : words)
				set.add(word) ;
			
			for (String word : words)
				set.contains(word) ;
			
			long endTime = System.nanoTime() ;
			
			double time = (endTime - startTime) / 1000000000.0 ;
			
			System.out.println("Total different words: " + set.getSize()) ;
			System.out.println("BSTSet: " + time + " s") ;
			
			// ---
			
			startTime = System.nanoTime() ;
			
			Trie trie = new Trie() ;
			for (String word : words)
				trie.add(word) ;
			
			for (String word : words)
				trie.contains(word) ;
			
			endTime = System.nanoTime() ;
			
			time = (endTime - startTime) / 1000000000.0 ;
			
			System.out.println("Total different words: " + trie.getSize()) ;
			System.out.println("Trie: " + time + " s") ;
		}
	}
	
}
