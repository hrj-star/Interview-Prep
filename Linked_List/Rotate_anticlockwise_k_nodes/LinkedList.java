public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	static Node head;
	 Node tail;
	int size;


	public void display(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}
	
// O(1)
	public Node addLast(int item){
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
		return head;
	}

	public int getLength(Node head){
		Node temp = head;
		int count = 0;

		while(temp != null){
			temp = temp.next;
			count++;
		}

		return count;
	}

	public Node antirotateList(Node head, int k){
		if(head== null || k < 0){
			return head;
		}
		Node node = head;
		int length = getLength(node);
		k = k%length;
		if(k == 0){
			return node;
		}

		Node temp = node;
		int i=1;

		while(i < k){
			temp = temp.next;
			i++;
		}

		Node first = temp.next; // temp will be upto Node
		head = first;
		temp.next = null;

		i=1;

		while(first.next != null){
			first = first.next;
		}

		first.next = node;
		return head;

	}



	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.addLast(12);
		ll.addLast(99);
		ll.addLast(36);
		ll.addLast(8);
		ll.addLast(18);

		System.out.println("Original List :");
		ll.display(head);

		head = ll.antirotateList(head,2);

		System.out.println("\nRotated List :");
		ll.display(head);
	}
}


/*



Output :
-----------------------
Original List :
12 --> 99 --> 36 --> 8 --> 18 --> NULL
Rotated List :
36 --> 8 --> 18 --> 12 --> 99 --> NULL


Complexity Analysis :
---------------------------
TC : O(n)
SC : O(1)



*/