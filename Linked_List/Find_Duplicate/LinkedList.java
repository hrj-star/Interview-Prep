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


	static int findDuplicates(Node head){
		int duplicate =  -1;
		while(head.next != null){
			Node ahead = head.next;
			while(ahead != null){
				if(head.data == ahead.data){
					duplicate = head.data;
				}
				ahead = ahead.next;
			}
			head = head.next;
		}
		return duplicate;
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
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
TC : O(n^2)
SC : O(1)







*/