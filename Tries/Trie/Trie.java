import java.util.*;

public class Trie{
	private class Node {
		char data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(char data, boolean isTerminal) {
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = isTerminal;
		}
	}

	private int numWords;
	private Node root;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	// return no of words
	public int numWords() {
		return this.numWords;
	}

	// addWord() - add new word in trie
	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				// Word already exists
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}

		char first = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(first);
		if (child == null) {
			child = new Node(first, false);
			parent.children.put(first, child);
		}
		this.addWord(child, ros);
	}

	// display() - display in trie
	public void display() {
		this.display(this.root, "");
	}

	private void display(Node node, String output_so_far) {
		if (node.isTerminal) {
			String todisplay = output_so_far.substring(1) + node.data;
			System.out.println(todisplay);
		}
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for (Map.Entry<Character, Node> entry : entries) {
			this.display(entry.getValue(), output_so_far + node.data);
		}
	}

	// search in trie

	public boolean search(String word){
		return this.search(this.root,word);
	}

	private boolean search(Node parent , String word){
		//  base case - if word length becomes 0
		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true ; // Word exists
			} else {
				return false;
			}
		}

		char first = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(first);
		if (child == null) {
			return false; // if first not found
		}

		return this.search(child,ros); // recur child node for finding ros 
	}

	// remove from trie

	public void remove(String word){
		 this.remove(this.root,word);
	}

	private void remove(Node parent, String word){

		//  base case - if word length becomes 0
		if (word.length() == 0) {
			if (parent.isTerminal) { // if parent is terminal then set as non terminal and count --
				parent.isTerminal = false;
				this.numWords--;
			} else {
				// word is a part of some another word
			}
			return;
		}

		char first = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(first);
		if (child == null) {
			return ; // if first not found then return
		}

		this.remove(child,ros);

		if(!child.isTerminal && child.children.size() == 0){
			parent.children.remove(first);
		}
	}


}