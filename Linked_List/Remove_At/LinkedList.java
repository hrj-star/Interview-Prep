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


// getNodeAtIndex()

 // O(n) : worst case can be the last element , so traverse entirely
	private Node getNodeAtIndex(int index) {
		if(size == 0){
			System.out.println("List is Empty");
					
		}

		if(index<0 || index>=size){
			System.out.println("Invalid Index");
			
		}

		Node temp = this.head;
		for(int i=0;i < index;i++){
			temp=temp.next;
		}
		return temp;
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

	public void removeAt(int idx){
		if(size == 0){
			System.out.println("Empty LinkedList");
			return;
		}

		if(idx<0 || idx>=size){
			System.out.println("Invalid Index");
			return;
		}

		if(idx == 0){  // removeFirst
			head = head.next;
			size--;
		}
		else if(idx == size-1){ // remove last
			// get second last node 
				Node temp = head;
				while(temp.next.next != null){  // or getNodeAtIndex(size-2)
					temp = temp.next;
				}

				temp.next = null;  // change the second last node next pointer to null
				size--;
		}

		// remove intermediary 
		else{

			Node previous = getNodeAtIndex(idx-1); // get previous node
			Node nextNode = previous.next.next; // get next node or getNodeAtIndex(idx+1)
			previous.next = nextNode; // link previous and node
			size--; // dec size
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

		ll.removeAt(0);
		ll.removeAt(2);




		System.out.println("After removing the nodes :");


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

After removing the nodes :

20
30
50

Complexity Analysis :
---------------------------

TC : O(n) worst case.
SC : O(1)

*/