/* Optimized : No Extra space / data structure used.*/

import java.util.*;

public class LinkedList3{

	Node head;
	 Node tail;
	 int size;

	static class Node{
		int data;
		Node next;
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


	public void display(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	public static boolean isPalindrome(Node head) {
          // get middle
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next!= null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// got middle at slow , assign to curr 
		// reverse from curr / middle to end
		Node curr = slow;
		Node prev = null;
		while(curr != null){
			Node nextNode = curr.next;
			curr.next = prev;
			prev =  curr;
			curr = nextNode;
		}

		// now prev pointing to last .  (fast/head) 1 -> 2 -> 3 <- 2 <- 1 (prev)
		//                                				      ⬇								
		//                                        			 null

		fast = head;
		while(prev != null){
			if(fast.data != prev.data){
				return false;
			}
			fast = fast.next;
			prev = prev.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedList3 llist1 = new LinkedList3();

        llist1.addLast(1);
        llist1.addLast(2);
        llist1.addLast(2);
        llist1.addLast(1);
 
 
        System.out.println("Linked List :");
        llist1.display();

        if(isPalindrome(llist1.head)){
        	System.out.println("\nPalindromic LL");
        }
        else{
        	System.out.println("\nNot Palindromic LL");
        }
	}
}


/*

Output :
----------------------
Linked List :
1 --> 2 --> 2 --> 1 --> NULL
Palindromic LL

Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 

*/