/* Extra space / data structure used.*/

import java.util.*;

public class LinkedList{
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
		Set<Node> set = new HashSet<Node>();
		Node curr = head;

		while(curr!=null){
			if(set.contains(curr)){
				return true;
			}
			set.add(curr);
			curr = curr.next;
		}
		return false;
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
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
SC : O(n) : as Set is used.

*/