/*
Link : https://leetcode.com/problems/odd-even-linked-list/
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.
*/

import java.util.*;

class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList{

        public  static void display(Node head){
                Node temp = head;
                while(temp != null){
                        System.out.print(temp.data+" --> ");
                        temp = temp.next;
                }
                System.out.print("NULL");
        }

    public static Node rearrange(Node head) {
       if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node oddList = head;
        Node evenList = head.next;
        Node evenHead = evenList;
        
        while(evenList != null && evenList.next != null){
            oddList.next = evenList.next;
            oddList = oddList.next;
            evenList.next = oddList.next;
            evenList = evenList.next;
        }
        oddList.next = evenHead;
        return head;
   }

        public static void main(String[] args) {
        int[] keys = { 1,2,3,4,5 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        System.out.println("Linked List :");
        display(head);

         head = rearrange(head);

        System.out.println("\nRearranged Linked List :");

        display(head);
        }
}


/*

Output :
----------------------

Linked List :
1 --> 2 --> 3 --> 4 --> 5 --> NULL
Rearranged Linked List :
1 --> 3 --> 5 --> 2 --> 4 --> NULL


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 

*/