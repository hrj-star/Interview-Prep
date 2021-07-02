/* Iterative version */

public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public void reverse(){
		Node previous = null;
		Node current = head;

		while(current != null){
			Node nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		head = previous;

		
	}
	public void display(){
		Node temp = this.head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

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

	


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

		System.out.println("Original List :");

		ll.display();

		ll.reverse();

		System.out.println("Reversed List :");

		ll.display();
	}
}


/*

Output :

Original List :
10
20
30
40
50
Reversed List :
50
40
30
20
10


Complexity Analysis :
-----------------------------------
TC : O(n)
SC : No extra space


*/