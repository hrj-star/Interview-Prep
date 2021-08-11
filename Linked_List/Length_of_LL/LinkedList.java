public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public void display(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	
// O(1)
	public void addLast(int item){
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null; // start 

		if(size == 0){ // if first node
			head = newNode;
			tail = newNode;
			size++;
		}
		else{  // keep adding next
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}


	public int getLength(){
		Node temp = head;
		int count = 0;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}

	public int recursiveLength(Node node){
		if(node == null){
			return 0;
		}
		return 1 + recursiveLength(node.next);
	}




	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

		int len = ll.getLength();
		System.out.println(len);
		int rec_len = ll.recursiveLength(ll.head);
		System.out.println(rec_len);
		
	}
}


/*

Output :
----------------------
5
5

Complexity Analysis :
-----------------------------------
TC : O(n)
SC : O(1)

*/