/* Steps 
Two Pass Solution
Find length , then return (length/2) th node.

*/

import java.util.*;

public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public int getLength(){
		Node temp = head;
		int count = 0;

		while(temp != null){
			temp = temp.next;
			count++;
		}

		return count;
	}

	public void getAtMiddle(){
		int length = getLength();
		int mid = length/2;
		Node midNode = head;
		int i = 0;

		while(i < mid ){
			midNode = midNode.next;
			i = i+1;
		}

		System.out.println(midNode.data);
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
		ll.addLast(60);

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