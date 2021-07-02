


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

public class EvenAfterOdd{

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


        if(oddStart != null){
                head = oddStart;
                oddTail.next = evenStart;
        }
        else{
                head = evenStart;   
        }

        // null to terminate

        if(evenTail != null){
                evenTail.next = null;
        }
        return head;
   }

        public static void main(String[] args) {
        int[] keys = { 1 ,2 ,2 ,2 ,1 };
 
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
1 --> 2 --> 2 --> 2 --> 1 --> NULL

Rearranged Linked List :
1 --> 1 --> 2 --> 2 --> 2 --> NULL


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 

*/