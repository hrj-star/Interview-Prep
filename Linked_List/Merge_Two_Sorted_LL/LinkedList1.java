/* Recursive Approach */

class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
 
    Node() {}
    Node(int d){
        data = d;
        next = null;
    }
}
public class LinkedList1{
    
    Node head;
    Node tail;
    int size;

    public  void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
            System.out.print("NULL");
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



    public static Node sortedMerge(Node headA , Node headB){
        if(headA == null){
            return headB;
        }
        else if(headB == null){
            return headA;
        }

        Node result = null;
        if(headA.data <= headB.data){
            result = new Node(headA.data);
            result.next = sortedMerge(headA.next , headB);
        }
        else{
            result = new Node(headB.data);
            result.next = sortedMerge(headA,headB.next);
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedList1 list1 = new LinkedList1();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list1.addLast(9);

        System.out.println("\nLinkedList 1 : ");
        list1.display();

        LinkedList1 list2 = new LinkedList1();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);
        list2.addLast(10);

        System.out.println("\nLinkedList 2 : ");
        list2.display();

        list1.head = sortedMerge(list1.head , list2.head);

        System.out.println("\nSorted LinkedList : ");
        list1.display();

    }
}


/*

Output :
--------------------------
LinkedList 1 : 
1 --> 3 --> 5 --> 7 --> 9 --> NULL
LinkedList 2 : 
2 --> 4 --> 6 --> 8 --> 10 --> NULL
Sorted LinkedList : 
1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10 --> NULL


Complexity Analysis  :
---------------------------
TC : O(m+n)
SC : recursion stack



*/