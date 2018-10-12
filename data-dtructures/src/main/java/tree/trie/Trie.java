package tree.trie;

import java.util.HashMap ;
import java.util.Map ;

public class Trie {
	// Trie树根节点
	private Node root;
	private int size;
	
    public Trie(){
        root = new Node();
        size = 0;
    }
	
	/**
	 * 获取Trie存储的单词个数
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Trie树种添加单词
	 * @param word
	 */
	public void add(String word){
		Node cur = root;
		for(int i = 0; i  < word.length(); i++){
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			} 
			cur = cur.next.get(c);
		}
		
		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
		
	}
	
	/**
	 * Trie树查找, 查看Trie树种是否包含单词Word
	 */
	public boolean contains(String word){
		Node cur = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			} 
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
	
	
	/**
	 * 查看Trie中是否包含前缀为prefix的单词
	 * @param prefix
	 * @return
	 */
	public boolean prefix(String prefix){
		Node cur = root;
		for(int i = 0; i < prefix.length(); i++){
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			} 
			cur = cur.next.get(c);
		}
		return true;
	}
	
	
	
	
	private class Node{
		public boolean isWord;
		public Map<Character, Node> next;
		
		public Node(boolean isWord){
			this.isWord = isWord;
			next = new HashMap<>();
		}
		
		public Node(){
			this(false);
		}
		
	}
	
}
