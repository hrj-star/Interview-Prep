/* Optimized : No Extra space / data structure used.

1. Using Floyd's Cycle Detection Algo / 'Tortoise and Hare' Algorithm
2. Initialize fast , slow pointers to head.
3. Move fast by 2 pointers and slow by 1. If they both meet at some point , means cycle detected ,  else not.

*/

import java.util.*;

public class LinkedList2{
	private class Node{
		int data;
		Node next;
	}

	static Node head;
	static Node tail;
	static int size;

	
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

	static boolean detectCycle(Node head){
		Node fast = head;
		Node slow = head;

		while(slow!=null && fast!=null && fast.next!=null){
				slow = slow.next;
				fast = fast.next.next;

				// if they meet , then cycle detected
				if(slow == fast){
					return true;
				}
		}
		return false;
	}


	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);


		// insert cycle
		ll.head.next.next.next.next = ll.head;

		if(detectCycle(head)){
			System.out.println("Cycle / Loop detected");
		}
		else{
			System.out.println("Cycle / Loop not detected");
		}
	}
}


/*

Output :
----------------------
Cycle / Loop detected

Complexity Analysis :
---------------------------
TC : O(n) : single traversal needed.
SC : O(1) : no extra space.

*/