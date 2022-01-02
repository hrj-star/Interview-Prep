public class Client{
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("arts");
		trie.addWord("art");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("sea");
		trie.addWord("seen");
		trie.addWord("see");
		trie.addWord("amit");

		trie.display();

		System.out.println(trie.numWords()); // 8
	/*
		art
		arts
		amit
		bug
		boy
		sea
		see
		seen
     */

		// search
		System.out.println(trie.search("art")); // true
		System.out.println(trie.search("sea")); // true
		System.out.println(trie.search("saw")); // false

		// remove

		trie.remove("arts");
		trie.display();

		/*
		art
		amit
		bug
		boy
		sea
		see
		seen
		*/

		trie.remove("art");
		trie.display();


		/*
		amit
		bug
		boy
		sea
		see
		seen
		*/

		System.out.println(trie.numWords()); // 6
	}
}