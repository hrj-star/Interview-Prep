public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public void display(){
		Node temp = this.head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

// O(1)
	public void addFirst(int item){
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null; // start 

		if(size == 0){ // if first node
			head = newNode;
			tail = newNode;
			size++;
		}
		else{  // keep adding before the current
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

// O(1)
	public int getFirst(){
		if(size == 0){
			return 0;
		}
		else{
			return head.data;
		}
	}

// O(1)
	public int getLast(){
		if(size == 0){
			return 0;
		}
		else{
			return tail.data;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.addFirst(40);
		ll.addFirst(50);

		ll.display();

		// get first element

		int firstElement = ll.getFirst();

		if(firstElement == 0){
			System.out.println("LinkedList is Empty");
		}
		else{
			System.out.println("First Element is : " + firstElement);
		}

		// get last element

		int lastElement = ll.getLast();

		if(lastElement == 0){
			System.out.println("LinkedList is Empty");
		}
		else{
			System.out.println("Last Element is : " + lastElement);
		}
	}
}


/*

Output :

50
40
30
20
10
First Element is : 50
Last Element is : 10


*/