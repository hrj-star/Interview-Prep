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
}
public class LinkedList{
    

    private Node head;
    private Node tail;
    private int size;


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
        Node  dummy = new Node();
        Node sorted = dummy;

        // base cases 
        if(headA == null){
            return headB;
        }
        else if(headB == null){
            return headA;
        }

        while(headA != null && headB != null){
            if(headA.data <= headB.data){
                sorted.next = headA;
                headA = headA.next;
            }
            else{
                sorted.next = headB;
                headB =  headB.next;
            }
            sorted = sorted.next;
        }

        // if any one is remaining

        while(headA != null){
            sorted.next = headA;
            headA = headA.next;
        }

         while(headB != null){
            sorted.next = headB;
            headB = headB.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list1.addLast(9);

        System.out.println("\nLinkedList 1 : ");
        list1.display();

        LinkedList list2 = new LinkedList();
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
SC : O(1) or O(n).



*/