/* Extra space / data structure used.*/

import java.util.*;

public class LinkedList2{
	static class Node{
		int data;
		Node next;
	}

	static Node left = null;
	private Node head;
	private Node tail;
	private int size;

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
          if(head == null || head.next == null){
          	return true;
          }
          left = head;
          return isPal(head);
    }

    public static boolean isPal(Node right){
    	if(right == null){
    		return true;
    	}
    	if(!isPal(right.next)){
    		return false;
    	}
    	boolean res = left.data == right.data;
    	left = left.next;
    	return res;
    }
		


	public static void main(String[] args) {
		LinkedList2 llist1 = new LinkedList2();

        llist1.addLast(1);
        llist1.addLast(2);
        llist1.addLast(3);
        llist1.addLast(6);
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
1 --> 2 --> 3 --> 4 --> 3 --> 2 --> 1 --> NULL
Palindromic LL


Linked List :
1 --> 2 --> 3 --> 6 --> 1 --> NULL
Not Palindromic LL


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(n) => extra stack calls consideration , else O(1)

*/