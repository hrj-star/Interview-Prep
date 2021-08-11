import java.util.*;

public class LinkedList2{
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


	static int findDuplicates(Node head){
		int duplicate = 0;
		if(head == null){
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.data);

		for(Node curr = head.next;curr != null;curr = curr.next){
			if(set.contains(curr.data)){
				duplicate = curr.data;
			}
			set.add(curr.data);
		}
		return duplicate;
	}


	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.addLast(10);
		ll.addLast(7);
		ll.addLast(5);
		ll.addLast(2);
		ll.addLast(9);
		ll.addLast(1);
		ll.addLast(2);

		int dups = findDuplicates(ll.head);
		if(dups > 0){
			System.out.println("Duplicate : "+dups);
		}
		else{

			System.out.println("No duplicate exists");
		}
		
	}
}


/*

Output :
-----------------------

Duplicates : 2

Complexity Analysis :
---------------------------
TC : O(n)
SC : O(n)







*/