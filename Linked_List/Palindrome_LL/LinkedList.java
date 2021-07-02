/* Extra space / data structure used.*/

import java.util.*;

public class LinkedList{
	static class Node{
		int data;
		Node next;
	}

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
          Stack<Integer> st = new Stack<Integer>();
          boolean isPalin = true;

          Node temp = head;
          while(temp != null){
          	st.push(temp.data);
          	temp = temp.next;
          }

          while(head != null){
          	int top = st.pop();
          	if(top == head.data){
          		isPalin = true;
          	}
          	else{
          		isPalin = false;
          		break;
          	}
          	head = head.next;
          }
          return isPalin;
    }
		


	public static void main(String[] args) {
		LinkedList llist1 = new LinkedList();

        llist1.addLast(1);
        llist1.addLast(2);
        llist1.addLast(3);
        llist1.addLast(4);
        llist1.addLast(3);
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
1 --> 2 --> 3 --> 4 --> 3 --> 2 --> 1 --> NULL

Palindromic LL

Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(n)

*/