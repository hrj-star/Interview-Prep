public class LinkedList_As_Stack{

	private class Node{
		int data;
		Node next;
	}

	private Node top;
	private int size;

	LinkedList_As_Stack(){
		this.top = null;
	}

	public boolean isEmpty(){
		return top == null;
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("Stack Empty!");
			return -1;
		}
		else{
			return top.data;
		}
	}

	public void push(int item){  // addFirst()
		Node newNode = new Node();
		newNode.data = item;

		System.out.println("Inserting : "+item);

		if(top == null){ // if empty , then set next to null , meaning first element
			newNode.next = null;
		}
		else{
			newNode.next = top;
		}
		top = newNode;
	}

	public void pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow");
			return;
		}
		System.out.println("\nRemoving : " + peek());
		top = top.next;
	}

	public void display(){
		if(isEmpty()){
			System.out.println("Stack Empty!");
			return;
		}
		else{
			System.out.println("\nStack Contents are :");
			Node temp = top;
			while(temp!=null){
				System.out.print(temp.data+" --> ");
				temp = temp.next;
			}	

			System.out.print("NULL");	
		}
	}




public static void main(String[] args) {
		LinkedList_As_Stack ll = new LinkedList_As_Stack();
		ll.push(40);
		ll.push(30);
		ll.push(20);
		ll.push(10);

		ll.display();

		ll.pop();

		ll.display();

	}


}

/*

Output :
----------------------

Inserting : 40
Inserting : 30
Inserting : 20
Inserting : 10

Stack Contents are :
10 --> 20 --> 30 --> 40 --> NULL
Removing : 10

Stack Contents are :
20 --> 30 --> 40 --> NULL

*/