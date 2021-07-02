import java.util.*;

public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


// getAtIndex()

// O(n) : worst case can be the last element , so traverse entirely

	public void getAtIndex(int index) {
		if(size == 0){
			System.out.println("List is Empty");
			return;		
		}

		if(index<0 || index>=size){
			System.out.println("Invalid Index");
			return;
		}

		Node temp = this.head;
		for(int i=0;i < index;i++){
			temp=temp.next;
		}
		System.out.println("Value at index " + index +" is "+temp.data);
		
	}

 // getNodeAtIndex()

 // O(n) : worst case can be the last element , so traverse entirely
	private Node getNodeAtIndex(int index) {
		if(size == 0){
			System.out.println("List is Empty");
					
		}

		if(index<0 || index>=size){
			System.out.println("Invalid Index");
			
		}

		Node temp = this.head;
		for(int i=0;i < index;i++){
			temp=temp.next;
		}
		return temp;
	}


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

	


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

		// get at index

		ll.getAtIndex(0);
		ll.getAtIndex(1);
		ll.getAtIndex(2);
		ll.getAtIndex(3);
		ll.getAtIndex(4);
		ll.getAtIndex(5);

		// get node at index
		
		System.out.println(ll.getNodeAtIndex(0));
	}
}


/*

Output :

Value at index 0 is 10
Value at index 1 is 20
Value at index 2 is 30
Value at index 3 is 40
Value at index 4 is 50
Invalid Index


Complexity Analysis :
-----------------------------------
TC : O(n)
SC : No extra space


*/