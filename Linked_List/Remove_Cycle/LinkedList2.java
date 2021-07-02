/* Optimized - No Extra space / data structure used. */

import java.util.*;

public class LinkedList2{
	private class Node{
		int data;
		Node next;
	}

	static Node head;
	static Node tail;
	static int size;

	public void display(){
		Node temp = this.head;
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

	static void removeCycle(Node loop , Node head){
		Node prev = head;

		while(prev.next != loop.next){ //  until next of prev and loop are not equal
			prev = prev.next;
			loop = loop.next;
		}

		loop.next = null; //  // Make next of loop to null
	}

	static Node detectCycle(Node head){
		Node fast = head;
		Node slow =  head;

		while(fast!= null  && fast.next!= null){
			slow = slow.next;
			fast = fast.next.next;

			// if they meet , then cycle detected

			if(slow == fast){
				return slow;
			}
		}
		return null;
	}


	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

		// insert cycle
		ll.head.next.next.next.next.next = ll.head.next;
		Node loop = detectCycle(head);

		if(loop!=null){
			removeCycle(loop,head);
			System.out.println("Cycle / Loop detected and Removed");
			ll.display();
		}
		else{
			System.out.println("Cycle / Loop not detected");
		}
	}
}


/*

Output :
----------------------

Cycle / Loop detected and Removed
10 --> 20 --> 30 --> 40 --> 50 --> NULL

Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 

*/