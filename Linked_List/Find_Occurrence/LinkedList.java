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


	static int find_occurrence(Node head,int num){
		int count = 0;
		Node temp = head;
		while(temp != null){
			if(temp.data == num){
				count++;
			}
			temp = temp.next;
		}
		return count;
	}


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
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
SC : O(1)







*/