public class LinkedList{
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


// O(n)

	public void removeLast(){
		if(size == 0){
			System.out.println("Empty LinkedList");
			return;
		}
		else{

			// base case
			if(size  == 1) // only 1 element and that is removed
			{
				head = null;
				tail = null;
				size = 0;
			}
			else{
				// get second last node 
				Node temp = head;
				while(temp.next.next != null){  // or getNodeAtIndex(size-2)
					temp = temp.next;
				}

				temp.next = null;  // change the second last node next pointer to null
				size--;
			}
		}
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);

		ll.display();

		ll.removeLast();

		System.out.println("After removing last node :");


		ll.display();
	}
}


/*

Output :
----------------------

10
20
30
40
50

After removing last node :

10
20
30
40


Complexity Analysis :
---------------------------

TC : O(n) worst case.
SC : O(1)

*/