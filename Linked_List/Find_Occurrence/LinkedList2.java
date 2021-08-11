/* Recursion */

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


	static int find_occurrence(Node head,int num){
		if(head == null){
			return 0;
		}

		if(head.data == num){
			return 1+find_occurrence(head.next,num);
		}
		return find_occurrence(head.next,num);
	}


	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.addLast(5);
		ll.addLast(7);
		ll.addLast(5);
		ll.addLast(1);
		ll.addLast(7);

		int X = 7;
		int countOccur = find_occurrence(ll.head , X); 

		if(countOccur > 0){
			System.out.println(X+" occurs : "+countOccur+" times");
		}
		else{
			System.out.println(X+" does not occur");
		}
		
	}
}


/*

Output :
-----------------------
7 occurs : 2 times

Complexity Analysis :
---------------------------
TC : O(n)
SC : recursion stack space






*/