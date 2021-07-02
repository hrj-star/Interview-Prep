/* Steps 
One Pass Solution
2 pointers : 

Fast : Fast-forward by 2 nodes.
Slow : Fast-forward by 1 node.

After iterating entire , fast will point to last , and slow points to middle.

*/

import java.util.*;

public class LinkedList2{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public void getAtMiddle(){
		Node fast = head;
		Node slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		System.out.println(slow.data);
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
	

		ll.getAtMiddle();
	}
}


/*

Output :

For : 10 20 30 40 50    : 30
For : 10 20 30 40 50 60 : 40

Complexity Analysis :
-----------------------------------
TC : O(n)
SC : O(1)


*/