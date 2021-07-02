/* 
Extra space / data structure used.
------------------------------------
Check if the element already exists in the map. If it exists, we have reached a node which already exists by a cycle, hence we need to make the last node’s next pointer NULL.
*/

import java.util.*;

public class LinkedList{
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

	static boolean removeCycle(Node head){
		Set<Node> set = new HashSet<Node>();
		Node prev = null;
		Node curr = head;

		while(curr!=null){
			if(set.contains(curr)){
				prev.next  = null;
				return true;
			}
			set.add(curr);
			prev =  curr;
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

		if(removeCycle(head)){
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

10 --> 20 --> 30 --> 40 --> NULL

Complexity Analysis :
---------------------------
TC : O(n) : single traversal needed.
SC : O(n) : as Set is used.

*/