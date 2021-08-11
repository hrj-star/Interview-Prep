import java.util.*;

public class LinkedList{
	private class Node{
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;


	public void display(){
		Node temp = head;
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


	static void removeDuplicates(Node head){
		Node curr = head;
		Node  prev = null;
		Set<Integer> set = new HashSet<Integer>();

		while(curr != null){
			if(!set.add(curr.data)){
				prev.next = curr.next;
			}
			else{
				prev = curr;
			}
			curr =  curr.next;
		}
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(6);
		ll.addLast(2);
		ll.addLast(2);
		ll.addLast(4);
		ll.addLast(4);
		ll.addLast(3);
				
		System.out.println("Original List :");
		ll.display();

		removeDuplicates(ll.head);

		System.out.println("\nAfter Removing Duplicates");
		ll.display();
	}
}


/*

Traverse from the head of the sorted linked list.
While traversing, if element already exists in set , then make prev pointer pointer to curr next.


Output :
-----------------------

Original List :
6 --> 2 --> 2 --> 4 --> 4 --> 3 --> NULL
After Removing Duplicates
6 --> 2 --> 4 --> 3 --> NULL

Complexity Analysis :
---------------------------
TC : O(n)
SC : O(n)




*/