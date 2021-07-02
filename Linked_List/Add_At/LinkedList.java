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

	public void addFirst(int item){
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null; // start 

		if(size == 0){ // if first node
			head = newNode;
			tail = newNode;
			size++;
		}
		else{  // keep adding before the current
			newNode.next = head;
			head = newNode;
			size++;
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

// O(n)

	public void addAt(int item , int idx){
		if(idx < 0 || idx > size){
			System.out.println("Invalid index");
			return;
		}

		if(idx == 0){
			addFirst(item);
		}
		else if(idx == this.size){
			addLast(item);
		}
	    

		else{
			// create new node
			Node newNodeAdd = new  Node();
			newNodeAdd.data = item;
			newNodeAdd.next =  null; 

			// prehand steps

			Node prevNode = getNodeAtIndex(idx - 1); // get previous node
			Node nextNode = prevNode.next; // or getNodeAtIndex(idx)- get next node i.e at index at which current will be inserted
			prevNode.next = newNodeAdd;
			newNodeAdd.next = nextNode;

			// post - update - just update size as new element added

			this.size++;

		}
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addAt(10,0);
		ll.addAt(20,1);
		ll.addAt(30,2);
		ll.addAt(40,1);
		

		ll.display();

	}
}


/*

Output :

10
40
20
30


Complexity Analysis :
----------------------------

TC : O(n) : worst case traverse till end in getNodeAtIndex()
SC : Constant space


*/