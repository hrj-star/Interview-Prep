/* Odd After Even */


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
        Node oddStart = null;
        Node evenStart = null;
        Node oddTail = null;
        Node evenTail = null;
        Node curr = head;

        while(curr != null){
                if(curr.data % 2 != 0) { // if odd
                        if(oddStart == null){ // for first node
                                oddStart = oddTail = curr;
                        }
                        else{
                                oddTail.next = curr;
                                oddTail = oddTail.next; 
                        }
                }
                else{
                        if(evenStart == null){
                                evenStart = evenTail = curr;
                        }
                        else{
                                evenTail.next = curr;
                                evenTail =  evenTail.next;
                        }
                }
                curr =  curr.next;
        }


        if(evenStart != null){  // if atleast one even , then even followed by odd
                head = evenStart;
                evenTail.next = oddStart;
        }
        else{
                head = oddStart;   // if no even , like 1 3 5 , then head = odd;
        }

        // null to terminate

        if(oddTail != null){
                oddTail.next = null;
        }
        return head;
   }

        public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 
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
1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10 --> NULL

Rearranged Linked List :
2 --> 4 --> 6 --> 8 --> 10 --> 1 --> 3 --> 5 --> 7 --> 9 --> NULL


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 

*/