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
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

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

10
20
30
40
50
First Element is : 10
Last Element is : 50



*/