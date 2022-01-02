import java.util.*;

public class HuffmanEncoder{
	HashMap<Character,String> encoder;
	HashMap<String,Character> decoder;


		public HuffmanEncoder(String feeder){ // constructor
		// 1. Create a frequency map of this feeder string
		HashMap<Character,Integer> freqmap = new HashMap<>();

		for(int i=0;i<feeder.length();i++){
			char c = feeder.charAt(i);
			if(freqmap.containsKey(c)){
				freqmap.put(c,freqmap.get(c) + 1);
			}
			else{
				freqmap.put(c,1);
			}
		}   // for close


		//2.Create minheap of Trees/Nodes -- Min Heap is used as a priority queue.

		GenericHeap<Node> minheap =  new GenericHeap<>(); // minheap
		Set<Map.Entry<Character,Integer>> entrysetFreqmap = freqmap.entrySet();
		for(Map.Entry<Character,Integer> entry : entrysetFreqmap){
			Node node = new Node(entry.getKey(),entry.getValue()); // create new node
			minheap.add(node);
		}

		//3. Combine nodes until one left in heap
		while(minheap.size() != 1){
			Node minone = minheap.remove();
			Node mintwo = minheap.remove();

			Node combined = new Node(minone,mintwo);
			combined.data = '\0';
			combined.cost = minone.cost + mintwo.cost;
			minheap.add(combined);

		}

		// full tree
		Node fulltree = minheap.remove();
	    this.encoder = new HashMap<>();//initialize encoder decoder
	    this.decoder = new HashMap<>();

	    this.initEncoderDecoder(fulltree,"");

	}


	// filling encoder decoder
	private void initEncoderDecoder(Node node , String output_so_far){
		// base case
	
		// if node is null , return
		if(node == null){
			return;
		}

		// if node does not have left , right child
		if(node.left == null && node.right == null){
			this.encoder.put(node.data,output_so_far);
			this.decoder.put(output_so_far,node.data);
		}

		this.initEncoderDecoder(node.left,output_so_far + "0");
		this.initEncoderDecoder(node.right,output_so_far + "1");
	}


	public String encode(String source){
		String s = "";
		for(int i=0;i<source.length();i++){
			String code = this.encoder.get(source.charAt(i));
			s+=code;
		}

		return s;
	}


	public String decode(String codedString){
		String s = "";
		String key = "";
		for(int i=0;i<codedString.length();i++){
			key += codedString.charAt(i);
			
			if(this.decoder.containsKey(key)){ // if 010 -> if 0 is a , and 10 is b , so take 10 as whole when only in map and skip 1 as individual
				s+=this.decoder.get(key);
				key = "";
			}
		}

		return s;
	}


	

		private class Node implements Comparable<Node>{
			Character data;
			int cost;
			Node left;
			Node right;

			// constructor
			Node (Character data, int cost){
				this.data=data;
				this.cost=cost;
				left=null;
				right=null;
			}

			// constructor
			Node(Node left, Node right){
				this.left = left;
				this.right = right;
			}

			@Override
			public int compareTo(Node o){
				return (this.cost == o.cost) ? this.data-o.data : this.cost-o.cost;
			}
		}

}