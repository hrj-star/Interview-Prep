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


	static int countDuplicates(Node head){
		int count = 0;
		if(head == null){
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.data);

		for(Node curr = head.next;curr != null;curr = curr.next){
			if(set.contains(curr.data)){
				count++;
			}
			set.add(curr.data);
		}
		return count;
	}


	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.addLast(5);
		ll.addLast(7);
		ll.addLast(5);
		ll.addLast(1);
		ll.addLast(7);

		int dups = countDuplicates(ll.head);
		if(dups > 0){
			System.out.println("Duplicate Count : "+dups);
		}
		else{

			System.out.println("No duplicates exists");
		}
		
	}
}


/*

Output :
-----------------------

Duplicate Count: 2

Complexity Analysis :
---------------------------
TC : O(n)
SC : O(n)







*/