/* Optimized : No Extra space / data structure used.*/

import java.util.*;

public class LinkedList2{
	static class Node{
		int data;
		Node next;
	}

	private Node head,headA,headB;
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

	public static Node getIntersectionNode(Node headA, Node headB) {
        Node n1 = headA;
        Node n2 = headB;

        while(n1 != n2){
        	n1 = n1.next;
        	n2 = n2.next;

        	if(n1 == n2){
        		return n1;
        	}
        	if(n1 == null){
        		n1 = headB;
        	}
        	if(n2 == null){
        		n2 = headA;
        	}
        }

       	return n1;
    }
		
		


	public static void main(String[] args) {
		LinkedList2 llist1 = new LinkedList2();
        LinkedList2 llist2 = new LinkedList2();


        llist1.addLast(1);
        llist1.addLast(2);
        llist1.addLast(3);
        llist1.addLast(4);
        llist1.addLast(5);
        llist1.addLast(6);
        llist1.addLast(7);
 
      
        llist2.addLast(10);
        llist2.addLast(8);
        llist2.addLast(9);

        // link the list or if separate then set.add(headA.data) compare if(set.contains(headB.data)) in getIntersectionNode()

        llist2.head.next.next.next = llist1.head.next.next.next;
 
		

        System.out.println("List 1 :");
        llist1.display();

        System.out.println("\nList 2 :");
        llist2.display();

        Node commonPoint = getIntersectionNode(llist1.head, llist2.head);

        if(commonPoint != null){
        	System.out.println("\nCommon Point is "+commonPoint.data);
        }
        else{
        	System.out.println("Lists do not intersect");
        } 
	}
}


/*

Output :
----------------------
List 1 :
1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> NULL

List 2 :
10 --> 8 --> 9 --> 4 --> 5 --> 6 --> 7 --> NULL

Common Point is 4

Complexity Analysis :
---------------------------
TC : O(m+n) 
SC : O(1) 

*/