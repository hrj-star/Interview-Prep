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

		while(curr != null){
			Node temp = curr;

			while(temp != null && temp.data == curr.data){
				temp=temp.next;
			}
			curr.next = temp;
			curr =   curr.next;
		}

	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(6);
		ll.addLast(5);
		ll.addLast(5);
		ll.addLast(5);
		ll.addLast(4);
		ll.addLast(4);
		ll.addLast(3);
		ll.addLast(2);
		ll.addLast(2);
		

		System.out.println("Original List :");
		ll.display();

		removeDuplicates(ll.head);

		System.out.println("\nAfter Removing Duplicates");
		ll.display();
	}
}


/*

Traverse from the head of the sorted linked list.
While traversing, compare the current node with the next node.
If data of the next node is the same as the current node then delete the next node  and change next pointer to next node after duplicates.

Output :
-----------------------

Original List :
6 --> 5 --> 5 --> 5 --> 4 --> 4 --> 3 --> 2 --> 2 --> NULL
After Removing Duplicates
6 --> 5 --> 4 --> 3 --> 2 --> NULL

Complexity Analysis :
---------------------------
TC : O(n)
SC : O(1)




*/