public class LinkedList_As_Queue{

	private class Node{
		int data;
		Node next;
	}

	private Node front;
	private Node rear;
	private int size;

	LinkedList_As_Queue(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}


	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0; // or front == null 
	}

	public int front(){
		if(isEmpty()){
			System.out.println("Queue Empty!");
			return -1;
		}
		else{
			return front.data;
		}
	}

	public void enqueue(int item){  // addLast()
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;

		System.out.println("Inserting : "+item);

		if(this.size == 0) 
		{
			front = rear = newNode;
			this.size++;
		}
		else{
			rear.next = newNode;
			rear = newNode;
			this.size++;
		}
		
	}

	public void dequeue(){
		int toremove = front.data;
		front = front.next;
		if(isEmpty()){
			rear = null;
		}
		this.size--;

		System.out.println("\nRemoved : " + toremove);
	}

	public void display(){
		if(isEmpty()){
			System.out.println("Queue Empty!");
			return;
		}
		else{
			System.out.println("\nQueue Contents are :");
			Node temp = front;
			while(temp!=null){
				System.out.print(temp.data+" --> ");
				temp = temp.next;
			}	

			System.out.print("NULL");	
		}
	}




public static void main(String[] args) {
		LinkedList_As_Queue ll = new LinkedList_As_Queue();

		ll.display();

		ll.enqueue(10);
		ll.enqueue(20);
		ll.enqueue(30);
		ll.enqueue(40);

		ll.display();

		System.out.println("\nFront is:"+ll.front());

		ll.dequeue();
		ll.dequeue();
		ll.dequeue();
		ll.dequeue();

		ll.enqueue(50);
		ll.display();

	}


}

/*

Output :
----------------------

Queue Empty!

Inserting : 10
Inserting : 20
Inserting : 30
Inserting : 40

Queue Contents are :
10 --> 20 --> 30 --> 40 --> NULL

Front is:10

Removed : 10

Removed : 20

Removed : 30

Removed : 40

Inserting : 50

Queue Contents are :
50 --> NULL

*/